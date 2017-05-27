package com.dhcc.traffic.model.mine;

import com.dhcc.traffic.api.INetListener;
import com.dhcc.traffic.api.JsonUtils;
import com.dhcc.traffic.api.RetrofitUtils;
import com.dhcc.traffic.model.bean.LoginBean;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;


/**
 * Created by Jinx on 2017/5/26.
 */

public class LoginModel implements ILoginModel {


    public LoginModel() {

    }


    @Override
    public void login(Map<String, String> map, final INetListener<LoginBean> listener) {
        RequestBody body = JsonUtils.map2Body(map);

        RetrofitUtils.getInstance()
                .getApiService()
                .login(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        listener.onStart(d);
                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        if ("0000".equals(loginBean.getRtnCode())) {
                            listener.onSuccess(loginBean);
                        } else {
                            listener.onFailure(loginBean.getRtnMsg());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onFailure(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        listener.onComplete();
                    }
                });
    }
}
