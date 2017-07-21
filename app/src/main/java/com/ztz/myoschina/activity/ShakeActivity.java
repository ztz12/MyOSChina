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
import android.widget.ImageView;
import android.widget.Toast;

import com.ztz.myoschina.R;

public class ShakeActivity extends AppCompatActivity {
    ImageView ivShake,ivShake2;
    Animation animation,animation2;
    SensorManager sensorManager;
    boolean isStart=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shake);
        ivShake=(ImageView)findViewById(R.id.iv_shake1);
        ivShake2=(ImageView)findViewById(R.id.iv_shake2);
        sensorManager= (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener(sensorEventListener,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }
    private SensorEventListener sensorEventListener=new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float[] values=event.values;
            float x=values[0];
            float y=values[1];
            float z=values[2];
            int mediumValue=20;
            if(Math.abs(x)>mediumValue||Math.abs(y)>mediumValue||Math.abs(z)>mediumValue){
                if(!isStart) {
                    scan();
                }
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    private void scan() {
        animation= AnimationUtils.loadAnimation(this,R.anim.translate_2);//图片上移
        ivShake.startAnimation(animation);
        animation2=AnimationUtils.loadAnimation(this,R.anim.translate_1);
        ivShake2.startAnimation(animation2);
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
