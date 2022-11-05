package com.lyp.hash;

import java.util.*;

/**
 * 测试一致性hash算法
 *
 * @author Liu Yanping
 * @date 2021/6/14 16:19
 */
public class TestHashCircle {

    private static String IP_PREFIX = "192.34.6.";
    public static void main(String[] args) {
        //记录每个机器机器上保存的数据个数
        HashMap<String, Integer> map = new HashMap<>();
        //模拟10台服务器
        ArrayList<MachineNode> machines = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            map.put(IP_PREFIX + i, 0);
            machines.add(new MachineNode(IP_PREFIX+i,i+""));
        }

        HashService hashService = new HashService();
        //创建一个副本书为200的hash环
        ConsistentHash<MachineNode> consistentHash = new ConsistentHash<>(hashService, 200, machines);
        //创建10000条数据，看数据在机器上的分布情况
        for (int i = 0; i < 10000; i++) {
            String key = UUID.randomUUID().toString() + i;
            // 映射的实际节点
            MachineNode machineNode = consistentHash.get(key);
            map.put(machineNode.getIp(), map.get(machineNode.getIp()) + 1);
        }

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println("服务器："+entry.getKey()+"   命中："+entry.getValue()+"次");
        }


    }
}
