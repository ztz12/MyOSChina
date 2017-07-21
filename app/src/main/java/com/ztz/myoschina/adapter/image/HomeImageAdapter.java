package com.ztz.myoschina.adapter.image;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.ztz.myoschina.R;
import com.ztz.myoschina.activity.ImagePagerActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wqewqe on 2017/7/10.
 */

public class HomeImageAdapter extends RecyclerView.Adapter<HomeImageAdapter.ViewHolder> {
    public HomeImageAdapter(List<String> images) {
        this.images = images;
    }

    List<String> images;
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Glide.with(holder.itemView.getContext())
                .load(images.get(position))
                .centerCrop()
                .error(R.mipmap.ic_error)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                //三级缓存
                //1. 内存缓存,保存到运行内存中，ram
                //2. 保存到本地，sd卡中
                //3. 保存到网络中
                .into(holder.iv);
        holder.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(holder.itemView.getContext(), ImagePagerActivity.class);
                intent.putExtra(ImagePagerActivity.IMAGE_INDEX,position);
                intent.putStringArrayListExtra(ImagePagerActivity.IMAGE_URL, (ArrayList<String>) images);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        public ViewHolder(View itemView) {
            super(itemView);
            iv= (ImageView) itemView.findViewById(R.id.iv_home);
        }
    }
}
