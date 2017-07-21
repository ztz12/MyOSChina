package com.ztz.myoschina.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.github.chrisbanes.photoview.PhotoView;
import com.ztz.myoschina.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by wqewqe on 2017/7/10.
 */

public class ImageDetailFragment extends Fragment {
    @BindView(R.id.photo_view)
    PhotoView photoView;
    Unbinder unbinder;
    String imageUrl;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imageUrl = getArguments().getString("url");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_image, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    public static ImageDetailFragment getInstance(String imageUrl) {
        ImageDetailFragment fragment = new ImageDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("url", imageUrl);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (imageUrl != null && !"".equals(imageUrl)) {
            //区分gif图片与普通图片
            if (imageUrl.endsWith(".gif")) {
                Glide.with(getActivity())
                        .load(imageUrl)
                        .asGif()
                        .error(R.mipmap.ic_error)
                        .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                        .dontAnimate()
                        .into(photoView);
            } else {
                Glide.with(getActivity())
                        .load(imageUrl)
                        .crossFade()
                        .error(R.mipmap.ic_error)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(photoView);
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.photo_view)
    public void onViewClicked() {
        getActivity().finish();
    }
}
