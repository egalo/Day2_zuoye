package com.example.asus.day2_zuoye;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ParticularActivity extends AppCompatActivity {

    @BindView(R.id.img1)
    ImageView img1;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_particular);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String thumbnail = intent.getStringExtra("thumbnail");
        String title = intent.getStringExtra("title");
        String url = intent.getStringExtra("url");
        Glide.with(this).load(thumbnail).into(img1);
        tv1.setText(title);
        tv2.setText(url);
    }
}
