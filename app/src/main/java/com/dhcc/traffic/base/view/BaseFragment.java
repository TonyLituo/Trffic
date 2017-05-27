package com.dhcc.traffic.base.view;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.dhcc.traffic.base.presenter.IBasePresenter;


/**
 * Created by Jinx on 2017/5/19.
 */

public abstract class BaseFragment<V extends IBaseView, P extends IBasePresenter<V>> extends Fragment implements IBaseView {


    P presenter;

    public BaseFragment() {
        // Required empty public constructor
    }

    @NonNull
    protected abstract P createPresenter();



}
