package com.cqu;

import lombok.Data;

/**
 * @version 1.0
 * @author:罗天天
 * @date 2021/3/13  13:43
 * RequestVm： 将用户请求序列里面的请求数据封装为RequestVm对象
 */
@Data
public class RequestVm {
    private boolean isAdd;//增加虚拟机
    private boolean isDel;//删除虚拟机
    private String type;//虚拟机型号
    private int vMId;//虚拟机ID

    public RequestVm(boolean isAdd, String type, int vMId) {
        this.isAdd = isAdd;
        this.type = type;
        this.vMId = vMId;
    }

    public RequestVm(boolean isDel, int vMId) {
        this.isDel = isDel;
        this.vMId = vMId;
    }

    public RequestVm(boolean isAdd, boolean isDel, String type, int vMId) {
        this.isAdd = isAdd;
        this.isDel = isDel;
        this.type = type;
        this.vMId = vMId;
    }
}
