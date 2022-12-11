package com.example.myapp;

import android.view.View;

import com.example.myapp.PeopleAdapter;

public interface OnPeopleItemClickListener {
    public void onItemClick(PeopleAdapter.ViewHolder holder, View view , int position);
}
