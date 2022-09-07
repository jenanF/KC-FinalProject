package com.example.myfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Profile_Activity extends AppCompatActivity {

    ImageView log;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ImageView home = findViewById(R.id.imageViewhome);
        EditText usname = findViewById(R.id.textViewuser);
        EditText gmail = findViewById(R.id.textViewemail);


        Bundle bundle = getIntent().getExtras();

        String n = bundle.getString("name");
        usname.setText(n);

        String m = bundle.getString("email");
        gmail.setText(m);



        ImageView phone = findViewById(R.id.imageContactphone);

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent calling = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 99887766"));

                startActivity(calling);
            }
        });



        ImageView emailMe = findViewById(R.id.imageContactmail);

        emailMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent mailing = new Intent(Intent.ACTION_SENDTO);

                mailing.setData(Uri.parse("mailto:info@ketab.com"));

                startActivity(mailing);




            }
        });


        Button part = findViewById(R.id.buttonPartner);

        part.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Profile_Activity.this,partnerActivity.class));
            }
        });


        Button publ = findViewById(R.id.buttonPublish);

        publ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Profile_Activity.this,publishingActivity.class));
            }
        });





        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Profile_Activity.this,Activity2.class));
            }
        });

         log = findViewById(R.id.imageView3logout);

        mAuth =  FirebaseAuth.getInstance();

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mAuth.signOut();
                startActivity(new Intent(Profile_Activity.this,signinActivity.class));

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null){

            startActivity(new Intent(Profile_Activity.this,signinActivity.class));

        }
    }
}