package com.dhcc.traffic.common.image;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by Jinx on 2017/5/25.
 * <p>
 * 图片加载
 */

public interface ILoader {
    /**
     * 初始化
     */
    void init(Context context,ImageView imageView);


    /**
     * 加载
     */
    void load(File file);

    void load(String path);

    void load(Uri uri);

    void load(int resourceId);
}
