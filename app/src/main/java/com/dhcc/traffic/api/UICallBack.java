package com.dhcc.traffic.api;

import android.os.Handler;
import android.os.Looper;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by Lituo on 2017/4/5 0005. 16:08 .
 * Mail：tony1994_vip@163.com
 * 方法能在主线程中运行的CallBack
 */


public abstract class UICallBack implements Callback {

    //拿到主线程的handler
    private final Handler handler = new Handler(Looper.getMainLooper());

//    //响应
//    ResponBean<T> responBean;//{"rtnCode":"0000","rtnMsg":"交易成功","resParams":{}}


    @Override
    public void onFailure(final Call call, final IOException e) {
//        LogUtils.e("网络连接失败："+e.getMessage());
        //通过主线程的handler.post方法，发送一个可以在主线程中运行的run方法
        handler.post(new Runnable() {
            @Override
            public void run() {
                onFailureUI(call, e);
            }
        });
    }

    @Override
    public void onResponse(final Call call, final Response response) throws IOException {

//        LogUtils.e("" + response.code());

        //判断是否响应成功
        if (!response.isSuccessful()) {
//            LogUtils.e("错误码：" + response.code());
            //访问错误  根据不同的响应码做出判断
            handler.post(new Runnable() {
                @Override
                public void run() {
                    onError(response.code());
                }
            });
        }
        //拿到json字符串
        String stringBody = response.body().string();
        stringBody = stringBody.trim().replace("\\\"", "\"");
        stringBody = stringBody.trim().replace("\\\\\"", "\\\"");
        if (stringBody.startsWith("\"")) {
            stringBody = stringBody.substring(1);
        }
        if (stringBody.endsWith("\"")) {
            stringBody = stringBody.substring(0, stringBody.length() - 1);
        }
        //关闭防止内存泄漏
        if (response.body() != null) {
            response.body().close();
        }
//        LogUtils.e("返回的Json报文：" + body);
        final String body = stringBody;

        handler.post(new Runnable() {
            @Override
            public void run() {
                onResponseUI(call, body);
            }
        });
    }


    /**
     * 响应成功  code==200
     *
     * @param call
     * @param body
     */
    public abstract void onResponseUI(Call call, String body);

    /**
     * 响应失败 ，一般为无网络访问;
     *
     * 500和 404 可能会调这个方法
     *
     * @param call
     * @param e
     */
    public abstract void onFailureUI(Call call, IOException e);

    /**
     * 网络错误  code！=200;
     *
     * @param responseCode
     */
    public abstract void onError(int responseCode);

    /**
     * Created by Lituo on 2017/4/10 0010. 20:09 .
     * Mail：tony1994_vip@163.com
     * 网络访问Model监听
     */

    public static interface INetListener {

        void onSucceed(String body);

        void onFailed(IOException e);

        void onError(int responseCode);
    }
}
