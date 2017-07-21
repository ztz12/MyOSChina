package com.ztz.myoschina.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;

import com.ztz.myoschina.App;

/**
 * sharePreference工具类
 * Created by wqewqe on 2017/5/4.
 */

public class PreferenceUtils {
    private static final String PREFERENCE_NAME="oschina";
    public PreferenceUtils(){

    }
   public static boolean putString(String key,String value){
       SharedPreferences pref= App.getContext().getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
       SharedPreferences.Editor editor=pref.edit();
       editor.putString(key,value);
       return editor.commit();
   }
    public static boolean putInt(String key,int value){
        SharedPreferences pref=App.getContext().getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit();
        editor.putInt(key,value);
        return editor.commit();
    }
    public static String getString(String key,@Nullable String defaultValue){//defaultvalue可以为空值
        SharedPreferences sharedPreferences=App.getContext().getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(key,defaultValue);
    }
    public static String getString(String key){
        return getString(key,null);
    }
    public static int getInt(String key,@Nullable int defaultValue){
        SharedPreferences sharedPreferences=App.getContext().getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getInt(key,defaultValue);
    }
    public static int getInt(String key){
        return getInt(key,0);
    }
}
