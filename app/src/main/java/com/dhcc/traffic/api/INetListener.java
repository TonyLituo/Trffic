package com.dhcc.traffic.api;

import io.reactivex.disposables.Disposable;

/**
 * Created by Jinx on 2017/5/26.
 */

public interface INetListener<T extends ResponBean> {

    void onStart(Disposable d);

    void onSuccess(T bean);

    void onFailure(String e);

    void onComplete();
}
