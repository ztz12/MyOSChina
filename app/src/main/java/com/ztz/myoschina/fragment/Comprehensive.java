package com.ztz.myoschina.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ztz.myoschina.R;
import com.ztz.myoschina.adapter.MyNewsAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wqewqe on 2017/5/3.
 */

public class Comprehensive extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_comprehensive,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TabLayout tabLayout=(TabLayout)view.findViewById(R.id.tabLayout);
        ViewPager vp=(ViewPager)view.findViewById(R.id.vp_comprehensive);
        //给viewPage设置adapter
        List<Fragment> fragmentList=new ArrayList<>();
        fragmentList.add(new NewsFragment());
        fragmentList.add(new NewsFragment());
        fragmentList.add(new PostFragment());
        fragmentList.add(new NewsFragment());
        MyNewsAdapter adapter=new MyNewsAdapter(getFragmentManager(),fragmentList);
        vp.setAdapter(adapter);
        //tabLayout与viewPage关联
//        tabLayout.getTabAt(position).select();//默认选中某项
        tabLayout.setupWithViewPager(vp);

    }


}
