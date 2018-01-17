package com.example.tianfy.mvpdemon.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by Tianfy on 2018/1/16.
 */

public abstract class BaseActivity<P extends BasePersenter> extends AppCompatActivity {

    public P persenter;
    protected ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(getLayoutResID());
        super.onCreate(savedInstanceState);
        persenter = createPersenter();
        ButterKnife.inject(this);
        progressDialog = new ProgressDialog(this);
        initView();
        initData();
    }

    public abstract int getLayoutResID();

    protected abstract P createPersenter();

    protected abstract void initView();

    protected abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (persenter != null)
            persenter.detachView();
        persenter = null;
    }
}
