package com.ztz.myoschina.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
import com.ztz.myoschina.adapter.CommentAdapter;
import com.ztz.myoschina.bean.CommentResponse;
import com.ztz.myoschina.utils.OSChinaApi;
import com.ztz.myoschina.utils.PreferenceUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wqewqe on 2017/5/9.
 */

public class CommentFragment extends Fragment {
    SpringView springComment;
    RecyclerView commentRecycler;
    CommentAdapter adapter;
    List<CommentResponse.CommentListBean> commentListBeen=new ArrayList<>();
    int index=1;
    int id;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_comment,container,false);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       id= getArguments().getInt("id");
    }

    public static CommentFragment newInstance(int id) {
        CommentFragment fragment = new CommentFragment();
        Bundle args = new Bundle();
        args.putInt("id", id);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        springComment=(SpringView)view.findViewById(R.id.spring_comment);
        commentRecycler=(RecyclerView)view.findViewById(R.id.comment_recycler);
        springComment.setHeader(new AliHeader(getContext()));
        springComment.setFooter(new AliFooter(getContext()));
        springComment.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                commentListBeen.clear();
                index=1;
                getData(id);
            }

            @Override
            public void onLoadmore() {
                index++;
                getData(id);
            }
        });
        adapter=new CommentAdapter(getContext(),commentListBeen);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        commentRecycler.setLayoutManager(layoutManager);
        commentRecycler.setAdapter(adapter);
        ImageView top=(ImageView)view.findViewById(R.id.top_comment);
        top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commentRecycler.scrollToPosition(0);//recyclerView 滚至顶部方法
            }
        });
        getData(id);
    }

    private void getData(int id) {
        OkGo.<String>get(OSChinaApi.COMMENT_LIST)
                .tag(this)
                .params("id",id)
                .params("catalog",3)
                .params("access_token", PreferenceUtils.getString("access_token"))
                .params("page",index)
                .params("pageSize",20)
                .params("dataType","json")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String s=response.body();
                        Gson gson=new Gson();
                        CommentResponse commentResponse=gson.fromJson(s,CommentResponse.class);
                        commentListBeen.clear();
                        try{
                            commentListBeen.addAll(commentResponse.getCommentList());
                        }catch (Exception e){}

                        adapter.notifyDataSetChanged();
                        springComment.onFinishFreshAndLoad();
                    }
                });

    }


}
