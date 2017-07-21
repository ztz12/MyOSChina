package com.ztz.myoschina.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wqewqe on 2017/6/28.
 */

public class ActivityCollector {
    static List<Activity> activities=new ArrayList<>();
    public static void addActivity(Activity activity){
        activities.add(activity);
    }
    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }
    public static void finishAll(){
        for (Activity activity : activities) {
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
        activities.clear();
        //杀死该应用进程
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
