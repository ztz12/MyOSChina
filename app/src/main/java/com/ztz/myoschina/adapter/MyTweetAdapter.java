package com.ztz.myoschina.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by wqewqe on 2017/5/6.
 */

public class MyTweetAdapter extends FragmentPagerAdapter {
    List<Fragment> fragmentList;
    public MyTweetAdapter(FragmentManager fm,List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList=fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "最新动弹";
            case 1:
                return "热门动弹";
            case 2:
                return "每日乱弹";
            case 3:
                return "我的动弹";


        }
        return super.getPageTitle(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
