package com.dhcc.traffic.api;

import com.dhcc.traffic.model.bean.LoginBean;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Jinx on 2017/5/24.
 * <p>
 * 网络访问接口
 */

public interface ApiService {

    /**
     * Post requestBody请求数据
     *
     * @param body
     * @return
     */

    @POST(Api.POST_URL)
    Observable<LoginBean> login(@Body RequestBody body);
}
