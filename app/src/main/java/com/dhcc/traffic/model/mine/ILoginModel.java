package com.dhcc.traffic.model.mine;

import com.dhcc.traffic.api.INetListener;
import com.dhcc.traffic.model.bean.LoginBean;

import java.util.Map;

/**
 * Created by Jinx on 2017/5/26.
 */

public interface ILoginModel {

    void login(Map<String, String> map, INetListener<LoginBean> listener);
}
