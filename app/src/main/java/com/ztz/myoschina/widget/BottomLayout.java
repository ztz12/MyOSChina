package com.ztz.myoschina.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.ztz.myoschina.bean.TabBean;

import java.util.List;

/**
 * Created by wqewqe on 2017/5/2.
 */

public class BottomLayout extends LinearLayout {

    Context context;
    List<TabBean> tabBeanList;
    ViewPager viewPage;
    int midIndex;
    public BottomLayout(Context context) {
        super(context,null);
    }

    public BottomLayout(Context context, AttributeSet attrs) {
        super(context, attrs,0);
    }

    public BottomLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public void setBottom(Context context, List<TabBean> tabBeanList,ViewPager viewPage){
        this.context=context;
        this.tabBeanList=tabBeanList;
        this.viewPage=viewPage;
        init();
    }

    private void init() {
        //初始化bottom底部导航;
        int mIndex=-1;
        for(int i=0;i<tabBeanList.size();i++){
            final TabBean tab=tabBeanList.get(i);
            if(tab.getType()==1) {
               mIndex+=1;
            }else {
                midIndex=i;
            }
            tab.setIndex(mIndex);
            final BottomTab bottomTab=new BottomTab(context,tab);
            LayoutParams layoutParams=new LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.weight=1;
            layoutParams.gravity= Gravity.CENTER;
            addView(bottomTab,layoutParams);
            if(tab.getType()==1) {
                bottomTab.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        viewPage.setCurrentItem(tab.getIndex());
                        bottomTab.setSelected(true);
                    }
                });
            }else {
                bottomTab.setOnClickListener(monClickListener);
            }
            if(i==0){
                bottomTab.setSelected(true);
            }
        }
        viewPage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //先全为选中
                for(int i=0;i<getChildCount();i++){
                    getChildAt(i).setSelected(false);
                }
                //再将选中页设为true
                //position 0 1 2 3
               if(position>=midIndex){//midIndex=2;
                   getChildAt(position+1).setSelected(true);
               }else {
                   getChildAt(position).setSelected(true);
               }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    OnClickListener monClickListener;
    public void onMidClickListener(OnClickListener onClickListener){
        monClickListener=onClickListener;
    }
}
