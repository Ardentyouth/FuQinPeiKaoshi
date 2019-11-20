package com.example.fuqinpeikaoshi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fuqinpeikaoshi.adapter.Myadapter;
import com.example.fuqinpeikaoshi.bean.PicBean;
import com.example.fuqinpeikaoshi.mainview.MainView;
import com.example.fuqinpeikaoshi.persenter.Persenter;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener, MainView {
    private EditText mEdPhone;
    private EditText mEdPhone1;
    private TextView mTvName;
    private TextView mTvName1;
    private RecyclerView mRecy;
    private ArrayList<PicBean.DataBean.ListBean> list;
    private Myadapter myadapter;
    private Button mBtnNo;
    private Button mBtnYs;
    private int price;
    private int parseInt;
    private Persenter persenter;
    private ArrayList<Boolean> mCheckedList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        initData();
        Intent intent = getIntent();
        String pic = intent.getStringExtra("pic");
        parseInt = Integer.parseInt(pic);
        mTvName.setText("账户余额：" + parseInt);
        Log.i("tag", "onCreate: " + parseInt);
    }
    private void initData() {
        persenter = new Persenter(this);
        persenter.getpic();
    }
    private void initView() {
        mEdPhone = (EditText) findViewById(R.id.ed_phone);
        mEdPhone1 = (EditText) findViewById(R.id.ed_phone1);
        mTvName = (TextView) findViewById(R.id.tv_name1);
        mEdPhone.setOnClickListener(this);
        mEdPhone1.setOnClickListener(this);
        mTvName1 = (TextView) findViewById(R.id.tv_name1);
        mRecy = (RecyclerView) findViewById(R.id.recy);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecy.setLayoutManager(linearLayoutManager);
        list = new ArrayList<>();
        myadapter = new Myadapter(list, this);
        myadapter.setOnitemlick(new Myadapter.Onitemlick() {
            @Override
            public void onitenlistlick(int posi) {
                price = list.get(posi).getPrice(); //总价
            }
        });
        mRecy.setAdapter(myadapter);
        mTvName1.setOnClickListener(this);
        mRecy.setOnClickListener(this);
        mBtnNo = (Button) findViewById(R.id.btn_no);
        mBtnNo.setOnClickListener(this);
        mBtnYs = (Button) findViewById(R.id.btn_ys);
        mBtnYs.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_ys:
                initSuan();
                break;
        }
    }
    private void initSuan() {
        int i = price + 2;
        int i1 = parseInt - i;
        String s = Integer.toString(i1);
        Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
        intent.putExtra("num", s);
        startActivity(intent);
    }
    @Override
    public void onSuress(PicBean picBean) {
        List<PicBean.DataBean.ListBean> listnren = picBean.getData().getList();
        list.addAll(listnren);
        myadapter.notifyDataSetChanged();
        Log.i("tog", "onSuress: " + mCheckedList.size() + "  " + list.size());
    }

    @Override
    public void onFile(String err) {
        Log.i("tag", "onFile: " + err);
    }
}
