package com.cqu;

import lombok.Data;

/**
 * @version 1.0
 * @author:罗天天
 * @date 2021/3/11  21:05
 *
 *   Server：         服务器类型
 *   type：           型号              服务器型号长度不超过 20，仅由数字和大小写英文字符构成。
 *   cpuNum：         CPU 核数          每台服务器的 CPU 核数不超过 1024
 *   memorySize：     内存大小          每台服务器的 内存大小不超过 1024
 *   hardwareCost：   硬件成本          硬件成本不超过 5 ×105
 *   dailyEnergyCost：每日能耗          每日能耗成本不超过 5000
 *   aMemorySize：    A节点内存大小
 *   bMemorySize：    A节点内存大小
 *   aCpuNum：        B节点CPU数
 *   bCpuNum：        B节点CPU数        服务器拥有的资源（CPU 和内存）均匀分布在这两个节点上。
 *
 */

@Data
public class Server {
    private String  type;//型号
    private int cpuNum;//cpu核数
    private int memorySize;//内存大小
    private int hardwareCost;//硬件成本
    private int dailyEnergyCost;//每日能耗成本
    private int aMemorySize;//A节点内存大小
    private int bMemorySize;//B节点内存大小
    private int aCpuNum;//A节点CPU数
    private int bCpuNum;//B节点CPU数

    @Override
    public String toString() {
        return "Server{" +
                "type='" + type + '\'' +
                ", cpuNum=" + cpuNum +
                ", memorySize=" + memorySize +
                ", hardwareCost=" + hardwareCost +
                ", dailyEnergyCost=" + dailyEnergyCost +
                '}';
    }

    public Server(String  type, int cpuNum, int memorySize, int hardwareCost, int dailyEnergyCost) {
        this.type = type;
        this.cpuNum = cpuNum;
        this.memorySize = memorySize;
        this.hardwareCost = hardwareCost;
        this.dailyEnergyCost = dailyEnergyCost;
    }
}
