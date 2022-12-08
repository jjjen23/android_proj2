package com.example.myapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Phonebook_Fragment extends Fragment {

    RecyclerView recyclerView;
    PeopleAdapter adapter;

    Context context;
    OnTabItemSelectedListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.context = context;

        if(context instanceof OnTabItemSelectedListener) {
            listener = (OnTabItemSelectedListener) context;
        }
    }

    @Override public void onDetach() {
        super.onDetach();

        if (context != null){
            context = null;
            listener = null;
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_phonebook, container, false);

        initUI(rootView);

        return rootView;
    }
    private void initUI(ViewGroup rootView){

        // 연락처 리스트 화면에서 작성(input)버튼 눌렀을 때 화면 이동
        Button btn_input = rootView.findViewById(R.id.btn_input);
        btn_input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null){
                    listener.onTabSelected(1);
                }
            }
        });

        /* 연락처 화면에서 검색(search) 버튼 눌렀을 때 화면 이동 ? 구현할것..?*/

        recyclerView = rootView.findViewById(R.id.recycler);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new PeopleAdapter();

        adapter.addItem(new PeopleItem(0,"이재은","010-7363-0010"));
        adapter.addItem(new PeopleItem(1, "백도은","010-2343-0290"));
        adapter.addItem(new PeopleItem(2, "정예빈", "010-2394-9890"));
        adapter.addItem(new PeopleItem(3, "서희선", "010-5354-2340"));

        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnPeopleItemClickListener() {
            @Override
            public void onItemClick(PeopleAdapter.ViewHolder holder, View view, int position) {
                PeopleItem item = adapter.getItem(position);
                Toast.makeText(getContext(),"아이템 선택됨: "+item.getName(), Toast.LENGTH_LONG ).show();
            }
        });
    }
}