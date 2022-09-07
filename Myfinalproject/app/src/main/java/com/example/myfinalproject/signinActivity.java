package com.example.myfinalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseAppLifecycleListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signinActivity extends AppCompatActivity {

    EditText email,password,username;
    TextView regist;
    Button join;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);


        email = findViewById(R.id.editTextEmailAddress);
        password = findViewById(R.id.editTextPassword);
        username = findViewById(R.id.editTextusername);
        regist = findViewById(R.id.textViewRegister);
         join = findViewById(R.id.buttonJoinUs);


        mAuth =  FirebaseAuth.getInstance();



         regist.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 startActivity(new Intent(signinActivity.this,RegisterActivity.class));
             }
         });







        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loginUser();



            }
        });


    }

    private void loginUser() {

        String mail = email.getText().toString().trim();
        String passcode = password.getText().toString().trim();
        String name = username.getText().toString().trim();

        Intent done = new Intent(signinActivity.this, Profile_Activity.class);

        done.putExtra("name", name);
        done.putExtra("email", mail);


        if (TextUtils.isEmpty(mail)){
            email.setError("Enter email");
            email.requestFocus();
            return;
        }
         if (TextUtils.isEmpty(passcode)){
            password.setError("Enter password");
            password.requestFocus();
             return;
        }
         if (TextUtils.isEmpty(name)){
            username.setError("Enter username");
        }
         if (passcode.length()<6){
            password.setError("password should contain at least 6 characters");
            password.requestFocus();
             return;

        }
        else {
            mAuth.signInWithEmailAndPassword(mail,passcode).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if (task.isSuccessful()){
                        Toast.makeText(signinActivity.this,name+" signed in successfully",Toast.LENGTH_SHORT).show();
                        startActivity(done);
                    }
                    else {
                        Toast.makeText(signinActivity.this," Error: "+ task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

}