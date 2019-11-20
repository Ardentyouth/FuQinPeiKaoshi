package com.example.fuqinpeikaoshi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mTvPrice;
    /**
     * 进入兑换页
     */
    private Button mBtnNex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTvPrice = (EditText) findViewById(R.id.tv_price);
        mBtnNex = (Button) findViewById(R.id.btn_nex);
        mBtnNex.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_nex:
                initprice();
                break;
        }
    }

    private void initprice() {

        String pic = mTvPrice.getText().toString();

        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        intent.putExtra("pic",pic);
        startActivity(intent);


    }
}
