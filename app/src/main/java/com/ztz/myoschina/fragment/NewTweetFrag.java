package com.ztz.myoschina.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.liaoinstan.springview.container.AliFooter;
import com.liaoinstan.springview.container.AliHeader;
import com.liaoinstan.springview.widget.SpringView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.ztz.myoschina.R;
import com.ztz.myoschina.adapter.NewTweetLVAdapter;
import com.ztz.myoschina.bean.NewTweetResponse;
import com.ztz.myoschina.fragment.base.BaseFragment;
import com.ztz.myoschina.utils.OSChinaApi;
import com.ztz.myoschina.utils.PreferenceUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wqewqe on 2017/5/6.
 */

public class NewTweetFrag extends BaseFragment {
    SpringView newSpringView;
    List<NewTweetResponse.TweetlistBean> tweetList=new ArrayList<>();
    NewTweetLVAdapter adapter;
    int pageIndex=1;
    private RecyclerView newRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_new_tweet,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        newSpringView=(SpringView)view.findViewById(R.id.new_spring_tweet);
        newSpringView.setHeader(new AliHeader(getContext()));
        newSpringView.setFooter(new AliFooter(getContext()));
        newSpringView.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                tweetList.clear();
                pageIndex=1;
                getData();
            }

            @Override
            public void onLoadmore() {
                pageIndex++;
                getData();
            }
        });
        newRecyclerView = (RecyclerView)view.findViewById(R.id.new_recycler_tweet);
        LinearLayoutManager manager=new LinearLayoutManager(getContext());
        newRecyclerView.setLayoutManager(manager);
        adapter=new NewTweetLVAdapter(getContext(),tweetList);
        newRecyclerView.setAdapter(adapter);
        ImageView top=(ImageView)view.findViewById(R.id.top_new);
        top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newRecyclerView.scrollToPosition(0);
            }
        });

    }


    @Override
    public void getData() {
        OkGo.<String>get(OSChinaApi.TWEET_LIST)
                .tag(this)
                .params("access_token", PreferenceUtils.getString("access_token"))
                .params("user",0)
                .params("pageSize",20)
                .params("page",pageIndex)
                .params("dataType","json")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String s=response.body();
                        Gson gson=new Gson();
                        NewTweetResponse newTweet=gson.fromJson(s,NewTweetResponse.class);
                        tweetList.clear();
                        tweetList.addAll(newTweet.getTweetlist());
                        adapter.notifyDataSetChanged();
                        newSpringView.onFinishFreshAndLoad();
                    }
                });
    }
}
