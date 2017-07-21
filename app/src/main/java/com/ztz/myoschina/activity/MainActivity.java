package com.ztz.myoschina.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.ztz.myoschina.R;
import com.ztz.myoschina.adapter.MyNewsAdapter;
import com.ztz.myoschina.bean.TabBean;
import com.ztz.myoschina.fragment.Comprehensive;
import com.ztz.myoschina.fragment.DiscoverFragment;
import com.ztz.myoschina.fragment.MyFragment;
import com.ztz.myoschina.fragment.TweetFragment;
import com.ztz.myoschina.widget.BottomLayout;
import com.ztz.myoschina.widget.UnScrollViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    UnScrollViewPager viewpager;
    Toolbar toolbar;
    List<Fragment> fragmentList=new ArrayList<>();
    MyNewsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏状态栏，全屏显示
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewpager=(UnScrollViewPager) findViewById(R.id.view_pager);
        fragmentList.add(new Comprehensive());
        fragmentList.add(new TweetFragment());
        fragmentList.add(new DiscoverFragment());
        fragmentList.add(new MyFragment());
        adapter=new MyNewsAdapter(getSupportFragmentManager(),fragmentList);
        viewpager.setOffscreenPageLimit(fragmentList.size());//设置最大缓存页数;
        viewpager.setAdapter(adapter);
        BottomLayout bottomLayout=(BottomLayout)findViewById(R.id.bottomLayout);
        List<TabBean> tab=new ArrayList<>();
        tab.add(new TabBean("综合",R.mipmap.ic_nav_news_actived,R.mipmap.ic_nav_news_normal,1));
        tab.add(new TabBean("动弹",R.mipmap.ic_nav_tweet_actived,R.mipmap.ic_nav_tweet_normal,1));
        tab.add(new TabBean("",R.mipmap.ic_nav_add_actived,R.mipmap.ic_nav_add_normal,0));
        tab.add(new TabBean("发现",R.mipmap.ic_nav_discover_actived,R.mipmap.ic_nav_discover_normal,1));
        tab.add(new TabBean("我的",R.mipmap.ic_nav_my_pressed,R.mipmap.ic_nav_my_normal,1));
        //先设点击监听
        bottomLayout.onMidClickListener(new View.OnClickListener() {
            //中间按钮点击事件
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "你点击了中间", Toast.LENGTH_SHORT).show();
            }
        });
        bottomLayout.setBottom(this,tab,viewpager);
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        getSupportActionBar().setTitle("综合");
                        toolbar.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        getSupportActionBar().setTitle("动弹");
                        toolbar.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        getSupportActionBar().setTitle("发现");
                        toolbar.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        toolbar.setVisibility(View.GONE);//隐藏标题;
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

        @Override
        public void onClick(View v) {
            switch (v.getId()){

            }
        }

//        private void getNewsData() {
//            String token=getSharedPreferences("oschina",MODE_PRIVATE).getString("access_token","");
//            OkGo.get(OSChinaApi.NEWS_LIST)
//                    .tag(this)
//                    .params("access_token",token)
//                    .params("catalog",1)
//                    .params("page",1)
//                    .params("pageSize",20)
//                    .params("dataType","json")
//                    .execute(new StringCallback() {
//                        @Override
//                        public void onSuccess(String s, Call call, Response response) {
//                            Log.d("onSuccess","onSuccess:"+s);
//                            Gson gson=new Gson();
//                            NewsResponse newsResponse=gson.fromJson(s,NewsResponse.class);
//                            newsResponse.getNewslist();
//                        }
//                    });
//        }


}
