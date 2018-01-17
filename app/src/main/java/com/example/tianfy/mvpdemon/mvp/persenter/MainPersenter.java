package com.example.tianfy.mvpdemon.mvp.persenter;

import com.example.tianfy.mvpdemon.base.BasePersenter;
import com.example.tianfy.mvpdemon.http.HttpManager;
import com.example.tianfy.mvpdemon.http.TestBean;
import com.example.tianfy.mvpdemon.http.callback.OnResultCallBack;
import com.example.tianfy.mvpdemon.http.subscriber.HttpSubscriber;
import com.example.tianfy.mvpdemon.mvp.iview.IActivityView;

/**
 * @name MVPDemon
 * @class name：com.example.tianfy.mvpdemon.mvp.persenter
 * @class describe
 * @anthor Administrator
 * @time 2018/1/17 15:42
 * @change
 * @chang time
 * @class describe
 */

public class MainPersenter extends BasePersenter<IActivityView> {
    private HttpSubscriber mHttpObserver;

    public MainPersenter(IActivityView view) {
        super(view);
    }

    public void loadData() {
        view.showLoadView();
        HttpManager.getInstance().getDatasWithCache(mHttpObserver, 1, 10, "json1", false);

    }
    
    public void initData() {
        mHttpObserver = new HttpSubscriber(new OnResultCallBack<TestBean>() {
            @Override
            public void onSuccess(TestBean tb) {
                view.hideLoadView();
                String result = "";
                for (TestBean.ListBean bean : tb.getList()) {
                    result += bean.toString();
                }
                view.onSuccess(result);
            }

            @Override
            public void onError(int code, String errorMsg) {
                String errorStr = "";
                errorStr = "onError: code:" + code + "  errorMsg:" + errorMsg;
                view.onError(errorStr);
            }
        });
    }
}
