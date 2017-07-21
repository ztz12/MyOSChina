package com.ztz.myoschina.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.ztz.myoschina.R;
import com.ztz.myoschina.adapter.TweetAdapter;
import com.ztz.myoschina.bean.TweetResponse2;
import com.ztz.myoschina.fragment.CommentFragment2;
import com.ztz.myoschina.fragment.PostFragment;
import com.ztz.myoschina.utils.OSChinaApi;
import com.ztz.myoschina.utils.PreferenceUtils;
import com.ztz.myoschina.widget.ImageLoad;

import java.util.ArrayList;
import java.util.List;

public class TweetActivity2 extends AppCompatActivity {
    public static final String TWEET_ID="id";
    Toolbar toolDetail;
    SimpleDraweeView simpleDetail;
    TextView tvTweet_name;
    TextView tv_Tweet_content;
    ImageLoad tweetLoad;
    TextView tv_Time;
    TabLayout tab_Tweet;
    ViewPager vp_Tweet;
    List<Fragment> fragmentList=new ArrayList<>();
    TweetAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet2);
        toolDetail=(Toolbar)findViewById(R.id.tweet_detail_tool);
        simpleDetail=(SimpleDraweeView)findViewById(R.id.simple_detail);
        tvTweet_name=(TextView)findViewById(R.id.tweet_detail_name);
        tv_Tweet_content=(TextView)findViewById(R.id.tweet_detail_content);
        tweetLoad=(ImageLoad)findViewById(R.id.image_tweet_load);
        tv_Time=(TextView)findViewById(R.id.tweet_detail_time);
        tab_Tweet=(TabLayout)findViewById(R.id.tab_tweet_detail);
        vp_Tweet=(ViewPager)findViewById(R.id.viewPageTweet);
        setSupportActionBar(toolDetail);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        int id=getIntent().getIntExtra(TWEET_ID,0);
        fragmentList.add(new PostFragment());
        fragmentList.add(CommentFragment2.newInstance(id));
        adapter=new TweetAdapter(getSupportFragmentManager(),fragmentList);
        vp_Tweet.setAdapter(adapter);
        tab_Tweet.setupWithViewPager(vp_Tweet);

        getData(id);
    }

    private void getData(int id) {
        OkGo.<String>get(OSChinaApi.TWEET_DETAIL)
                .tag(this)
                .params("access_token", PreferenceUtils.getString("access_token"))
                .params("id",id)
                .params("dataType","json")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(com.lzy.okgo.model.Response<String> response) {
                        String s=response.body();
                        Log.d("onSuccess","onSuccess: "+s);
                        Gson gson=new Gson();
                        TweetResponse2 tweetResponse=gson.fromJson(s,TweetResponse2.class);
                        simpleDetail.setImageURI(tweetResponse.getPortrait());
                        tvTweet_name.setText(tweetResponse.getAuthor());
                        tv_Tweet_content.setText(tweetResponse.getBody());
                        tv_Time.setText(tweetResponse.getPubDate());
                    }
                });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
