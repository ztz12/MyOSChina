package com.ztz.myoschina.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.ztz.myoschina.R;

public class welcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);
        welcome();
    }

    private void welcome() {
        //判断是否登录过  3s后执行对应跳转
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String access_token = getSharedPreferences("oschina",MODE_PRIVATE)
                        .getString("access_token",null);
                if (access_token==null){
                    //为空 则跳认证界面
                    Intent intent = new Intent(welcomeActivity.this,AuthorActivity.class);
                    startActivity(intent);
                }else {
                    //不为空 则跳主界面
                    Intent intent = new Intent(welcomeActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                finish();
            }
        }, 1000);

    }
}

