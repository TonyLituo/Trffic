package com.dhcc.traffic.base.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.dhcc.traffic.base.presenter.IBasePresenter;


/**
 * Created by Jinx on 2017/5/3.
 */

public abstract class BaseNetActivity<V extends IBaseNetView, P extends IBasePresenter<V>> extends BaseActivity<V, P> implements IBaseNetView {

    protected ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void showProgressBar() {
        // TODO: 2017/5/26 显示进度条
        if (null == progressBar) {
            progressBar = new ProgressBar(this);
        }
        progressBar.setVisibility(View.VISIBLE);
        Log.e("showProgressBar","showProgressBar");
    }

    @Override
    public void hideProgressBar() {
        // TODO: 2017/5/26 隐藏进度条
        if (null != progressBar) {
            progressBar.setVisibility(View.GONE);
            Log.e("hideProgressBar","hideProgressBar");
        }
    }

    @Override
    public void showError(String e) {
        showErrorView();
        Log.e(tag, e);
    }
}
