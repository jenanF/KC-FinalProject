package com.example.myfinalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    EditText emailreg,passwordreg,usernamereg,agereg;
    TextView login;
    Button joinus;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        emailreg = findViewById(R.id.editTextEmailAddress3reg);
        passwordreg = findViewById(R.id.editTextPassword3reg);
        usernamereg = findViewById(R.id.editTextusername3reg);
        login = findViewById(R.id.textViewLogin3);
        agereg = findViewById(R.id.editTextAge3reg);
        joinus = findViewById(R.id.buttonJoinUs3reg);



        mAuth =  FirebaseAuth.getInstance();


        joinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                createUser();


            }
        });



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(RegisterActivity.this,signinActivity.class));
            }
        });


    }

    private void createUser() {

        String email = emailreg.getText().toString();
        String password = passwordreg.getText().toString();
        String name = usernamereg.getText().toString();
        String age = agereg.getText().toString();

       if (TextUtils.isEmpty(email)){
           emailreg.setError("Enter email");
           emailreg.requestFocus();
       }
        else if (TextUtils.isEmpty(password)){
            passwordreg.setError("Enter password");
            passwordreg.requestFocus();
        }
       else if (TextUtils.isEmpty(name)){
           usernamereg.setError("Enter username");
       }
       else if (TextUtils.isEmpty(age)){
           usernamereg.setError("Enter age");
       }
        if (password.length()<6){
            passwordreg.setError("password should contain at least 6 characters");
            passwordreg.requestFocus();
            return;

        }
       else {
           mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
               @Override
               public void onComplete(@NonNull Task<AuthResult> task) {

                   if (task.isSuccessful()){

                       Toast.makeText(RegisterActivity.this,name+" registered successfully",Toast.LENGTH_SHORT).show();
                       startActivity(new Intent(RegisterActivity.this,signinActivity.class));
                   }
                   else {
                       Toast.makeText(RegisterActivity.this,"Registration Error: "+ task.getException().getMessage(), Toast.LENGTH_LONG).show();
                   }
               }
           });
       }

    }
}