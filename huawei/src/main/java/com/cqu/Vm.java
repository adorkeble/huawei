package com.cqu;

import lombok.Data;

/**
 * @version 1.0
 * @author:罗天天
 * @date 2021/3/11  21:05
 * Vm               虚拟机类型
 * type：           型号
 * cpuNum：         CPU 核数          每台服务器的 CPU 核数不超过 1024
 * memorySize：     内存大小          每台服务器的 内存大小不超过 1024
 * isDoubleNode：   是否双节点部署
 *                           单节点部署指的是一台虚拟机所需的资源（CPU和内存）完全由主机上的一个节点提供；
 *                           双节点部署指的是一台虚拟机所需的资源（CPU 和内存）必须由一台服务器的两个节点
 *                   同时提供，并且每个节点提供总需求资源的一半。
 */
@Data
public class Vm {
    private String type ;//型号
    private int cpuNum;//cpu核数
    private int memorySize;//内存大小
    private boolean isDoubleNode;//是否双节点部署



    public Vm(String  type, int cpuNum, int memorySize, boolean isDoubleNode) {
        this.type = type;
        this.cpuNum = cpuNum;
        this.memorySize = memorySize;
        this.isDoubleNode = isDoubleNode;
    }

    @Override
    public String toString() {
        return "Vm{" +
                "type='" + type + '\'' +
                ", cpuNum=" + cpuNum +
                ", memorySize=" + memorySize +
                ", isDoubleNode=" + isDoubleNode +
                '}';
    }
}
