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
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.ztz.myoschina.R;
import com.ztz.myoschina.adapter.PostRVAdapter;
import com.ztz.myoschina.bean.PostResponse;
import com.ztz.myoschina.fragment.base.BaseFragment;
import com.ztz.myoschina.utils.OSChinaApi;
import com.ztz.myoschina.utils.PreferenceUtils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wqewqe on 2017/5/3.
 */

public class PostFragment extends BaseFragment {
    List<PostResponse.PostListBean> postList=new ArrayList<>();
    PostRVAdapter adapter;
    int pageIndex=1;
    private RecyclerView recyclerPost;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_post,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SpringView springView=(SpringView)view.findViewById(R.id.springView);
        springView.setHeader(new DefaultHeader(getContext()));//设置头布局
        springView.setFooter(new DefaultFooter(getContext()));//设置尾布局
        springView.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                //刷新数据
                postList.clear();//清空列表
                pageIndex=1;
                getData();
            }

            @Override
            public void onLoadmore() {
                //上拉加载更多
                pageIndex++;
                getData();
            }
        });
         recyclerPost= (RecyclerView)view.findViewById(R.id.recycler_post);
       adapter =new PostRVAdapter(getContext(),postList);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        recyclerPost.setLayoutManager(layoutManager);
        recyclerPost.setAdapter(adapter);
        //获取数据
        ImageView top=(ImageView)view.findViewById(R.id.top_post);
        top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerPost.scrollToPosition(0);
            }
        });
//        getData();
    }


    @Override
    public void getData() {
//        String access_token=getContext().getSharedPreferences("oschina", Context.MODE_PRIVATE).getString("access_token","");
        String access_token= PreferenceUtils.getString("access_token","");
        OkGo.<String>post(OSChinaApi.POST_LIST)
                .tag(this)
                .params("access_token",access_token)
                .params("catalog",pageIndex)
                .params("dataType","json")
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        String s=response.body();
                        //遇到空的字符串,通过此方法自己进行解析
                        Gson gson=new GsonBuilder()
                                .registerTypeHierarchyAdapter(PostResponse.PostListBean.AnswerBean.class,
                                        new JsonDeserializer<PostResponse.PostListBean.AnswerBean>() {
                                            @Override
                                            public PostResponse.PostListBean.AnswerBean deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
//                                                Log.d(TAG, "deserialize: ");
                                                Gson newGson=new Gson();
                                                PostResponse.PostListBean.AnswerBean answer;
                                                try{
                                                    answer=newGson.fromJson(json,PostResponse.PostListBean.AnswerBean.class);
                                                }catch (Exception e){
                                                    answer=new PostResponse.PostListBean.AnswerBean();
                                                    answer.setName("");
                                                    answer.setTime("");
                                                }
                                                return answer;
                                            }
                                        }).create();
                        PostResponse postResponse=gson.fromJson(s,PostResponse.class);
                        postList.addAll(postResponse.getPost_list());
                        adapter.notifyDataSetChanged();
                    }
                });

    }
}
