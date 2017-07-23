package com.ztz.myoschina.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.ztz.myoschina.R;
import com.ztz.myoschina.activity.ImagePagerActivity;
import com.ztz.myoschina.activity.TweetActivity;
import com.ztz.myoschina.bean.TweetListResponse;
import com.ztz.myoschina.widget.ImageLoad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wqewqe on 2017/5/6.
 */

public class TweetRVAdapter extends RecyclerView.Adapter<TweetRVAdapter.ViewHolder> {
    Context context;
    List<TweetListResponse.TweetlistBean> tweetBeanList;
    private int TYPE_HEADER = 0;//头布局;
    private int TYPE_NORMAL = 1;//动弹布局
    private static final String TAG = "TweetRVAdapter";

    public TweetRVAdapter(Context context, List<TweetListResponse.TweetlistBean> tweetBeanList) {
        this.context = context;
        this.tweetBeanList = tweetBeanList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tweet, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Intent intent = new Intent(context, TweetActivity.class);
                intent.putExtra(TweetActivity.TWEET_ID, tweetBeanList.get(position).getId());


                context.startActivity(intent);

            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //绑定数据;
        TweetListResponse.TweetlistBean tweet = tweetBeanList.get(position);
        holder.header.setImageURI(tweet.getPortrait());//Portrait 肖像
        holder.name.setText(tweet.getAuthor());
        holder.content.setText(tweet.getBody());
        holder.time.setText(tweet.getPubDate());
        holder.comment.setText(tweet.getCommentCount() + "");//转换成string类型
//        String images = tweet.getImgSmall();
        String imgUrl = tweet.getImgSmall();
        //清空子view
        for (int i = 0; i < holder.imageLoad.getChildCount(); i++) {
            holder.imageLoad.removeView(holder.imageLoad.getChildAt(i));
        }
        //加载图片
        if (imgUrl == null) {
            holder.imageLoad.setVisibility(View.GONE);
        } else {
            holder.imageLoad.setVisibility(View.VISIBLE);
            final ArrayList<String> urls = new ArrayList<>();
            //https://static.oschina.net/uploads/space/
            String constantUrl = "https://static.oschina.net/uploads/space/";
            Log.e(TAG, "onBindViewHolder: " + imgUrl);
            if (imgUrl.indexOf(",") != -1) {
                String[] arr = imgUrl.split(",");
                urls.add(arr[0]);
                Log.e(TAG, "onBindViewHolder: " + Arrays.toString(arr));
//                String url = arr[0];
                for (int a = 1; a < arr.length; a++) {
                    String url = constantUrl + arr[a];
                    Log.e(TAG, "onBindViewHolder: " + url);
                    urls.add(url);
                }
            }else {
                urls.add(imgUrl);
            }
            holder.imageLoad.setImages(imgUrl);
//            final ArrayList<String> url = new ArrayList<>();
//            url.add(images);
            holder.imageLoad.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ImagePagerActivity.class);
                    intent.putExtra(ImagePagerActivity.IMAGE_INDEX, 0);
                    intent.putStringArrayListExtra(ImagePagerActivity.IMAGE_URL, urls);
                    context.startActivity(intent);
                }
            });
        }
//        Glide.with(context).load(tweet.getImgSmall())
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(holder.iv_detail);
//        String imageUrl=tweet.getImgSmall();
//        List<String> images=new ArrayList<>();
//        images.add(tweet.getImgSmall());
//        if(images!=null&&!images.isEmpty()){
//            int spanCount=3;
//            if(images.size()==4){
//                spanCount=2;
//            }
//            holder.rl.setLayoutManager(new GridLayoutManager(context,spanCount));
//            HomeImageAdapter homeImageAdapter=new HomeImageAdapter(images);
//            holder.rl.setAdapter(homeImageAdapter);
//            holder.rl.setVisibility(View.VISIBLE);
//            holder.iv_detail.setVisibility(View.GONE);
//        }else {
//            holder.rl.setVisibility(View.GONE);
//            holder.iv_detail.setVisibility(View.VISIBLE);
//            if(imageUrl!=null&&!"".equals(imageUrl)){
//                if(imageUrl.endsWith(".gif")){
//                    Glide.with(context)
//                            .load(imageUrl)
//                            .asGif()
//                            .error(R.mipmap.ic_error)
//                            .diskCacheStrategy(DiskCacheStrategy.SOURCE)
//                            .dontAnimate()
//                            .into(holder.iv_detail);
//                }else {
//                    Glide.with(context)
//                            .load(imageUrl)
//                            .crossFade()
//                            .error(R.mipmap.ic_error)
//                            .diskCacheStrategy(DiskCacheStrategy.ALL)
//                            .into(holder.iv_detail);
//
//                }
//            }
//        }
//        final ArrayList<String> url=new ArrayList<>();
//        url.add(tweet.getImgSmall());
//        holder.iv_detail.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(context, ImagePagerActivity.class);
//                intent.putExtra(ImagePagerActivity.IMAGE_INDEX,0);
//                intent.putStringArrayListExtra(ImagePagerActivity.IMAGE_URL,url);
//                context.startActivity(intent);
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return tweetBeanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView header;
        TextView name;
        TextView content;
        ImageView iv_detail;
        TextView time;
        TextView comment;
        LinearLayout item;
        RecyclerView rl;
        ImageLoad imageLoad;

        public ViewHolder(View view) {
            super(view);
            header = (SimpleDraweeView) view.findViewById(R.id.simple_tweet);
            name = (TextView) view.findViewById(R.id.tweet_name);
            content = (TextView) view.findViewById(R.id.tweet_content);
            imageLoad = (ImageLoad) view.findViewById(R.id.imageLoad);
//            iv_detail=(ImageView)view.findViewById(R.id.iv_detail);
            time = (TextView) view.findViewById(R.id.tweet_time);
            comment = (TextView) view.findViewById(R.id.tweet_comment);
            item = (LinearLayout) view;
//            rl=(RecyclerView)view.findViewById(R.id.rl_home);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        } else {
            return TYPE_NORMAL;
        }
    }

}
