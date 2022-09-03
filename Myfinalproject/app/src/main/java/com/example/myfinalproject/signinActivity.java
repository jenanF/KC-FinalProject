package com.example.myfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signinActivity extends AppCompatActivity {

    EditText email,password,username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);


        email = findViewById(R.id.editTextEmailAddress);
        password = findViewById(R.id.editTextPassword);
        username = findViewById(R.id.editTextusername);
        Button join = findViewById(R.id.buttonJoinUs);








        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                check();



            }
        });


    }

    public void check(){

        Intent done = new Intent(signinActivity.this, Profile_Activity.class);


        String uname = username.getText().toString();
        String mail = email.getText().toString();

        done.putExtra("name", uname);
        done.putExtra("email", mail);

        if (checkEmpty(username)){
            username.setError("Enter username");
        }
        else if (checkEmpty(email)){
            email.setError("Enter email");
        }
        else if (checkEmpty(password)){
            password.setError("Enter password");
        }
        else if (email.length()<12){
            email.setError("incorrect email");
        }
        else if (password.length()<6){
            password.setError("Your password must contain 6 characters");
        }
        else {
            startActivity(done);
        }
    }

    boolean checkEmpty(EditText text){
        CharSequence str = text.getText().toString();

        return TextUtils.isEmpty(str);
    }
}