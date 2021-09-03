package com.yaorange.http;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName test
 * @Description TODO
 * @Auther elsfk
 * @Date2021/8/18 14:49
 * @Version 1.0
 **/
public class test {
    public static void main(String[] args) throws IOException {
        HttpRequest httpRequest = new HttpRequest();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("app_id","0475878917");
        jsonObject.put("content","赛迪多云资源开通审批流程");
        jsonObject.put("header","待办消息");
        jsonObject.put("mobilephone","15700552905");
        jsonObject.put("source","DY");
        jsonObject.put("status","SEND");
        jsonObject.put("urllink","http://www.baidu.com");
        jsonObject.put("urlname","测试");
        List<JSONObject> jsonObjects = new ArrayList<>();
        jsonObjects.add(jsonObject);
        String send = httpRequest.sendPost("http://oaweixin.cisdi.com.cn:8020/NALM/MesController/insertMesByAppidAndSend", jsonObjects, "utf-8");
        System.out.println(send);
    }
}
