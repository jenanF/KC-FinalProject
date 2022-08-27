package com.example.myfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class stores_activity extends AppCompatActivity {

    ArrayList<Sections> stores = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stores);


        Sections store1 = new Sections("jarir bookstore",R.drawable.);
        Sections store2 = new Sections("jarir bookstore",R.drawable.);
        Sections store3 = new Sections("jarir bookstore",R.drawable.);
        Sections store4 = new Sections("jarir bookstore",R.drawable.);
        Sections store5 = new Sections("jarir bookstore",R.drawable.);
        Sections store6 = new Sections("jarir bookstore",R.drawable.);

    }
}