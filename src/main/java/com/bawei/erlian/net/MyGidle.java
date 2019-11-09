package com.bawei.erlian.net;

import android.widget.ImageView;

import com.bawei.erlian.R;
import com.bawei.erlian.app.AppUrl;
import com.bumptech.glide.Glide;

/**
 * @auther:董青勇
 * @Date: 2019/11/9
 * @Time: 8:59
 * @Description:
 */
public class MyGidle {
    public  static void  LodeUrl(String url, ImageView imageView){
        Glide.with(AppUrl.context)
                .load(url)
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(imageView);

    }


}
