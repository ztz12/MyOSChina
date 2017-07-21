package com.ztz.myoschina.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ztz.myoschina.R;
import com.ztz.myoschina.bean.TabBean;
import com.ztz.myoschina.widget.BottomLayout;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        BottomLayout bottomLayout= (BottomLayout) findViewById(R.id.bottomLayout);
        List<TabBean> tab=new ArrayList<>();
        tab.add(new TabBean("综合",R.mipmap.ic_nav_news_actived,R.mipmap.ic_nav_news_normal,1));
        tab.add(new TabBean("动弹",R.mipmap.ic_nav_tweet_actived,R.mipmap.ic_nav_tweet_normal,1));
        tab.add(new TabBean("",R.mipmap.ic_nav_add_actived,R.mipmap.ic_nav_add_normal,0));
        tab.add(new TabBean("发现",R.mipmap.ic_nav_discover_actived,R.mipmap.ic_nav_discover_normal,1));
        tab.add(new TabBean("我的",R.mipmap.ic_nav_my_pressed,R.mipmap.ic_nav_my_normal,1));
//        bottomLayout.setBottom(this,tab);
//        LinearLayout linearLayout= (LinearLayout) findViewById(R.id.activity_test);
//        for(int i=0;i<5;i++) {
//            if(i==2){
//                ImageView iv = new ImageView(this);
//                iv.setImageResource(R.mipmap.ic_launcher);
//                iv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);//内部居中
//                LinearLayout.LayoutParams ivParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
//                        ViewGroup.LayoutParams.WRAP_CONTENT);//通过layoutParams设置控件属性
//                ivParams.gravity = Gravity.CENTER_HORIZONTAL;//图片属性，位置居中
//                linearLayout.addView(iv, ivParams);
//            }else {
//                LinearLayout linearLayout1 = new LinearLayout(this);
//                linearLayout1.setOrientation(LinearLayout.VERTICAL);
//                ImageView iv = new ImageView(this);
//                iv.setImageResource(R.mipmap.ic_launcher);
//                LinearLayout.LayoutParams ivParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
//                        ViewGroup.LayoutParams.WRAP_CONTENT);//通过layoutParams设置控件属性
//                ivParams.gravity = Gravity.CENTER;//图片属性，位置居中
//                linearLayout1.addView(iv, ivParams);
//                TextView tv = new TextView(this);
//                tv.setText("综合");
//                LinearLayout.LayoutParams tvParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
//                        ViewGroup.LayoutParams.WRAP_CONTENT);
//                tvParams.gravity = Gravity.CENTER;
//                linearLayout1.addView(tv, tvParams);//添加一个到view布局中
//                LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
//                        ViewGroup.LayoutParams.WRAP_CONTENT, 1);
//                linearLayout.addView(linearLayout1, layoutParams1);
//            }
//        }
    }
}
