package com.ztz.myoschina.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.google.gson.Gson;
import com.liaoinstan.springview.widget.SpringView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.ztz.myoschina.R;
import com.ztz.myoschina.adapter.CompreNewsAdapter;
import com.ztz.myoschina.bean.NewsResponse;
import com.ztz.myoschina.bean.ScrollImageBean;
import com.ztz.myoschina.fragment.base.BaseFragment;
import com.ztz.myoschina.utils.OSChinaApi;
import com.ztz.myoschina.widget.ScrollImageLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wqewqe on 2017/4/27.
 */

public class NewsFragment extends BaseFragment {
    List<NewsResponse.NewslistBean> newslistBeanList = new ArrayList<>();
    CompreNewsAdapter adapter;
    private ScrollImageLayout scrollImageLayout;
    ScrollView sc;
    ImageView top;
    SpringView newsSpring;
    int pageIndex = 1;
    private RecyclerView recyclerView;
    private RefreshLayout refreshLayout;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_compare_news);
        top = (ImageView) view.findViewById(R.id.top);
        sc = (ScrollView) view.findViewById(R.id.scView);
//        newsSpring = (SpringView) view.findViewById(R.id.news_spring);
//        newsSpring.setHeader(new AliHeader(getContext()));
//        newsSpring.setFooter(new AliFooter(getContext()));
//        newsSpring.setListener(new SpringView.OnFreshListener() {
//            @Override
//            public void onRefresh() {
//                newslistBeanList.clear();
//                pageIndex = 1;
//                getData();
//
//            }
//
//            @Override
//            public void onLoadmore() {
//                pageIndex++;
//                getData();
//            }
//        });
        refreshLayout=(RefreshLayout)view.findViewById(R.id.news_refresh);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000);
                newslistBeanList.clear();
                pageIndex=1;
                getData();
            }
        });
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadmore(2000);
                pageIndex++;
                getData();
            }
        });
        top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sc.post(new Runnable() {
                    @Override
                    public void run() {
//                        sc.fullScroll(ScrollView.FOCUS_UP);
                        recyclerView.smoothScrollToPosition(0);

                    }
                });
            }
        });
        adapter = new CompreNewsAdapter(getContext(), newslistBeanList);
        //构建新闻列表;
        scrollImageLayout = new ScrollImageLayout(getContext(), null);
        List<ScrollImageBean> beanList = new ArrayList<>();
        beanList.add(new ScrollImageBean("高手问答|人工智能在电商的作用", R.drawable.a1));
        beanList.add(new ScrollImageBean("源创会|上海南京站开始报名", R.drawable.a2));
        beanList.add(new ScrollImageBean("混程序员的江湖", R.drawable.a3));
        beanList.add(new ScrollImageBean("我为什么不在乎人工智能", R.drawable.a4));
        beanList.add(new ScrollImageBean("维护VSCode的事情", R.drawable.a5));
        scrollImageLayout.setImages(getContext(), beanList);

        adapter.setHeaderView(scrollImageLayout);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
//        getData();

    }

    @Override
    public void onStart() {
        super.onStart();
        scrollImageLayout.run();
    }

    @Override
    public void onStop() {
        super.onStop();
        scrollImageLayout.stop();
    }


    @Override
    public void getData() {
        Log.i(TAG, "getData: 获取数据啦");
        String token = getContext().getSharedPreferences("oschina", Context.MODE_PRIVATE).getString("access_token", "");
        OkGo.<String>get(OSChinaApi.NEWS_LIST)
                .tag(this)
                .params("access_token", token)
                .params("catalog", 1)
                .params("page", pageIndex)
                .params("pageSize", 20)
                .params("dataType", "json")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String s = response.body();
                        Log.d(TAG, "onSuccess: " + s);
                        Gson gson = new Gson();
                        NewsResponse newsResponse = gson.fromJson(s, NewsResponse.class);
                        newslistBeanList.addAll(newsResponse.getNewslist());
                        adapter.notifyDataSetChanged();
                    }
                });
    }
}
