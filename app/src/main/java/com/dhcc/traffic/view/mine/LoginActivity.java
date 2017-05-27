package com.dhcc.traffic.view.mine;

import android.support.annotation.NonNull;
import android.view.View;

import com.dhcc.traffic.R;
import com.dhcc.traffic.base.view.BaseNetActivity;
import com.dhcc.traffic.model.bean.LoginBean;
import com.dhcc.traffic.presenter.mine.LoginPresenter;

import java.util.HashMap;
import java.util.Map;

import butterknife.OnClick;

public class LoginActivity extends BaseNetActivity<ILoginView, LoginPresenter> implements ILoginView {


    @NonNull
    @Override
    protected int getLayoutResID() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {

    }

    @NonNull
    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @NonNull
    @Override
    protected String setToolbarTitle() {
        return "登录";
    }

    @Override
    public void onLoginSuccess(LoginBean bean) {

    }

    @OnClick({R.id.btn_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                Map<String, String> map = new HashMap<>();
                map.put("name", "zs");
                presenter.login(map);
                break;
            default:
                break;
        }
    }
}
