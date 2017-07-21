package com.ztz.myoschina.activity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.ztz.myoschina.R;

public class TestSixActivity extends AppCompatActivity {
    //创建传感器 监听相关动作
    SensorManager sensorManager;
    boolean isStart=false;
    TextView tv,tv1;
    Animation animation,mAnimation;//动画

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_six);
        tv=(TextView)findViewById(R.id.tv1);
        tv1=(TextView)findViewById(R.id.tv2);
        //实列化
        sensorManager= (SensorManager) getSystemService(SENSOR_SERVICE);
        //1 传感器监听 2 传感器类型 3  接收传感器
        sensorManager.registerListener(sensorEventListener,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);

    }
    private SensorEventListener sensorEventListener=new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float[] values=event.values;
            float x=values[0];//x轴方向加速值
            float y=values[1];
            float z=values[2];
            int mediumValue=20;
            if(Math.abs(x)>mediumValue||Math.abs(y)>mediumValue||Math.abs(z)>mediumValue){//math.abs(x)绝对值
               if(!isStart){
                    yaoYao();
               }
            }
        }



        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }

    };

    private void yaoYao() {
        animation= AnimationUtils.loadAnimation(this,R.anim.translate_1);
        mAnimation=AnimationUtils.loadAnimation(this,R.anim.translate_2);
        tv.startAnimation(animation);
        tv1.startAnimation(mAnimation);
        isStart=true;
        Toast.makeText(this, "摇一摇", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               isStart=false;
            }
        }, 2000);
    }


}
