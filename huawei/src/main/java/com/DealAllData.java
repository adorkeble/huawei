package com;

import com.cqu.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @author:罗天天
 * @date 2021/3/13  14:50
 * 每一个测试用例：
 * *  * 第一行           包含一个整数 N(1≤N≤100)，表示可以采购的服务器类型数量。
 * *  * 接下来 N 行：    每行描述一种类型的服务器，数据格式为：(型号, CPU 核数, 内存大小, 硬件成本, 每日能耗成本)。
 * *  * 接下来一行：     整数 M(1≤M≤1000)，表示售卖的虚拟机类型数量。
 * *  * 接下来 M 行：    每行描述一种类型的虚拟机，数据格式为：(型号, CPU 核数, 内存大小, 是否双节点部署)。
 * *  * 是否双节点部署用 0 和 1 表示，0 表示单节点部署，1 表示双节点部署。
 * *  * 接下来一行：      整数 T(1≤T≤1000)，表示题目共会给出 T 天的用户请求序列数据。
 * *  * <p>
 * *  * <p>
 * *  * 对于每一天的数据：  第一行包含一个非负整数 R 表示当天共有 R 条请求。
 * *  * 接下来 R 行，按顺序给出每一条请求数据。
 * *  * 请求数据的格式为：(add, 虚拟机型号, 虚拟机 ID)或(del, 虚拟机 ID)分别表示创建一台虚拟机或者删除一台虚拟机。
 */
@Data
public class DealAllData {
    private int N;//可以采购的服务器类型数量
    private int M;//售卖的虚拟机类型数量。
    private int T;//表示题目共会给出 T 天的用户请求序列数据。
    private Server[] servers;//N行服务器类型
    private Vm[] vms;//M行虚拟机类型
    private RequestVmOneDay[] requestVmOneDays;//T 天的用户请求序列数据

    public void packageData(String filepath) {
        //读取txt文件
        ReadTxtData readTxtData = new ReadTxtData();
        readTxtData.readLineNio(filepath);
        // 采用BIO模式读取txt文件，并按照行存入configList
        List<String> configList = readTxtData.getConfigList();

        //第一行  服务器类型数量 N
        N = Integer.valueOf(configList.get(0));

        //第二到N+1行  N行服务器类型
        servers = new Server[N];
        for (int i = 0; i < N; i++) {
            String s = configList.get(i + 1);
            Server server = Utils.transforTOServer(s);
            servers[i] = server;
        }

        //第N+2行   虚拟机类型数量M
        M = Integer.valueOf(configList.get(N + 1));

        //第N+3到N+2+M行   M行虚拟机类型
        vms = new Vm[M];
        for (int j = 0; j < M; j++) {
            String string = configList.get(N + 2 + j);
            Vm vm = Utils.transforToVm(string);
            vms[j] = vm;
        }

        //第N+3+M行  整数 T(1≤T≤1000)，表示题目共会给出 T 天的用户请求序列数据。
        T = Integer.valueOf(configList.get(N + 2 + M));
        // T 天的用户请求序列数据
        requestVmOneDays = new RequestVmOneDay[T];

        int R;//每一天的请求数据的长度
        int count = N + 3 + M;//当前所在行
        for (int i = 0; i < T; i++) {
            String s = configList.get(count);
            count++;
            R = Integer.valueOf(s);
            List<RequestVm> requestVms = new ArrayList<>();
            for (int j = 0; j < R; j++) {
                String ss = configList.get(count);
                count++;
                RequestVm requestVm = Utils.transforTORequestVm(ss);
                requestVms.add(requestVm);
            }
            requestVmOneDays[i] = new RequestVmOneDay(requestVms, R);

        }

    }

}
