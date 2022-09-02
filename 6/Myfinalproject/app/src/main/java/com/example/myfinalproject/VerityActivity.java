package com.example.myfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myfinalproject.R;
import com.github.barteksc.pdfviewer.PDFView;

public class VerityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verity);

        PDFView pdfVie = findViewById(R.id.pdfView3);
        pdfVie.fromAsset("verity.pdf").load();
    }
}