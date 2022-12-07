package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements OnTabItemSelectedListener{

    Calendar_Fragment fragment_cal;
    Input_Fragment  fragment_inp;
    Phonebook_Fragment fragment_Phone;

    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment_cal = new Calendar_Fragment();
        fragment_inp = new Input_Fragment();
        fragment_Phone = new Phonebook_Fragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment_cal).commit();

        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    //item을 클릭시 id값을 가져와 FrameLayout에 fragment.xml띄우기
                    case R.id.tab1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment_cal).commit();
                        return true;
                    case R.id.tab2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment_inp).commit();
                        return true;
                    case R.id.tab3:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment_Phone).commit();
                        return true;

                }
                return false;
            }
        });
    }

    public void onTabSelected(int position){
        if (position == 0){
            bottomNavigation.setSelectedItemId(R.id.tab1);
        } else if(position == 1){
            bottomNavigation.setSelectedItemId(R.id.tab2);
        } else if(position == 2){
            bottomNavigation.setSelectedItemId(R.id.tab3);
        }

    }
}
