package com.example.myfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class partnerActivity extends AppCompatActivity {

    EditText oname, bname,bemail, bphone,babout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner);

         oname = findViewById(R.id.editTextTextPersonName);
         bname = findViewById(R.id.editTextTextcompanyName);
         bemail = findViewById(R.id.editTextTextEmailAddresspatr);
         bphone = findViewById(R.id.editTextTextphoneAddresspart);
         babout = findViewById(R.id.editTextTextAddressabout);
        Button send = findViewById(R.id.buttonsendit);



        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                check();

            }
        });
    }


    public void check(){


        if (checkEmpty(oname)){
            oname.setError("Enter your name");
        }
        else if (checkEmpty(bname)){
            bname.setError("Enter your business name");
        }
        else if (checkEmpty(bemail)){
            bemail.setError("Enter email");
        }
        else if (checkEmpty(bphone)){
            bphone.setError("Enter phone number");
        }
        else if (checkEmpty(babout)){
            babout.setError("Enter a short brief about your business");
        }
        else if (bemail.length()<12){
            bemail.setError("incorrect email");
        }
        else if (bphone.length()<8){
            bphone.setError("incorrect phone number");
        }
        else {
            Toast.makeText(partnerActivity.this,"sent successfully",Toast.LENGTH_SHORT).show();

            oname.setText("");
            bname.setText("");
            bemail.setText("");
            bphone.setText("");
            babout.setText("");
        }

    }

    boolean checkEmpty(EditText text){
        CharSequence str = text.getText().toString();

        return TextUtils.isEmpty(str);
    }
}