package com.ztz.myoschina.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.ztz.myoschina.R;

public class TestSevenActivity extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_seven);
        btn=(Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TestSevenActivity.this, CaptureActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:
                if(data!=null){
                    Bundle bundle=data.getExtras();
                    if(bundle==null){
                        return;
                    }
                    if(bundle.getInt(CodeUtils.RESULT_TYPE)==CodeUtils.RESULT_SUCCESS){
                        //成功;
                        String result=bundle.getString(CodeUtils.RESULT_STRING);
                        Toast.makeText(this,"解析结果"+result,Toast.LENGTH_SHORT).show();
                    }else {
                        //失败
                        Toast.makeText(this, "解析失败", Toast.LENGTH_SHORT).show();
                    }
                }
        }
    }
}
