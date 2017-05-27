package com.dhcc.traffic.base.presenter;


import com.dhcc.traffic.api.INetListener;
import com.dhcc.traffic.base.view.IBaseView;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Jinx on 2017/5/3.
 */

public abstract class BasePresenter<V extends IBaseView> implements IBasePresenter<V> {

    protected V view;

    protected INetListener netistener;

    protected CompositeDisposable mCompositeDisposable;

    public BasePresenter() {
        mCompositeDisposable = new CompositeDisposable();
    }

    public void attach(V view) {
        this.view = view;
    }

    public void dettach() {
        view = null;
        mCompositeDisposable.clear();
    }


    public V getView() {
        return view;
    }


}
