package com.example.tianfy.mvpdemon.http;

import android.app.Application;



/**
 * Created by shiwei on 2017/3/21.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        HttpManager.init(this);//不做任何操作仅仅是缓存一下Application引用
    }
}
