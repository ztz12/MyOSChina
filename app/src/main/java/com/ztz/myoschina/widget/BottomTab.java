package com.ztz.myoschina.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ztz.myoschina.bean.TabBean;

/**
 * Created by wqewqe on 2017/5/2.
 */

public class BottomTab extends LinearLayout {
    Context context;
    TabBean tabBean;
    TextView tv;
    ImageView iv;
    public BottomTab(Context context, AttributeSet attrs) {
        super(context, attrs,0);
    }

    public BottomTab(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public BottomTab(Context context,TabBean tabBean){
        super(context);
        this.context=context;
        this.tabBean=tabBean;
        init();


    }

    private void init() {
        //构建一个底部tab
        LinearLayout linearLayout=new LinearLayout(context);
        linearLayout.setOrientation(VERTICAL);
        LayoutParams layoutParams=new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(Gravity.CENTER);
        //添加图片
         iv=new ImageView(context);
        iv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        iv.setImageResource(tabBean.getUnSelected());
        LayoutParams ivParams=new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,0);
        ivParams.weight=1;
        linearLayout.addView(iv,ivParams);
        if(tabBean.getType()==1){
            //添加文字
             tv=new TextView(context);
            tv.setText(tabBean.getTitle());
            LayoutParams tvParams=new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            tvParams.gravity= Gravity.CENTER;
            linearLayout.addView(tv,tvParams);
        }

        addView(linearLayout);
    }

    @Override
    public void setSelected(boolean selected) {
        if(selected){
            if(tv!=null) {
                tv.setTextColor(Color.GREEN);
            }
            if(iv!=null) {
                iv.setImageResource(tabBean.getSelected());
            }
        }else {
            if(tv!=null) {
                tv.setTextColor(Color.BLACK);
            }
            if(iv!=null) {
                iv.setImageResource(tabBean.getUnSelected());
            }
        }
    }
}
