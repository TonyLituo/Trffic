package com.dhcc.traffic.api;

import android.util.Log;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by Jinx on 2017/5/27.
 */

public class JsonUtils {

    /**
     * map转为RequestBody
     *
     * @param map 请求参数
     * @return
     */
    public static RequestBody map2Body(Map<String, String> map) {
        // TODO: 2017/5/25
        //请求参数公共的在这里加
        JSONObject jsonObject = new JSONObject();
        if (null != map) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jsonObject.put(entry.getKey(), entry.getValue());
            }
        }
        String request = jsonObject.toJSONString();
        Log.e("RequestBody", "RequestBody" + request);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), request);

        return body;
    }

}
