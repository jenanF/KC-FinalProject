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

public class sofiaActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance("https://kcfinalproject1-default-rtdb.firebaseio.com/");
    DatabaseReference dbRef = database.getReference();

    ArrayList<Items> item = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sofia);



        RecyclerView books = findViewById(R.id.sofia_rv);
        books.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        books.setLayoutManager(llm);
        sofiaAdapter ra = new sofiaAdapter(item,this);
        books.setAdapter(ra);

        Query booksof = dbRef.child("sofiabooks");

        booksof.addValueEventListener(new ValueEventListener() {
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

        ImageView backk = findViewById(R.id.buttonBack7);
        backk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(sofiaActivity.this,stores_activity.class));
            }
        });
    }
}