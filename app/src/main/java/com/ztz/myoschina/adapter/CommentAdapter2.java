package com.ztz.myoschina.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.ztz.myoschina.R;
import com.ztz.myoschina.bean.CommentResponse2;

import java.util.List;

/**
 * Created by wqewqe on 2017/5/10.
 */

public class CommentAdapter2 extends RecyclerView.Adapter<CommentAdapter2.ViewHolder> {
    Context context;
    List<CommentResponse2.CommentListBean> commentListBeen;

    public CommentAdapter2(Context context, List<CommentResponse2.CommentListBean> commentListBeen) {
        this.context = context;
        this.commentListBeen = commentListBeen;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment2,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.commentSimple.setImageURI(commentListBeen.get(position).getCommentPortrait());
        holder.commentName.setText(commentListBeen.get(position).getCommentAuthor());
        holder.commentTime.setText(commentListBeen.get(position).getPubDate());
        holder.commentContent.setText(commentListBeen.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return commentListBeen.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView commentSimple;
        TextView commentName;
        TextView commentTime;
        TextView commentContent;
        LinearLayout item;
        public ViewHolder(View view) {
            super(view);
            item= (LinearLayout) view;
            commentSimple=(SimpleDraweeView)view.findViewById(R.id.simple_comment);
            commentName=(TextView)view.findViewById(R.id.comment_name);
            commentTime=(TextView)view.findViewById(R.id.comment_time);
            commentContent=(TextView)view.findViewById(R.id.comment_content);
        }
    }
}
