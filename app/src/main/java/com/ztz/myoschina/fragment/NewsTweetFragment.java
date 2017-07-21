package com.ztz.myoschina.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import com.ztz.myoschina.adapter.TweetRVAdapter;
import com.ztz.myoschina.bean.TweetListResponse;
import com.ztz.myoschina.fragment.base.BaseFragment;
import com.ztz.myoschina.utils.OSChinaApi;
import com.ztz.myoschina.utils.PreferenceUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wqewqe on 2017/5/6.
 */

public class NewsTweetFragment extends BaseFragment {
    private static final String TAG = "NewsTweetFragment";
    List<TweetListResponse.TweetlistBean> tweetlistBeanList=new ArrayList<>();
    TweetRVAdapter adapter;
    private SpringView spring_tweet;
    int pageIndex=1;
    private RecyclerView recycler_tweet;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_newtweet,container,false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        spring_tweet = (SpringView)view.findViewById(R.id.spring_tweet);
        spring_tweet.setHeader(new AliHeader(getContext()));
        spring_tweet.setFooter(new AliFooter(getContext()));
        spring_tweet.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                tweetlistBeanList.clear();
                pageIndex=1;
                getData();
            }

            @Override
            public void onLoadmore() {
                pageIndex++;
                getData();
            }
        });
        recycler_tweet = (RecyclerView)view.findViewById(R.id.recycler_tweet);
        LinearLayoutManager linearManager=new LinearLayoutManager(getContext());
        recycler_tweet.setLayoutManager(linearManager);
        adapter=new TweetRVAdapter(getContext(),tweetlistBeanList);
        recycler_tweet.setAdapter(adapter);
        ImageView top=(ImageView)view.findViewById(R.id.top_newTweet);
        top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recycler_tweet.smoothScrollToPosition(0);
            }
        });
//        getData();
    }


    @Override
    public void getData() {
        OkGo.<String>get(OSChinaApi.TWEET_LIST)
                .tag(this)
                .params("access_token", PreferenceUtils.getString("access_token"))
                .params("user",-1)
                .params("pageSize",20)
                .params("page",pageIndex)
                .params("dataType","json")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String s=response.body();
                        Log.i(TAG, "onSuccess: "+s);
                        Gson gson=new Gson();
                        TweetListResponse tweetResponse=gson.fromJson(s,TweetListResponse.class);
                        tweetlistBeanList.clear();
                        tweetlistBeanList.addAll(tweetResponse.getTweetlist());
                        adapter.notifyDataSetChanged();
                        spring_tweet.onFinishFreshAndLoad();//重置控件位置，暴露给外部方法，用于刷新或者加载完成后调用
                    }
                });

    }
}
