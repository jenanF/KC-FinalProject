package com.example.myfinalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.myfinalproject.fragment.lastFragment;
import com.example.myfinalproject.fragment.nextFragment;
import com.example.myfinalproject.fragment.onbordingF;

import java.util.ArrayList;
import java.util.List;

public class firstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Button btn = findViewById(R.id.button5);

        ViewPager page = findViewById(R.id.viewonbording);


        List<Fragment> fragments=new ArrayList<>();

        fragments.add(new onbordingF());
        fragments.add(new lastFragment());
        fragments.add(new nextFragment());


        ViewAdapter adap = new ViewAdapter(getSupportFragmentManager(),fragments);
        page.setAdapter(adap);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(firstActivity.this,signinActivity.class);

                startActivity(intent);
            }
        });






    }
}