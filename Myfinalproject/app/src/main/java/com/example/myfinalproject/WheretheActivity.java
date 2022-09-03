package com.example.myfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myfinalproject.R;
import com.github.barteksc.pdfviewer.PDFView;

public class WheretheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wherethe);


        PDFView pdfVie = findViewById(R.id.pdfView4);
        pdfVie.fromAsset("wherethe_crawdads_sing.pdf").load();
    }
}