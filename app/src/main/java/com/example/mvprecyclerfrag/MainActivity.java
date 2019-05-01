package com.example.mvprecyclerfrag;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View view = findViewById(R.id.recyclerViewFragmentOne);
        getSupportFragmentManager().beginTransaction().add(R.id.myLayout, new FragmentOne()).commit();
    }
}