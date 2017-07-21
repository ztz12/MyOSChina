package com.ztz.myoschina.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by wqewqe on 2017/4/27.
 */

public class MyNewsAdapter extends FragmentPagerAdapter {
    List<Fragment> fragmentList;
    public MyNewsAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList=fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "开源资讯";
            case 1:
                return "推荐博客";
            case 2:
                return "技术问答";
            case 3:
                return "每日一搏";
        }
        return super.getPageTitle(position);
    }
}
