package com.ztz.myoschina.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ztz.myoschina.MessageEvent;
import com.ztz.myoschina.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by wqewqe on 2017/5/13.
 */

public class MyFragment2 extends Fragment {

    private TextView tv1;
    private ImageView iv2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_my2,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv1 = (TextView)view.findViewById(R.id.tv_fragment2);
        iv2 = (ImageView)view.findViewById(R.id.iv_fragment2);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv2.setVisibility(View.INVISIBLE);
            }
        });
    }
    @Subscribe//标签
    public void handleMessage(MessageEvent messageEvent){
        //接收到消息处理事件
        Toast.makeText(getContext(), "接收到消息", Toast.LENGTH_SHORT).show();
        int a=Integer.parseInt(tv1.getText().toString());
        int b=++a;
        tv1.setText(b+"");
        iv2.setVisibility(View.VISIBLE);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //注册接收器
        EventBus.getDefault().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
