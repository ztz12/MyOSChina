package com.ztz.myoschina.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.ztz.myoschina.R;
import com.ztz.myoschina.activity.TweetActivity2;
import com.ztz.myoschina.bean.NewTweetResponse;

import java.util.List;

/**
 * Created by wqewqe on 2017/5/6.
 */

public class NewTweetLVAdapter extends RecyclerView.Adapter<NewTweetLVAdapter.ViewHolder> {
    Context context;
    List<NewTweetResponse.TweetlistBean> beanList;
    private int TYPE_HEAD=0;
    private int TYPE_NORMAL=1;
    public NewTweetLVAdapter(Context context, List<NewTweetResponse.TweetlistBean> beanList) {
        this.context = context;
        this.beanList = beanList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tweet,parent,false);
        final ViewHolder viewHolder=new ViewHolder(view);
        viewHolder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=viewHolder.getAdapterPosition();
                Intent intent=new Intent(context, TweetActivity2.class);
                intent.putExtra(TweetActivity2.TWEET_ID,beanList.get(position).getId());
                context.startActivity(intent);
            }
        });
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NewTweetResponse.TweetlistBean tweetList=beanList.get(position);
        holder.header.setImageURI(tweetList.getPortrait());
        holder.name.setText(tweetList.getAuthor());
        holder.content.setText(tweetList.getBody());
        holder.time.setText(tweetList.getPubDate());
        holder.comment.setText(tweetList.getCommentCount()+"");
        String images=tweetList.getImgSmall();
//        for(int i=0;i<holder.imageLoad.getChildCount();i++){
//            holder.imageLoad.removeView(holder.imageLoad.getChildAt(i));
//        }
//        if(images==null){
//            holder.imageLoad.setVisibility(View.GONE);
//        }else {
//            holder.imageLoad.setVisibility(View.VISIBLE);
//            holder.imageLoad.setImages(images);
//        }
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView header;
        TextView name;
        TextView content;
        TextView time;
        TextView comment;
        LinearLayout item;
        public ViewHolder(View view) {
            super(view);
            header=(SimpleDraweeView)view.findViewById(R.id.simple_tweet);
            name=(TextView)view.findViewById(R.id.tweet_name);
            content=(TextView)view.findViewById(R.id.tweet_content);
            time=(TextView)view.findViewById(R.id.tweet_time);
            comment=(TextView)view.findViewById(R.id.tweet_comment);
            item=(LinearLayout)view;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0){
            return TYPE_HEAD;
        }else {
            return TYPE_NORMAL;
        }
    }
}
