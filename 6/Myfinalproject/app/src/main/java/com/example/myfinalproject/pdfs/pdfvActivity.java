package com.example.myfinalproject.pdfs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myfinalproject.R;
import com.github.barteksc.pdfviewer.PDFView;

public class pdfvActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfv);

        PDFView pdfVie = findViewById(R.id.pdfView);
        pdfVie.fromAsset("the_silent_patient.pdf").load();

    }
}