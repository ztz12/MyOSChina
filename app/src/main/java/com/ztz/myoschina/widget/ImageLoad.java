package com.ztz.myoschina.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by wqewqe on 2017/5/6.
 */

public class ImageLoad extends LinearLayout {
    Context context;
    String[] images;
//    int width=0;
    public ImageLoad(Context context) {
        this(context,null);
    }

    public ImageLoad(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ImageLoad(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
    }
    public  void setImages(String images){
        this.images=images.split(",");
        init();

    }

    private void init() {
        //加载图片
        setOrientation(VERTICAL);
        int count=images.length;
        int lines;
        if(count%3==0){
            lines=count/3;
        }else {
            lines=count/3+1;
        }
        for(int i=0;i<lines;i++){
            //循环行
            LinearLayout linearLayout=new LinearLayout(context);
            linearLayout.setOrientation(HORIZONTAL);
            for(int j=i*3;j<(i+1)*3;j++){
                //循环每一行图片
                SimpleDraweeView simpleDraw=new SimpleDraweeView(context);
                String url;
                try{

                        url = images[j];
                    if(j>=1){
                        url = "https://static.oschina.net/uploads/space/" + url;
                    }
                }catch (Exception e){
                    url="";
                }
                simpleDraw.setImageURI(url);
                LayoutParams params=new LayoutParams(0,360,1);
                linearLayout.addView(simpleDraw,params);
                if(imageShow!=null){
                    imageShow.imageShowing(url);
                }
            }
            addView(linearLayout);
        }
    }
    public ImageShow imageShow;
    public interface ImageShow{
        void imageShowing(String url);
    }

    public void setImageShow(ImageShow imageShow) {
        this.imageShow = imageShow;
    }
}
