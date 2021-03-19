package com.hql.mvvmdesign;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

/**
 * @author ly-huangql
 * <br /> Create time : 2021/3/18
 * <br /> Description :
 */
public class ImageHelper {
    @BindingAdapter({"bind:imageUrl"})
    public static void loadImages(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).apply(new RequestOptions().error(R.drawable.ic_launcher_background).centerCrop()).into(imageView);
    }
}
