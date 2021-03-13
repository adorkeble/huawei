package com.cqu;

import lombok.Data;

import java.util.List;

/**
 * @version 1.0
 * @author:罗天天
 * @date 2021/3/13  13:45
 * RequestVmOneDay： 将用户请求序列中一天的请求数据封装为RequestVmOneDay对象
 */
@Data
public class RequestVmOneDay {
    private List<RequestVm> requestVms;//一天的请求数组
    private int requestSize;//一天的请求量

    public RequestVmOneDay(List<RequestVm> requestVms, int requestSize) {
        this.requestVms = requestVms;
        this.requestSize = requestSize;
    }
}
