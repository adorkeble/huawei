package com.cqu;

import java.util.List;

/**
 * @version 1.0
 * @author:罗天天
 * @date 2021/3/13  13:48
 *  Utils：工具类
 */
public class Utils {

    //遍历Vm数组，得到各个类型的虚拟机类型
    public static void seeAllVms(Vm[] vms){
        for(Vm vm:vms){
            System.out.println(vm.toString());
        }
    }

    //遍历RequestVmOneDay数组，得到每一天的请求数据
    public  static void seeAllDayRequestVm(RequestVmOneDay[] requestVmOneDays){
        int count=1;//所在日期
        for(RequestVmOneDay requestVmOneDay:requestVmOneDays){
            List<RequestVm> requestVms = requestVmOneDay.getRequestVms();
            System.out.println("第"+count+"天的请求一共有"+requestVms.size()+"条，分别是：");
            count++;
            for(RequestVm requestVm:requestVms){
                System.out.println(requestVm.toString());
            }
        }
    }
    //遍历Server数组,得到各个类型的服务器类型
    public static void seeAllServer(Server[] map) {
        for (Server server : map) {
            System.out.println(server.toString());
        }
    }
    //对String类型数据进行去空格
    public static String delSpace(String s){
        String s1 = s.replaceAll(" ", "");
        return s1;
    }

    //每一行的(String类型)请求数据转换成RequestVm对象
    public static RequestVm transforTORequestVm(String s) {
        boolean isAdd;//增加虚拟机
        boolean isDel;//删除虚拟机
        String type;//虚拟机型号
        int vMId;//虚拟机ID
        String res = s.substring(1, s.length()-1);
        String[] strings = res.split(",");
        if (strings.length == 2) {
            isAdd = false;
            isDel = true;
            vMId = Integer.valueOf(strings[1]);
            return new RequestVm(isDel, vMId);
        } else {
            isAdd = true;
            isDel = false;
            type = strings[1];
            vMId = Integer.valueOf(strings[2]);
        }
        return new RequestVm(isAdd, isDel, type, vMId);
    }

    //每一行的(String类型)虚拟机数据转换成Vm对象
    public static Vm transforToVm(String s) {
        String res = s.substring(1, s.length()-1);
        String[] strings = res.split(",");
        String type = strings[0];//型号
        int cpuNum = Integer.valueOf(strings[1]);//cpu核数
        int memorySize = Integer.valueOf(strings[2]);//内存大小
        boolean isDoubleNode = Integer.valueOf(strings[3]) == 0 ? false : true; //是否双节点部署
        return new Vm(type, cpuNum, memorySize, isDoubleNode);
    }

    //每一行的(String类型)服务器数据转换成Server对象
    public static Server transforTOServer(String s) {
        String res = s.substring(1, s.length()-1);
        String[] strings = res.split(",");
        String type = strings[0];//型号
        int cpuNum = Integer.valueOf(strings[1]);//cpu核数
        int memorySize = Integer.valueOf(strings[2]);//内存大小
        int hardwareCost = Integer.valueOf(strings[3]);//硬件成本
        int dailyEnergyCost = Integer.valueOf(strings[4]);//每日能耗成本
        return new Server(type, cpuNum, memorySize, hardwareCost, dailyEnergyCost);
    }
}


