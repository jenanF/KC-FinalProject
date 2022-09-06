package com.example.myfinalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class thatSlaselActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance("https://kcfinalproject1-default-rtdb.firebaseio.com/");
    DatabaseReference dbRef = database.getReference();

    ArrayList<Items> item = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_that_slasel);


        RecyclerView books = findViewById(R.id.slasel_rv);
        books.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        books.setLayoutManager(llm);
        slaselAdapter ra = new slaselAdapter(item,this);
        books.setAdapter(ra);

        Query bookjr = dbRef.child("SalasilBooks");

        bookjr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot p :dataSnapshot.getChildren()){
                    Items sect = p.getValue(Items.class);
                    item.add(sect);

                    ra.notifyDataSetChanged();
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        ImageView backk = findViewById(R.id.buttonBack15);
        backk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(thatSlaselActivity.this,stores_activity.class));
            }
        });
    }
}