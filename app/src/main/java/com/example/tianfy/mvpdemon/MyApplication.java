package com.example.tianfy.mvpdemon;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.tianfy.mvpdemon.http.HttpManager;

/**
 * Created by Tianfy on 2018/1/16.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        HttpManager.init(this);//不做任何操作仅仅是缓存一下Application引用
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle bundle) {
                if (activity instanceof AppCompatActivity){
                    if (((AppCompatActivity) activity).findViewById(R.id.toolbar)!=null){
                        ((AppCompatActivity) activity).setSupportActionBar((Toolbar) ((AppCompatActivity) activity).findViewById(R.id.toolbar));
                        ((AppCompatActivity) activity).getSupportActionBar().setDisplayShowTitleEnabled(false);
                    }else{
                        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
                            activity.setActionBar((android.widget.Toolbar) ((AppCompatActivity) activity).findViewById(R.id.toolbar));
                            activity.getActionBar().setDisplayShowTitleEnabled(false);

                        }
                    }
                    if (((AppCompatActivity) activity).findViewById(R.id.toolbar_title)!=null){
                        ((TextView)((AppCompatActivity) activity).findViewById(R.id.toolbar_title)).setText(activity.getTitle());
                    }
                }
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }
}
