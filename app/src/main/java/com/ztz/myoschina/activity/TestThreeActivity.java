package com.ztz.myoschina.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ztz.myoschina.R;
import com.ztz.myoschina.bean.ScrollImageBean;
import com.ztz.myoschina.widget.ScrollImageLayout;

import java.util.ArrayList;
import java.util.List;

public class TestThreeActivity extends AppCompatActivity {
    ScrollImageLayout scrollImageLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_three);
        scrollImageLayout=(ScrollImageLayout)findViewById(R.id.scroll_layout);
        List<ScrollImageBean> imageBeanList=new ArrayList<>();
        imageBeanList.add(new ScrollImageBean("aaa",R.drawable.a1));
        imageBeanList.add(new ScrollImageBean("bbb",R.drawable.a2));
        imageBeanList.add(new ScrollImageBean("ccc",R.drawable.a3));
        imageBeanList.add(new ScrollImageBean("ddd",R.drawable.a4));
        imageBeanList.add(new ScrollImageBean("eee",R.drawable.a5));
        scrollImageLayout.setImages(this,imageBeanList);
    }

    @Override
    protected void onStart() {
        super.onStart();
        scrollImageLayout.run();
    }

    @Override
    protected void onStop() {
        super.onStop();
        scrollImageLayout.stop();
    }
}
