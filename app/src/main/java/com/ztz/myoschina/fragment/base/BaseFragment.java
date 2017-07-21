package com.ztz.myoschina.fragment.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;

/**
 * 懒加载
 * Created by wqewqe on 2017/7/20.
 */

public abstract class BaseFragment extends Fragment {
    public String TAG="BaseFragment";
    boolean isVisibleToUser=false;//fragment是否可见
    boolean isInit=false;//是否初始化;
    boolean isInData=false;//数据是否初始化
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isInit=true;
        requestData();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        TAG=getClass().getName();
        super.setUserVisibleHint(isVisibleToUser);
        Log.i(TAG, "setUserVisibleHint: 是否可见"+isVisibleToUser);
        this.isVisibleToUser=isVisibleToUser;
        requestData();
//        if(!isInData&&!isVisibleToUser){
//            handler.removeCallbacks(runnable);
//        }
    }
    private void requestData(){
        if(isVisibleToUser&&isInit&&!isInData){
//           handler.postDelayed(runnable,5000);
            getData();
            isInData=true;
        }
    }
//    Handler handler=new Handler();
//    private final Runnable runnable=new Runnable() {
//        @Override
//        public void run() {
//            getData();
//            isInData=true;
//        }
//    };
    public abstract void getData();
}
