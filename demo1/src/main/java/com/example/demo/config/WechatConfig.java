package com.example.demo.config;

/**
 * @ClassName:WechatConfig
 * @Author:lxx
 * @Date 2022/11/30 16:44
 **/
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class WechatConfig {
    @Value("${wechat.appid}")
    private String appid;
    @Value("${wechat.appkey}")
    private String appkey;
}
