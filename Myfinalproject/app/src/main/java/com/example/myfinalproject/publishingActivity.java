package com.example.myfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;

public class publishingActivity extends AppCompatActivity {

    DatePickerDialog.OnDateSetListener setListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publishing);


        EditText myGmail = findViewById(R.id.editTextEmailAddresspatr);
        EditText call = findViewById(R.id.editTextphoneAddresspub);
        EditText namePub = findViewById(R.id.editTextnamepub);
        EditText meet = findViewById(R.id.editTextmeeting);
        EditText books = findViewById(R.id.editTextaboutthebook);
        Button sent = findViewById(R.id.buttonsenditto);


        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        meet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog pickerDialog = new DatePickerDialog(
                        publishingActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                        month = month+1;
                        String date = day+"/"+month+"/"+year;
                        meet.setText(date);

                    }
                },day,month,year);
                        pickerDialog.show();


            }
        });


        TextWatcher bnot = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                String myEmail = myGmail.getText().toString().trim();
                String myName = namePub.getText().toString().trim();
                String mypho = call.getText().toString().trim();
                String mytime = meet.getText().toString().trim();
                String myabout = books.getText().toString().trim();

                sent.setEnabled(!mypho.isEmpty()  && !myName.isEmpty() && !myEmail.isEmpty() && !mytime.isEmpty() && !myabout.isEmpty());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };

        myGmail.addTextChangedListener(bnot);
        namePub.addTextChangedListener(bnot);
        call.addTextChangedListener(bnot);
        meet.addTextChangedListener(bnot);
        books.addTextChangedListener(bnot);



        sent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder dialog;
                dialog= new AlertDialog.Builder(publishingActivity.this);
                dialog.setCancelable(false);
                dialog.setTitle("Note");
                dialog.setMessage("your meeting will be confirmed via email, please contact us if you have not received it after 24hr");
                dialog.setPositiveButton("got it", new DialogInterface.OnClickListener() {


                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Snackbar snackbar = Snackbar.make(view,"sent successfully, thank you ", Snackbar.LENGTH_SHORT);
                                snackbar.show();

                                myGmail.setText("");
                                namePub.setText("");
                                call.setText("");
                                meet.setText("");
                                books.setText("");


                            }

                        })

                        .setNegativeButton("return", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                AlertDialog alertD =  dialog.create();
                alertD.show();


            }
        });

    }
}