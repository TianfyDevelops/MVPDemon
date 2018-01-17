package com.example.tianfy.mvpdemon.mvp.view;

import android.widget.Button;
import android.widget.TextView;

import com.example.tianfy.mvpdemon.R;
import com.example.tianfy.mvpdemon.base.BaseActivity;
import com.example.tianfy.mvpdemon.mvp.iview.IActivityView;
import com.example.tianfy.mvpdemon.mvp.persenter.MainPersenter;

import butterknife.InjectView;
import butterknife.OnClick;

import static com.example.tianfy.mvpdemon.R.id.result;

public class MainActivity extends BaseActivity<MainPersenter> implements IActivityView {

    @InjectView(R.id.btn)
    Button mBtn;
    @InjectView(result)
    TextView resultTv;

    @Override
    public int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected MainPersenter createPersenter() {
        return new MainPersenter(this);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        persenter.initData();
    }

    @Override
    public void showLoadView() {
        if (!progressDialog.isShowing())
            progressDialog.show();
    }

    @Override
    public void hideLoadView() {
        if (progressDialog.isShowing())
            progressDialog.dismiss();
    }

    @Override
    public void onSuccess(String result) {
        resultTv.setText(result);
    }

    @Override
    public void onError(String errorStr) {
        resultTv.setText(errorStr);
    }

    @OnClick(R.id.btn)
    public void onViewClicked() {
        persenter.loadData();
    }
}
