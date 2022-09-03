package com.example.myfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class testtheStable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testthe_stable);


        PDFView pdfVie = findViewById(R.id.pdfView5);
        pdfVie.fromAsset("the_art_of_indifference.pdf").load();
    }
}