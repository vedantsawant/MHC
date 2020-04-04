package com.example.mhcapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class home extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navbar);
        bottomNavigationView.setOnNavigationItemSelectedListener(btmnavListner);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ProfileFragment()).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener btmnavListner = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selected = new ProfileFragment();
            switch (menuItem.getItemId()){
                case R.id.profile:
                    selected= new ProfileFragment();
                    break;
                case R.id.treatment:
                    selected= new TreatmentFragment();
                    break;
                case R.id.groupchat:
                    selected= new ChatFragment();
                    break;
                case R.id.doctor:
                    selected= new DoctorFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container
                    ,selected).commit();
            return true;
        }
    };
}
