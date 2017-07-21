package com.ztz.myoschina.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ztz.myoschina.MessageEvent;
import com.ztz.myoschina.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by wqewqe on 2017/5/12.
 */

public class MyFragment extends Fragment {

    private TextView tv_collect;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.my_fragment,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv_collect = (TextView)view.findViewById(R.id.tv_fragment1);
        tv_collect.setText(0+"");
    }
    @Subscribe
    public void handMessage(MessageEvent messageEvent){
        Toast.makeText(getContext(), "接收到消息", Toast.LENGTH_SHORT).show();
        int a=Integer.parseInt(tv_collect.getText().toString());
        int b=++a;
        tv_collect.setText(b+"");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
