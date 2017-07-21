package com.ztz.myoschina.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.ztz.myoschina.R;
import com.ztz.myoschina.bean.TweetListResponse;
import com.ztz.myoschina.utils.OSChinaApi;
import com.ztz.myoschina.utils.PreferenceUtils;
import com.ztz.myoschina.widget.ImageLoad;

public class TestFourActivity extends AppCompatActivity {
    Button btnLoad;
    LinearLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_four);
        ll=(LinearLayout)findViewById(R.id.ll_test);
        btnLoad=(Button)findViewById(R.id.btn_Load);
        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadImage();
            }
        });

    }

    private void loadImage() {
        //请求数据
        //获取图片
        OkGo.<String>get(OSChinaApi.TWEET_LIST)
                .tag(this)
                .params("access_token", PreferenceUtils.getString("access_token"))
                .params("user",-1)
                .params("pageSize",20)
                .params("page",6)
                .params("dataType","json")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String s=response.body();
                        Gson gson=new Gson();
                        TweetListResponse tweetListResponse=gson.fromJson(s,TweetListResponse.class);

                        //https://static.oschina.net/uploads/space/2017/0504/111655_Y1ZG_3037659.png
//                        SimpleDraweeView simpleDraweeView=new SimpleDraweeView(TestFourActivity.this);
//                        simpleDraweeView.setImageURI("https://static.oschina.net/uploads/space/2017/0504/111655_Y1ZG_3037659.png");
//                        simpleDraweeView.setBackgroundColor(Color.RED);
                        String images="https://static.oschina.net/uploads/space/2017/0504/111655_Y1ZG_3037659.png," +
                                "2017/0504/111655_Y1ZG_3037659.png,2017/0504/111655_Y1ZG_3037659.png," +
                                "2017/0504/111655_Y1ZG_3037659.png";

                        ImageLoad imageLoad=new ImageLoad(TestFourActivity.this);
                        imageLoad.setImages(images);
                        ll.addView(imageLoad);
                    }
                });

    }
}
