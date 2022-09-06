package com.example.myfinalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class cartActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance("https://kcfinalproject1-default-rtdb.firebaseio.com/");
    DatabaseReference dbRef = database.getReference();

    ArrayList<Items> cart = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);


        final TextView total = findViewById(R.id.textViewTotal);



        RecyclerView books = findViewById(R.id.cart_rv);
        books.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        books.setLayoutManager(llm);
        final cartAdapter ra = new cartAdapter(cart,this);
        books.setAdapter(ra);

        Query carty = dbRef.child("myCart");

        carty.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                cart.clear();
                for (DataSnapshot p :dataSnapshot.getChildren()){
                    Items sect = p.getValue(Items.class);
                    cart.add(sect);

                    ra.notifyDataSetChanged();
                }
                total.setText("Total: "+ calTotal(cart)+"kd");


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        Button clear = findViewById(R.id.button2clear);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef.child("myCart").getRef().removeValue();
                cart.clear();
                total.setText("Total: "+ calTotal(cart)+"kd");
                ra.notifyDataSetChanged();

                Snackbar snack = Snackbar.make(view,"cart has been cleared ", Snackbar.LENGTH_SHORT);
                snack.show();
            }



        });


    }

    private double calTotal(ArrayList<Items> cart) {

        double cal = 0;
        for (Items p :cart){
            cal = cal + p.getPrice();
        }
        return cal;
    }
}