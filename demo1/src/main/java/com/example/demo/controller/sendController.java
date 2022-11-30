package com.example.demo.controller;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.example.demo.service.ConfigurationService;

import com.example.demo.service.TemplateMsgEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName:sendController
 * @Author:lxx
 * @Date 2022/11/30 16:33
 **/
@RestController
public class sendController {
    /**
     * 发送模板消息
     * @return
     */
    @Autowired
    public ConfigurationService configurationService;

    @GetMapping( "/sedMsg")
    public JSONObject sedMsg(){
        JSONObject accessToken = configurationService.getAccessToken();
        String token=accessToken.getStr("access_token");
        //获取用户列表
        JSONObject userList = configurationService.getUserList(token);
        JSONArray openids = userList.getJSONObject("data").getJSONArray("openid");
        System.out.println(openids.toArray());
        TemplateMsgEntity messageVo=new TemplateMsgEntity();
        messageVo.setTTitle("标题");
        messageVo.setTKeyword1("测试1");
        messageVo.setTKeyword2("测试2");
        messageVo.setTKeyword3("测试3");
        messageVo.setTKeyword4("测试4");
        messageVo.setTRemark("remark");
        for (Object openid:openids) {
            JSONObject resp = configurationService.sendMsg(messageVo,token,openid.toString());

        }
        return null;
    }

}
