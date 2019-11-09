package com.bawei.erlian.app;

import android.app.Application;
import android.content.Context;

/**
 * @auther:董青勇
 * @Date: 2019/11/9
 * @Time: 8:46
 * @Description:
 */
public class AppUrl extends Application {
    public  static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
    }
}
