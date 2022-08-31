package com.example.myfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class partnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partner);

        EditText oname = findViewById(R.id.editTextTextPersonName);
        EditText bname = findViewById(R.id.editTextTextcompanyName);
        EditText bemail = findViewById(R.id.editTextTextEmailAddresspatr);
        EditText bphone = findViewById(R.id.editTextTextphoneAddresspart);
        EditText babout = findViewById(R.id.editTextTextAddressabout);
        Button send = findViewById(R.id.buttonsendit);



        TextWatcher nottt = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                String names = oname.getText().toString().trim();
                String biname = bname.getText().toString().trim();
                String biemail = bemail.getText().toString().trim();
                String bphones = bphone.getText().toString().trim();
                String bsabout = babout.getText().toString().trim();

                send.setEnabled(!names.isEmpty()  && !biname.isEmpty() && !biemail.isEmpty() && !bphones.isEmpty() && !bsabout.isEmpty() );

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };

        oname.addTextChangedListener(nottt);
        bname.addTextChangedListener(nottt);
        bemail.addTextChangedListener(nottt);
        bphone.addTextChangedListener(nottt);
        babout.addTextChangedListener(nottt);


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(partnerActivity.this,"sent successfully",Toast.LENGTH_SHORT).show();
            }
        });
    }
}