package com.example.myapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.ViewHolder>
         implements OnPeopleItemClickListener {

    // adapter 에 들어갈 list
    ArrayList<PeopleItem> items = new ArrayList<>();

    OnPeopleItemClickListener listener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.item, viewGroup, false);

        return new ViewHolder(itemView,this);
    }

    //아이템을 하나하나 보여주는(bind 되는) 함수
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
            PeopleItem item = items.get(position);

            viewHolder.tv_name.setText(item.getName());

            viewHolder.tv_number.setText(item.getPhone_num());
    }

    @Override
    //리사이클 뷰의 총 개수 반환하는 함수
    public int getItemCount() {
        return items.size();
    }

    //외부에서 item 을 추가시킬 함수이다.
    public void addItem(PeopleItem item) {
        items.add(item);
    }

    public void setItems(ArrayList<PeopleItem> items) {
        this.items = items;
    }

    public PeopleItem getItem(int position) {
        return items.get(position);
    }

    public void setOnItemClickListener(OnPeopleItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onItemClick(ViewHolder holder, View view, int position) {
        if (listener != null) {
            listener.onItemClick(holder, view, position);
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        TextView tv_name;

        TextView tv_number;


        public ViewHolder(View itemView, final OnPeopleItemClickListener listener) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_number = itemView.findViewById(R.id.tv_number);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();

                    if (listener != null) {
                        listener.onItemClick(ViewHolder.this, view, position);
                    }
                }
            });

        }


    }

}
