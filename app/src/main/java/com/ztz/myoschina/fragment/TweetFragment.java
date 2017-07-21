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
import com.ztz.myoschina.adapter.MyTweetAdapter;
import com.ztz.myoschina.fragment.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wqewqe on 2017/5/6.
 */

public class TweetFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_tweet,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TabLayout tab_Tweet=(TabLayout)view.findViewById(R.id.tweet_table);
        ViewPager vpTweet=(ViewPager)view.findViewById(R.id.vp_tweet);
        List<Fragment> fragmentList=new ArrayList<>();
        fragmentList.add(new NewTweetFrag());
        fragmentList.add(new NewsTweetFragment());
        fragmentList.add(new NewsFragment());
        fragmentList.add(new NewsFragment());
        MyTweetAdapter adapter=new MyTweetAdapter(getFragmentManager(),fragmentList);
        vpTweet.setAdapter(adapter);
        tab_Tweet.setupWithViewPager(vpTweet);
    }

    @Override
    public void getData() {

    }
}
