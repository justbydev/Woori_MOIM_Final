package com.woori.moim.Recommend;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.woori.moim.R;

public class RecommendActivity extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);

        imageView = findViewById(R.id.recommend_iv);
        Glide.with(this).load(R.drawable.recommend).into(imageView);

    }
}