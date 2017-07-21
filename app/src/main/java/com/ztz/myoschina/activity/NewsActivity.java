package com.ztz.myoschina.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.ztz.myoschina.MessageEvent;
import com.ztz.myoschina.R;
import com.ztz.myoschina.bean.NewsDetailResponse;
import com.ztz.myoschina.utils.OSChinaApi;
import com.ztz.myoschina.utils.PreferenceUtils;

import org.greenrobot.eventbus.EventBus;

public class NewsActivity extends AppCompatActivity {
    Toolbar toolNews;
    WebView webNews;
    Button btnCollect;
    public static final String NEWS_ID="id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        toolNews=(Toolbar)findViewById(R.id.tool_news);
        webNews=(WebView)findViewById(R.id.web_news);
        btnCollect=(Button)findViewById(R.id.btn_collect);
        btnCollect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new MessageEvent("你好"));
            }
        });
        setSupportActionBar(toolNews);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        WebSettings webSettings=webNews.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setAppCacheEnabled(false);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webNews.setWebViewClient(new WebViewClient());
        int id=getIntent().getIntExtra(NEWS_ID,0);
        getData(id);
    }

    private void getData(int id) {
        OkGo.<String>get(OSChinaApi.NEWS_DETAIL)
                .tag(this)
                .params("access_token", PreferenceUtils.getString("access_token"))
                .params("id",id)
                .params("dataType","json")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String s=response.body();
                        Gson gson=new Gson();
                        NewsDetailResponse newsDetail=gson.fromJson(s,NewsDetailResponse.class);
                        String url=newsDetail.getUrl();
                        webNews.loadUrl(url);
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
