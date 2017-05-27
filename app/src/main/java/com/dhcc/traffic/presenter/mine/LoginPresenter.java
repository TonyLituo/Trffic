package com.dhcc.traffic.presenter.mine;

import com.dhcc.traffic.api.INetListener;
import com.dhcc.traffic.base.presenter.BasePresenter;
import com.dhcc.traffic.model.bean.LoginBean;
import com.dhcc.traffic.model.mine.ILoginModel;
import com.dhcc.traffic.model.mine.LoginModel;
import com.dhcc.traffic.view.mine.ILoginView;

import java.util.Map;

import io.reactivex.disposables.Disposable;

/**
 * Created by Jinx on 2017/5/26.
 *
 */

public class LoginPresenter extends BasePresenter<ILoginView> {
    ILoginModel mLoginModel;

    public LoginPresenter() {
        mLoginModel = new LoginModel();
    }

    public void login(Map<String, String> map) {
        mLoginModel.login(map, new INetListener<LoginBean>() {
            @Override
            public void onStart(Disposable d) {
                mCompositeDisposable.add(d);
                getView().showProgressBar();
            }

            @Override
            public void onSuccess(LoginBean bean) {
                getView().onLoginSuccess(bean);
            }

            @Override
            public void onFailure(String e) {
                getView().showError(e);
                getView().hideProgressBar();
            }

            @Override
            public void onComplete() {
                getView().hideProgressBar();
            }
        });
    }
}