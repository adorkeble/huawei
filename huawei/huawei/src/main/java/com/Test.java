package com;

import com.cqu.*;

import java.util.List;

/**
 * @version 1.0
 * @author:罗天天
 * @date 2021/3/13  14:53
 * Test :   测试类
 */
public class Test {

    public static void main(String[] args) {
        DealAllData dealAllData = new DealAllData();
        //training-1 test
        String filepath1 = "C:\\Users\\73851\\Desktop\\华为\\huawei\\src\\main\\java\\com\\data\\test.txt";
        String filepath = "C:\\Users\\73851\\Desktop\\华为\\huawei\\src\\main\\java\\com\\data\\training-1.txt";
        dealAllData.packageData(filepath1);

        int N = dealAllData.getN();//可以采购的服务器类型数量
        int M = dealAllData.getM();//售卖的虚拟机类型数量。
        int T=dealAllData.getT();//表示题目共会给出 T 天的用户请求序列数据。
        Vm[] vms=dealAllData.getVms();//M行虚拟机类型
        Server[] servers = dealAllData.getServers();//N行服务器类型
        RequestVmOneDay[] requestVmOneDays = dealAllData.getRequestVmOneDays();//T 天的用户请求序列数据

        
        System.out.println("-----servers------");
        Utils.seeAllServer(servers);
        System.out.println("-------requestVmOneDays--------");
        Utils.seeAllDayRequestVm(requestVmOneDays);
        System.out.println("------Vms-----");
        Utils.seeAllVms(vms);


    }
}
