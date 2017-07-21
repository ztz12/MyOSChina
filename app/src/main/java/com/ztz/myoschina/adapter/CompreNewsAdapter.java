package com.ztz.myoschina.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ztz.myoschina.R;
import com.ztz.myoschina.activity.NewsActivity;
import com.ztz.myoschina.bean.NewsResponse;

import java.util.List;

/**
 * Created by wqewqe on 2017/4/27.
 */

public class CompreNewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private int TYPE_HEAD=0;
    private int TYPE_NORMAL=1;
    //数据源 item布局
    Context context;
    List<NewsResponse.NewslistBean> newsResponseList;
    private ViewHolder viewHolder;

    public CompreNewsAdapter(Context context,List<NewsResponse.NewslistBean> newsResponseList){
        this.context=context;
        this.newsResponseList=newsResponseList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //加载轮播布局
        if(viewType==TYPE_HEAD&&mHeaderView!=null){
            HeadViewHolder headViewHolder=new HeadViewHolder(mHeaderView);
            return headViewHolder;
        }else {
            //加载新闻布局
            View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news,parent,false);
            viewHolder = new ViewHolder(view);
            viewHolder.item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                      int position=viewHolder.getAdapterPosition();
//                    Toast.makeText(context,"你点击了"+newsResponseList.get(position).getId(), Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(context, NewsActivity.class);
                    intent.putExtra(NewsActivity.NEWS_ID,newsResponseList.get(position).getId());
                    context.startActivity(intent);

                }
            });
            return viewHolder;

        }


    }




    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(getItemViewType(position)==TYPE_HEAD){

        }else {
            ViewHolder viewHolder = (ViewHolder) holder;//向下转型
            NewsResponse.NewslistBean news=newsResponseList.get(position-1);
            String pubTime = news.getPubDate();//转换多少小时前;
            viewHolder.title.setText(news.getTitle());
            viewHolder.comment.setText(news.getCommentCount() + "");//commentCount是int值，需转换成string值;
            viewHolder.time.setText(pubTime);
            if (pubTime.equals("昨天")) {
                viewHolder.tag.setVisibility(View.GONE);
            }
        }
    }

    private View mHeaderView;
    public void setHeaderView(View headView){
        mHeaderView=headView;
    }
    public class HeadViewHolder extends RecyclerView.ViewHolder{

        public HeadViewHolder(View itemView) {
            super(itemView);
        }
    }
    @Override
    public int getItemCount() {
        int size=newsResponseList.size();
        if(mHeaderView!=null){
            size++;
        }
        return size;
    }


    @Override
    public int getItemViewType(int position) {
        //获取item类型
        if(mHeaderView!=null&&position==0){
            return TYPE_HEAD;
        }else {
            return TYPE_NORMAL;
        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView tag;
        TextView title;
        TextView time;
        TextView comment;
        LinearLayout item;
        public ViewHolder(View view) {
            super(view);
            tag=(ImageView)view.findViewById(R.id.image_item_tag);
            title=(TextView)view.findViewById(R.id.tv_item_title);
            time=(TextView)view.findViewById(R.id.tv_item_time);
            comment=(TextView)view.findViewById(R.id.tv_comment_count);
            item=(LinearLayout)view;

        }
    }
}
