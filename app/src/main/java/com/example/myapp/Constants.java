package com.example.myapp;

import android.util.Log;
import android.os.Handler;


public class Constants {

    public static final String TABLE_NAME = "phoneBook"; //테이블 명
    public static final String COLUMN_NAME_NAME = "name"; //컬럼 명
    public static final String COLUMN_NAME_NUMBER = "number"; //컬럼 명

    public static String DATABASE_NAME = "database.db";

    public static final int MODE_INSERT = 1;
    public static final int MODE_MODIFY = 2;




    private static Handler handler = new Handler();
    private static final String TAG = "Constants";
    public static void println(final String data) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, data);
            }
        });
    }

}
