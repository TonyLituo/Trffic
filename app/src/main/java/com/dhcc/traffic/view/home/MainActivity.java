package com.dhcc.traffic.view.home;

import android.support.annotation.NonNull;

import com.dhcc.traffic.R;
import com.dhcc.traffic.base.view.BaseActivity;
import com.dhcc.traffic.presenter.home.MainPresenter;

public class MainActivity extends BaseActivity<IMainView,MainPresenter> implements IMainView {


    @NonNull
    @Override
    protected int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @NonNull
    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @NonNull
    @Override
    protected String setToolbarTitle() {
        return "zhuye";
    }
}
