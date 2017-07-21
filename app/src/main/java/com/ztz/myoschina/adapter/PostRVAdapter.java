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
import com.ztz.myoschina.activity.PostActivity;
import com.ztz.myoschina.bean.PostResponse;

import java.util.List;

/**
 * Created by wqewqe on 2017/5/3.
 */

public class PostRVAdapter extends RecyclerView.Adapter<PostRVAdapter.ViewHolder> {
    Context context;
    List<PostResponse.PostListBean> postList;
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post,parent,false);
        final ViewHolder viewHolder=new ViewHolder(view);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=viewHolder.getAdapterPosition();
                Intent intent=new Intent(context, PostActivity.class);
                intent.putExtra(PostActivity.POST_ID,postList.get(position).getId());
                context.startActivity(intent);
            }
        });
        return viewHolder;
    }

    public PostRVAdapter(Context context,List<PostResponse.PostListBean> postList) {
        this.context=context;
        this.postList=postList;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PostResponse.PostListBean post=postList.get(position);
        holder.header.setImageURI(post.getPortrait());
        holder.title.setText(post.getTitle());
        holder.content.setText("这是内容这是内容这是内容这是内容这是内容");
        holder.author.setText("@"+post.getAuthor());
        holder.time.setText(post.getPubDate());
        holder.count.setText(post.getAnswerCount()+"");
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView header;
        TextView title;
        TextView content;
        TextView author;
        TextView time;
        TextView count;
        LinearLayout itemView;
        public ViewHolder(View view) {
            super(view);
            header=(SimpleDraweeView)view.findViewById(R.id.image_post_head);
            itemView=(LinearLayout)view;
            title=(TextView)view.findViewById(R.id.tv_post_title);
            content=(TextView)view.findViewById(R.id.tv_post_content);
            author=(TextView)view.findViewById(R.id.tv_post_author);
            time=(TextView)view.findViewById(R.id.tv_post_time);
            count=(TextView)view.findViewById(R.id.tv_post_count);
        }
    }
}
