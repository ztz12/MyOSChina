package com.ztz.myoschina.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;

import com.ztz.myoschina.R;

/**
 * Created by wqewqe on 2017/5/12.
 */

public class MyView extends View {
    Context context;
    int radiam=90;
    int[] radiams=new int[]{90,90,90,90,90};
    public MyView(Context context) {
        this(context,null);
    }

    public MyView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
        thread.start();
    }
    //绘制view
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int r=50;
        for(int i=0;i<5;i++) {

            //空心圆
            Paint paint = new Paint();//画笔
            paint.setStyle(Paint.Style.STROKE);//空心
            paint.setColor(getResources().getColor(R.color.colorWhite));
            paint.setStrokeWidth(1f);
            paint.setAntiAlias(true);//抗锯齿
            //画空心圆
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, r, paint);
            //画实心圆
            Paint painPoint = new Paint();
            painPoint.setAntiAlias(true);
            painPoint.setColor(getResources().getColor(R.color.colorWhite));

            int x = (int) (getWidth() / 2 + r * Math.sin(Math.PI * radiams[i] / 180));
            int y = (int) (getHeight() / 2 + r * Math.cos(Math.PI * radiams[i] / 180));
            canvas.drawCircle(x, y, 8,painPoint);
            r+=100+i*30;
        }

    }
    //动起来，每隔一定时间 增加角度 刷新view
    private Thread thread=new Thread(){
        @Override
        public void run() {
            super.run();
            try{
                while (true) {
                    Thread.sleep(500);
                    for(int i=0;i<5;i++){
                        if(i==2||i==3){
                            radiams[i]-=i*2+1;
                        }else {
                            radiams[i] += i * 2 + 1;
                        }
                    }
                    updateHandle.sendEmptyMessage(0);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
    private Handler updateHandle=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //刷新
            invalidate();
        }
    };
    //自定义view大小
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

       setMeasuredDimension(MyMeasure(widthMeasureSpec),MyMeasure(heightMeasureSpec));
//        MyMeasure(widthMeasureSpec);
    }

//    private int MyMeasure(int origin) {
//        int result=200;
//        int specMode=MeasureSpec.getMode(origin);
//        int specSize=MeasureSpec.getSize(origin);
//        if(specMode==MeasureSpec.EXACTLY){
//            result=specSize;
//        }else if(specMode==MeasureSpec.AT_MOST){
//            result=Math.min(result,specSize);
//        }
//        return result;
//    }

    private int  MyMeasure(int origin) {
        int result=300;//默认 宽高
        //测量宽或者高
        //获取测量模式
        int specMode=MeasureSpec.getMode(origin);
        //获取测量大小
        int specSize=MeasureSpec.getSize(origin);
        if(specMode==MeasureSpec.EXACTLY){//精确值模式,具体数值 如控件100dp match_parent
            result=specSize;
        }else if(specMode==MeasureSpec.AT_MOST){//最大值模式 wrap_content 随控件的子控件或内容变化而变化
            result=Math.min(result,specSize);
        }
        return result;

    }
}
