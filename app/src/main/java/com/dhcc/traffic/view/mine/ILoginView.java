package com.dhcc.traffic.view.mine;

import com.dhcc.traffic.base.view.IBaseNetView;
import com.dhcc.traffic.model.bean.LoginBean;

/**
 * Created by Jinx on 2017/5/26.
 */

public interface ILoginView extends IBaseNetView {

    void onLoginSuccess(LoginBean bean);

}
