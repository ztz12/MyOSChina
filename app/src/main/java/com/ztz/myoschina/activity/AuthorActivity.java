package com.ztz.myoschina.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.ztz.myoschina.R;
import com.ztz.myoschina.bean.TokenResponse;
import com.ztz.myoschina.utils.OSChinaApi;
import com.ztz.myoschina.utils.PreferenceUtils;

public class AuthorActivity extends AppCompatActivity {
    WebView webView;
    String client_id="Lh5jpA7LEFAdqlHoHsbp";
    String app_key="LprQtg2aOR6PsTk1Bmafa39OIqUgPriO";
    String redirect_uri="http://www.oschina.net";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);
//        (A)：应用通过 浏览器 或 Webview 将用户引导到 OSChina 三方认证页面 上
//        https://www.oschina.net/action/oauth2/authorize?response_type=code&client_id={client_id}①&redirect_uri={redirect_uri}②
//        (B)：用户对应用进行授权
//                (C)：OSChina 认证服务器 通过 回调地址（redirect_uri）将 用户授权码 传递给 应用服务器 或者直接在 Webview 中跳转到携带 用户授权码的回调地址上，Webview 直接获取code即可（redirect_uri?code=abc&state=xyz）
//        (D)：应用服务器 或 Webview 使用 oauth2_token API 向 OSChina 认证服务器发送 用户授权码 以及 回调地址
//        (E)： OSChina 认证服务器返回 AccessToken
        webView=(WebView)findViewById(R.id.web_View);
        String url="http://www.oschina.net/action/oauth2/authorize?response_type=code&client_id="+client_id+"&redirect_uri="+redirect_uri;
        webView.loadUrl(url);
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setAppCacheEnabled(false);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
       webView.setWebViewClient(new WebViewClient(){
           @Override
           public void onPageFinished(WebView view, String url) {
               super.onPageFinished(view, url);

//               http://www.oschina.net/?code=EtI9nw&state=
               if(url.contains("http://www.oschina.net/?code=")){
                   String code=url.replace("http://www.oschina.net/?code=","");
                   code=code.split("&")[0];
                   Log.d("code","code: "+code);
                   //将code请求码传给服务器
                   getToken(code);
               }
               Log.d("onPageFinished","onPageFinished: "+url);
           }
       });
    }

    private void getToken(String code) {
        OkGo.<String>post(OSChinaApi.TOKEN)
                .tag(this)
                .params("client_id", client_id)//应用id
                .params("client_secret", app_key)//密匙
                .params("grant_type", "authorization_code")//授权方式
                .params("redirect_uri", redirect_uri)//回调地址
                .params("code", code)//授权码
                .params("dataType", "json")//返回数据类型
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(com.lzy.okgo.model.Response<String> response) {
                        String s=response.body();
                        Gson gson = new Gson();
                        TokenResponse tokenresponse = gson.fromJson(s, TokenResponse.class);
//                        Log.d("t","onSuccess: "+tokenresponse.getAccess_token());
                        //将token存储到本地;
//                        SharedPreferences pref=getSharedPreferences("oschina",MODE_PRIVATE);
//                        SharedPreferences.Editor editor=pref.edit();
//                        editor.putString("access_token",tokenresponse.getAccess_token());
//                        editor.putString("refresh_token",tokenresponse.getRefresh_token());
//                        editor.putInt("uid",tokenresponse.getUid());
//                        editor.putString("token_type",tokenresponse.getToken_type());
//                        editor.putInt("expires_in",tokenresponse.getExpires_in());
//                        editor.apply();
                        PreferenceUtils.putString("access_token", tokenresponse.getAccess_token());
                        PreferenceUtils.putString("refresh_token", tokenresponse.getRefresh_token());
                        PreferenceUtils.putInt("uid", tokenresponse.getUid());
                        PreferenceUtils.putString("token_type", tokenresponse.getToken_type());
                        PreferenceUtils.putInt("expires_in", tokenresponse.getExpires_in());
//                        Log.d("onSuccess","onSuccess: "+s);
                    }
                });

    }


}
