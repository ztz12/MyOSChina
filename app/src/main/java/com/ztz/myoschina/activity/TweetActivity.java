package com.ztz.myoschina.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.ztz.myoschina.R;
import com.ztz.myoschina.adapter.TweetAdapter;
import com.ztz.myoschina.bean.TweetResponse;
import com.ztz.myoschina.fragment.CommentFragment;
import com.ztz.myoschina.fragment.PostFragment;
import com.ztz.myoschina.utils.OSChinaApi;
import com.ztz.myoschina.utils.PreferenceUtils;
import com.ztz.myoschina.widget.ImageLoad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TweetActivity extends AppCompatActivity {
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
    private static final String TAG = "TweetActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet);
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
        fragmentList.add(CommentFragment.newInstance(id));


        adapter=new TweetAdapter(getSupportFragmentManager(),fragmentList);
        vp_Tweet.setAdapter(adapter);
        tab_Tweet.setupWithViewPager(vp_Tweet);

        getData(id);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    private void getData(int id) {
        OkGo.<String>get(OSChinaApi.TWEET_DETAIL)
                .tag(this)
                .params("access_token", PreferenceUtils.getString("access_token"))
                .params("id",id)
                .params("dataType","json")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String s=response.body();
                        Log.d("onSuccess","onSuccess: "+s);
                        Gson gson=new Gson();
                        TweetResponse tweetResponse=gson.fromJson(s,TweetResponse.class);
                        simpleDetail.setImageURI(tweetResponse.getPortrait());
                        tvTweet_name.setText(tweetResponse.getAuthor());
                        tv_Tweet_content.setText(tweetResponse.getBody());
                        tv_Time.setText(tweetResponse.getPubDate());
                        String images=tweetResponse.getImgSmall();
                        tweetLoad.removeAllViews();
                        //加载图片
                        if (images == null) {
                            tweetLoad.setVisibility(View.GONE);
                        } else {
                            tweetLoad.setVisibility(View.VISIBLE);
                            final ArrayList<String> urls = new ArrayList<>();
                            //https://static.oschina.net/uploads/space/
                            String constantUrl = "https://static.oschina.net/uploads/space/";
                            Log.e(TAG, "onBindViewHolder: " + images);
                            if (images.indexOf(",") != -1) {
                                String[] arr = images.split(",");
                                urls.add(arr[0]);
                                Log.e(TAG, "onBindViewHolder: " + Arrays.toString(arr));
                                for (int a = 1; a < arr.length; a++) {
                                    String url = constantUrl + arr[a];
                                    Log.e(TAG, "onBindViewHolder: " + url);
                                    urls.add(url);
                                }
                            }else {
                                urls.add(images);
                            }
                            tweetLoad.setImages(images);
                            tweetLoad.setTweetImage(new ImageLoad.TweetImage() {
                                @Override
                                public void tweetShow(int position) {
                                    Intent intent = new Intent(TweetActivity.this, ImagePagerActivity.class);
                                    intent.putExtra(ImagePagerActivity.IMAGE_INDEX, position);
                                    intent.putStringArrayListExtra(ImagePagerActivity.IMAGE_URL, urls);
                                    startActivity(intent);
                                }
                            });
                        }
                    }
                });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
            case R.id.share:
                UMImage thumb =  new UMImage(this, R.drawable.a1);
                UMImage image = new UMImage(TweetActivity.this, "imageurl");
                image.setThumb(thumb);
                new ShareAction(TweetActivity.this).withText("hello")
                        .withMedia(image)
                        .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)
                        .setCallback(new UMShareListener() {
                            @Override
                            public void onStart(SHARE_MEDIA share_media) {

                            }

                            @Override
                            public void onResult(SHARE_MEDIA share_media) {

                            }

                            @Override
                            public void onError(SHARE_MEDIA share_media, Throwable throwable) {

                            }

                            @Override
                            public void onCancel(SHARE_MEDIA share_media) {
                                Toast.makeText(TweetActivity.this, "取消分享", Toast.LENGTH_SHORT).show();
                            }
                        }).open();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
