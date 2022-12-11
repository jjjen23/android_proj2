package com.example.myapp;

import android.content.Context;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.myapp.OnTabItemSelectedListener;
import com.google.android.material.slider.RangeSlider;


public class Input_Fragment extends Fragment {
    private static final String TAG = "input_fragment";


    int mMode = Constants.MODE_INSERT;
    //int _id = -1;
    PeopleItem item;

    Context context;
    OnTabItemSelectedListener listener;

    EditText edit_name;
    EditText edit_number;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.context = context;

        if (context instanceof OnTabItemSelectedListener) {
            listener = (OnTabItemSelectedListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

        if (context != null) {
            context = null;
            listener = null;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_input, container, false);

        initUI(rootView);

        applyItem();

        return rootView;
    }

    private void initUI(ViewGroup rootView) {

        edit_name = (EditText) rootView.findViewById(R.id.edit_name);
        edit_number =(EditText) rootView.findViewById(R.id.edit_number);


        Button btn_save = (Button) rootView.findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mMode == Constants.MODE_INSERT) {
                    savePeopleNote();
                } else if(mMode == Constants.MODE_MODIFY){
                    modifyPeopleItem();
                }
                if(listener != null){
                    listener.onTabSelected(2);
                }
            }
        });

        Button btn_delete = rootView.findViewById(R.id.btn_delete);
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deletePeopleItem();

                if (listener != null) {
                    listener.onTabSelected(2);
                }
            }
        });

        Button btn_close = rootView.findViewById(R.id.btn_close);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onTabSelected(2);
                }
            }

        });

    }

    public void setName(String data){
        edit_name.setText(data);
    }

    public void setNumber(String data){
        edit_number.setText(data);
    }

    public void setItem(PeopleItem item) {
        this.item = item;
    }

    public void applyItem(){
        if (item != null) {
            mMode = Constants.MODE_MODIFY;

            setName(item.getName());
            setNumber(item.getPhone_num());
        } else {
            mMode = Constants.MODE_INSERT;

            edit_name.setText("");
            edit_number.setText("");
        }
    }

    private void savePeopleNote() {

                String name = edit_name.getText().toString();
                String phone_num = edit_number.getText().toString();

        String sql = "insert into" + Database.TABLE_PHONE +
                "(NAME, NUMBER) values(" +
                "'"+ name + "', " +
                "'"+ phone_num + "')";

        Log.d(TAG, "sql : " + sql);
        Database database = Database.getInstance(context);
        database.execSQL(sql);

    }

        //데이터베이스 레코드 수정
        private void modifyPeopleItem() {
            if (item != null) {
                String name = edit_name.getText().toString();
                String phone_num = edit_number.getText().toString();

                String sql = "update" + Database.TABLE_PHONE +
                        " set " +
                        "   NAME = '" + name + "'" +
                        "   ,NUMBER = '" + phone_num + "'" +
                        " where " +
                        "   _id = " + item._id;

                Log.d(TAG, "sql : " + sql);
                Database database = Database.getInstance(context);
                database.execSQL(sql);
            }
        }

        //레코드 삭제

        private void deletePeopleItem () {
            Constants.println("deleteNote called.");

            if (item != null) {
                // delete note
                String sql = "delete from" + Database.TABLE_PHONE +
                        " where " +
                        "   _id = " + item._id;

                Log.d(TAG, "sql : " + sql);
                Database database = Database.getInstance(context);
                database.execSQL(sql);

            }
        }

    }






