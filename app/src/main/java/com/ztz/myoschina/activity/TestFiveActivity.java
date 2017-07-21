package com.ztz.myoschina.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.ztz.myoschina.R;

public class TestFiveActivity extends AppCompatActivity {
    ScrollView sc;
    ImageView top,bottom;
    //background会根据ImageView组件给定的长宽进行拉伸，而src就存放的是原图的大小，不会进行拉伸。
    // src是图片内容（前景），bg是背景，可以同时使用。scaleType只对src起作用
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_five);
        sc=(ScrollView)findViewById(R.id.sc);
        top=(ImageView)findViewById(R.id.btn_top);
        bottom=(ImageView)findViewById(R.id.btn_bottom);
        top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sc.post(new Runnable() {
                    @Override
                    public void run() {
                        //滚至顶部
                        sc.fullScroll(View.FOCUS_UP);
                    }
                });
            }
        });
        bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sc.post(new Runnable() {
                    @Override
                    public void run() {
                        //滚至底部
                        sc.fullScroll(View.FOCUS_DOWN);
                    }
                });
            }
        });
    }
}
