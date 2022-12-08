package com.example.myapp;

import android.view.View;

public interface OnPeopleItemClickListener {
    public void onItemClick(PeopleAdapter.ViewHolder holder, View view , int position);
}
