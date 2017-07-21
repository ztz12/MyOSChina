package com.ztz.myoschina.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ztz.myoschina.R;
import com.ztz.myoschina.bean.ScrollImageBean;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by wqewqe on 2017/5/4.
 */

public class ScrollImageLayout extends LinearLayout {
    Context context;
    List<ScrollImageBean> imageBeanList;
    List<ImageView> imageViewList=new ArrayList<>();
    List<ImageView> dotsList=new ArrayList<>();
    private String[] titles;
    private int[] imageId;
    ViewPager mViewPager;
    TextView tv_title;
    MyAdapter adapter;
    int currentItem;
    int oldPosition=0;
    private ScheduledExecutorService scheduledExecutorService;
    public ScrollImageLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ScrollImageLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public void setImages(Context context,List<ScrollImageBean> imageBeanList){
        this.context=context;
        this.imageBeanList=imageBeanList;
        init();
    }
    public void run(){
        //newSingleThreadScheduledExecutor() 作用：该方法返回一个可以控制线程池内线程定时或周期性执行某任务的线程池。该线程池大小为1

        scheduledExecutorService= Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleWithFixedDelay(new ViewPagerTask(),2,2, TimeUnit.SECONDS);///延迟2秒后，每隔2秒执行一次该任务
    }

    public class ViewPagerTask implements Runnable{

        @Override
        public void run() {
            currentItem=(currentItem+1)%imageId.length;
            handler.sendEmptyMessage(0);
        }
    }
    public Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mViewPager.setCurrentItem(currentItem);
        }
    };
    private void init() {
        //初始化控件和数据
        View view= LayoutInflater.from(context).inflate(R.layout.layout_scrollimage,this,false);
        addView(view);//将view添加到LinearLayout
        LinearLayout ll_dot= (LinearLayout)findViewById(R.id.ll_dots);
        titles=new String[imageBeanList.size()];
        imageId=new int[imageBeanList.size()];
        for (int i = 0; i < imageBeanList.size(); i++) {
            titles[i]=imageBeanList.get(i).getTitle();
            imageId[i]=imageBeanList.get(i).getImageId();
            ImageView imageView=new ImageView(getContext());
            imageView.setImageResource(R.drawable.dot_normal);
            LayoutParams layoutParams=new LayoutParams(40,40);
            dotsList.add(imageView);//小圆点加入集合 方便管理
            ll_dot.addView(imageView,layoutParams);
        }


        for (int i = 0; i < imageId.length; i++) {
            ImageView imageView=new ImageView(getContext());
            imageView.setImageResource(imageId[i]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageViewList.add(imageView);
        }
        tv_title=(TextView)view.findViewById(R.id.tv_title);
        mViewPager=(ViewPager)view.findViewById(R.id.vp);
        adapter=new MyAdapter();
        mViewPager.setAdapter(adapter);
        dotsList.get(0).setImageResource(R.drawable.dot_focus);
        mViewPager.setOffscreenPageLimit(imageViewList.size());
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tv_title.setText(titles[position]);
                dotsList.get(position).setImageResource(R.drawable.dot_focus);
                dotsList.get(oldPosition).setImageResource(R.drawable.dot_normal);
                oldPosition=position;
                currentItem=position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state){
                    case 1:
                      stop();
                        break;
                    case 2:
                        if(scheduledExecutorService==null){
                            run();
                        }
                        break;
                }
            }
        });
    }
    public void stop(){
        if(scheduledExecutorService!=null){
            scheduledExecutorService.shutdown();
            scheduledExecutorService=null;
        }
    }
    public class MyAdapter extends PagerAdapter{

        @Override
        public int getCount() {
            return imageViewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
            container.removeView(imageViewList.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(imageViewList.get(position));
            return imageViewList.get(position);
        }
    }
}
