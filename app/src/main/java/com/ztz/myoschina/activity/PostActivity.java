package com.ztz.myoschina.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.ztz.myoschina.R;
import com.ztz.myoschina.bean.PostDetailResponse;
import com.ztz.myoschina.utils.OSChinaApi;
import com.ztz.myoschina.utils.PreferenceUtils;

public class  PostActivity extends AppCompatActivity {
    public static final String POST_ID="id";
    Toolbar toolPost;
    WebView webPost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        toolPost=(Toolbar)findViewById(R.id.tool_post);
        setSupportActionBar(toolPost);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        webPost=(WebView)findViewById(R.id.web_post);
        WebSettings webSettings=webPost.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setAppCacheEnabled(false);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webPost.setWebViewClient(new WebViewClient());
        int id=getIntent().getIntExtra(POST_ID,0);
        getData(id);

    }

    private void getData(int id) {
        OkGo.<String>get(OSChinaApi.POST_DETAIL)
                .tag(this)
                .params("access_token", PreferenceUtils.getString("access_token"))
                .params("id",id)
                .params("dataType","json")
               .execute(new StringCallback() {
                   @Override
                   public void onSuccess(com.lzy.okgo.model.Response<String> response) {
                       String s=response.body();
                       Gson gson=new Gson();
                       PostDetailResponse postDetail=gson.fromJson(s,PostDetailResponse.class);
                       String url=postDetail.getUrl();
                       webPost.loadUrl(url);
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
