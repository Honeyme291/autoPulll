package com.example.demo.service;



import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.example.demo.config.WechatConfig;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName:e
 * @Author:lxx
 * @Date 2022/11/30 16:02
 **/
@Component
public class ConfigurationService {
    private String accessTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&";

    @Resource
    private WechatConfig wechatConfig;

    public JSONObject getAccessToken() {
        String requestUrl = accessTokenUrl + "appid=" + wechatConfig.getAppid() + "&secret=" + wechatConfig.getAppkey();
        String resp = HttpUtil.get(requestUrl);
        JSONObject result = JSONUtil.parseObj(resp);
        System.out.println("获取access_token:" + resp);
        return result;
    }
    public JSONObject getUserList(String accessToken) {
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=" + accessToken + "&next_openid=";
        String resp = HttpUtil.get(requestUrl);
        JSONObject result = JSONUtil.parseObj(resp);
        System.out.println("用户列表:" + resp);
        return result;
    }
    public JSONObject sendMsg(TemplateMsgEntity messageVo, String token, String openId) {
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="  + token;
        Map<String,Object> content=new HashMap<>();
        JSONObject data = JSONUtil.createObj();
        data.put("first",new JSONObject().put("value",messageVo.getTTitle()));
        data.put("keyword1",new JSONObject().put("value",messageVo.getTKeyword1()));
        data.put("keyword2",new JSONObject().put("value",messageVo.getTKeyword2()));
        data.put("keyword3",new JSONObject().put("value",messageVo.getTKeyword3()));
        data.put("keyword4",new JSONObject().put("value",messageVo.getTKeyword4()));
        data.put("remark",new JSONObject().put("value",messageVo.getTRemark()));

        content.put("touser",openId);
        content.put("url",messageVo.getTUrl());
        content.put("template_id","FBqIU5DiqpQPvUhGTET50ppD8UMMy0tJlr2ogGlFpQs");
        content.put("data",data);
        String resp = HttpUtil.post(requestUrl,JSONUtil.parseFromMap(content).toString());
        System.out.println(content.toString());
        System.out.println(JSONUtil.parseFromMap(content));
        JSONObject result = JSONUtil.parseObj(resp);
        System.out.println("发送消息:" + resp);
        return result;
    }
}


