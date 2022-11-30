package com.example.demo.service;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName:r
 * @Author:lxx
 * @Date 2022/11/30 16:50
 **/
@Data
public class TemplateMsgEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    private Integer id;
    /**
     * 标题
     */
    private String tTitle;
    /**
     * 第一行
     */
    private String tKeyword1;
    /**
     * 第二行
     */
    private String tKeyword2;
    /**
     * 第三行
     */
    private String tKeyword3;
    /**
     * 第四行
     */
    private String tKeyword4;
    /**
     * 备注
     */
    private String tRemark;
    /**
     * 跳转连接
     */
    private String tUrl;
    /**
     * 模板编码
     */
    private String tCode;
    /**
     * 状态
     */
    private int tStatus;
}
