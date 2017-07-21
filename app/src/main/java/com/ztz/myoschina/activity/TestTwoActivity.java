package com.ztz.myoschina.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ztz.myoschina.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestTwoActivity extends AppCompatActivity {
    ViewPager mViewPage;
    List<ImageView> imageViewList=new ArrayList<>();//轮播图片
    List<ImageView> dotList=new ArrayList<>();//小圆点
    int currentItem;//当前页
    int oldPosition=0;//上一页
    MyVPAdapter adapter;
    private String[] titles=new String[]{
            "高手问答|人工智能在电商的作用"
            ,"源创会|上海南京站开始报名"
            ,"混程序员的江湖"
            ,"我为什么不在乎人工智能"
            ,"维护VSCode的事情"
    };
    public int[] imageId=new int[]{
            R.drawable.a1,
            R.drawable.a2,
            R.drawable.a3,
            R.drawable.a4,
            R.drawable.a5,
    };
    TextView tv_title;
    ScheduledExecutorService scheduledExecutorService;//线程池 开启定时循环任务
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_two);
        mViewPage=(ViewPager)findViewById(R.id.vp);
        for (int i = 0; i < imageId.length; i++) {
            //循环添加ImageView控件到 集合当中
            ImageView imageView=new ImageView(this);
            imageView.setImageResource(imageId[i]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);//图片拉伸
            imageViewList.add(imageView);
        }
        dotList.add((ImageView) findViewById(R.id.dot0));
        dotList.add((ImageView) findViewById(R.id.dot1));
        dotList.add((ImageView) findViewById(R.id.dot2));
        dotList.add((ImageView) findViewById(R.id.dot3));
        dotList.add((ImageView) findViewById(R.id.dot4));
        tv_title=(TextView)findViewById(R.id.tv_title);
        adapter=new MyVPAdapter();
        mViewPage.setAdapter(adapter);
        mViewPage.setOffscreenPageLimit(imageViewList.size());
        dotList.get(0).setImageResource(R.drawable.dot_focus);
        mViewPage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tv_title.setText(titles[position]);
                dotList.get(position).setImageResource(R.drawable.dot_focus);
                dotList.get(oldPosition).setImageResource(R.drawable.dot_normal);
                oldPosition=position;
                currentItem=position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state){
                    //滑动状态变化
                    case 1:
                        // 拖动 停止轮播
                        stop();
                        break;
                    case 2:
                        // 松手，开始轮播
                        if(scheduledExecutorService==null){
                            run();
                        }
                        break;
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(scheduledExecutorService==null) {
            run();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        //activity进入后台 停止轮播
        stop();
    }
    public void stop(){
        //停止轮播
        if(scheduledExecutorService!=null){
            scheduledExecutorService.shutdown();
            scheduledExecutorService=null;
        }
    }
    public void run(){
        //线程池对象  用来开启循环任务  在子线程中执行
        scheduledExecutorService= Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleWithFixedDelay(new ViewPagerTask(),2,2, TimeUnit.SECONDS);//延迟两秒,间隔两秒

    }
    public class ViewPagerTask implements Runnable{

        @Override
        public void run() {
            //切页面(子线程 修改UI--用Handler)   切到哪一页
            currentItem=(currentItem+1)%imageId.length;
            handle.sendEmptyMessage(0);
        }
    }
    public Handler handle=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mViewPage.setCurrentItem(currentItem);
        }
    };
    public class MyVPAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            //要展示的页数
            return imageViewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            //判断是否同一页;
            return view==object;
        }
        //如果滑动的图片超出缓存返回 会调用这个方法  将图片销毁 （viewpager默认缓存3页）
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
           container.removeView(imageViewList.get(position));
        }
          //当要显示的图片可以进行缓存的时候 会调用这个方法进行图片初始化
        //讲要展示的imageView加入到ViewGroup当中  然后作为返回值
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(imageViewList.get(position));
            return  imageViewList.get(position);
        }
    }
}
