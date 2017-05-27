package com.dhcc.traffic.base.presenter;


import com.dhcc.traffic.base.view.IBaseView;

/**
 * Created by Jinx on 2017/5/3.
 */

public interface IBasePresenter<V extends IBaseView> {

    void attach(V view);

    void dettach();

}
