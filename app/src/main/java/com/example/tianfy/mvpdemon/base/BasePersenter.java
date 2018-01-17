package com.example.tianfy.mvpdemon.base;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by Tianfy on 2018/1/16.
 */

public class BasePersenter<V> {
    protected Reference<V> mView;//View接口类型的弱引用
    protected V view;
    public BasePersenter(V view) {
        this.view = view;
        attachView(view);
    }

    public void attachView(V view) {
        mView= new WeakReference<V>(view);

    }
    protected V getView(){
        return mView.get();
    }
    public boolean isViewAttached(){

        return mView!=null&&mView.get()!=null;
    }


    public void detachView() {
        if (mView!=null){
            mView.clear();
            mView=null;
        }
    }
}
