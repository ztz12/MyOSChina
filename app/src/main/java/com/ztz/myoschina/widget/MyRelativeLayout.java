package com.ztz.myoschina.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by wqewqe on 2017/7/10.
 */

public class MyRelativeLayout extends RelativeLayout {
    public MyRelativeLayout(Context context) {
        super(context);
    }

    public MyRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    //onMeasure : 用于测量View的大小
    //onLayout(boolean changed, int l, int t, int r, int b)：用于确定View在父View中的位置
    //onDraw ：绘制
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //存储View宽高
        setMeasuredDimension(getDefaultSize(0,widthMeasureSpec),getDefaultSize(0,heightMeasureSpec));
        int width=getMeasuredWidth();
        heightMeasureSpec= MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY);
        super.onMeasure(heightMeasureSpec, heightMeasureSpec);
    }
}
