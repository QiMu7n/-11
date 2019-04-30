package com.example.afalse.androidmonthdemo.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.afalse.androidmonthdemo.R;

public class PortraitActivity extends AppCompatActivity {

    private ImageActivity imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portrait);
        initView();
        //第三个做不出来  希望老师海涵，五一一定把这个学会
    }

    private void initView() {
        imageView = (ImageActivity) findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
