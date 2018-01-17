package com.example.tianfy.mvpdemon.mvp.iview;

/**
 * @name MVPDemon
 * @class name：com.example.tianfy.mvpdemon.mvp.iview
 * @class describe
 * @anthor Administrator
 * @time 2018/1/17 15:43
 * @change
 * @chang time
 * @class describe
 */

public interface IActivityView {
    void showLoadView();
    void hideLoadView();
    void onSuccess(String result);
    void onError(String errorStr);
    
    
}
