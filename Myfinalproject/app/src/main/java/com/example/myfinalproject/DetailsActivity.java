package com.example.myfinalproject;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.Intent;
import android.icu.text.Transliterator;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance("https://kcfinalproject1-default-rtdb.firebaseio.com/");
    DatabaseReference dbRef = database.getReference();

    ArrayList<Items> cart ;

    private Context DetailsActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle bun = getIntent().getExtras();
        Items tp = (Items) bun.getSerializable("prod");


        TextView name = findViewById(R.id.texttitleView);
        TextView person = findViewById(R.id.writerName);
        TextView price = findViewById(R.id.pricenumber);
        TextView descrip = findViewById(R.id.descrptiontext);
        ImageView pic = findViewById(R.id.bookimageD);

        name.setText(tp.getName());
        person.setText("Author: "+ tp.getAuthorname());
        price.setText(tp.getPrice()+"kd");
        descrip.setText(tp.getDescription());

        Context context = DetailsActivity;

        Picasso.with(context).load(tp.getImage()).into(pic);

    }
}