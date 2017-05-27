package com.dhcc.traffic.common.image;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.dhcc.traffic.R;
import com.squareup.picasso.Picasso;

import java.io.File;

/**
 * Created by Jinx on 2017/5/25.
 * <p>
 * 图片加载
 */

public class Loader implements ILoader {

    private Context mContext;

    private ImageView imageView;

    private int errorImage;

    @Override
    public void init(Context context, ImageView imageView) {
        this.mContext = context;
        this.imageView = imageView;
        errorImage = R.mipmap.ic_launcher;
    }

    @Override
    public void load(File file) {
        Picasso.with(mContext).load(file).error(errorImage).centerCrop().into(imageView);
    }

    @Override
    public void load(String path) {
        Picasso.with(mContext).load(path).error(errorImage).centerCrop().into(imageView);
    }

    @Override
    public void load(Uri uri) {
        Picasso.with(mContext).load(uri).error(errorImage).centerCrop().into(imageView);

    }

    @Override
    public void load(int resourceId) {
        Picasso.with(mContext).load(resourceId).error(errorImage).centerCrop().into(imageView);

    }
}
