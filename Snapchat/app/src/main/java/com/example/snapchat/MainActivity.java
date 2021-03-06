package com.example.snapchat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView btnNav = findViewById(R.id.btnNav);
        NavController navCont = Navigation.findNavController(this, R.id.fragmentContainerView);
        NavigationUI.setupWithNavController(btnNav, navCont);
    }
}