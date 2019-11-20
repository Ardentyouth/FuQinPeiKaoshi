package com.example.fuqinpeikaoshi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Main3Activity extends AppCompatActivity {
    private TextView mTvPic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
    }
    private void initView() {
        mTvPic = findViewById(R.id.tv_pic);
        Intent intent = getIntent();
        String yue = intent.getStringExtra("num");
        mTvPic.setText("余额为" + yue);
    }
}
