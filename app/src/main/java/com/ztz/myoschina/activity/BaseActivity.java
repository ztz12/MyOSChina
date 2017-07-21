package com.ztz.myoschina.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ztz.myoschina.R;
import com.ztz.myoschina.utils.ActivityCollector;


public class BaseActivity extends AppCompatActivity {
    ProgressDialog progressDialog;
    public static String TAG = "BaseActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        TAG=getClass().getName();
        ActivityCollector.addActivity(this);
    }
    public void showDialog(String msg){
        if(progressDialog==null){
            progressDialog=new ProgressDialog(this);
        }
        progressDialog.setMessage(msg);
        progressDialog.show();
    }
    public void showDialog(){
        if(progressDialog==null){
            progressDialog=new ProgressDialog(this);
        }
        progressDialog.setMessage("");
        progressDialog.show();
    }
    public void closeDialog(){
        if(progressDialog!=null||progressDialog.isShowing()){
            progressDialog.dismiss();
        }
    }
    //使用此方法布局中必须有id为 toolbar
    public void setToolbar(String title){
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        setToolbar(title,toolbar);
    }
    public void setToolbar(String title, Toolbar toolbar){
        if(toolbar!=null){
            setSupportActionBar(toolbar);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(title);
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
