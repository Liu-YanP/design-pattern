package com.lyp.hash;

/**
 * 常见服务器节点实体
 *
 * @author Liu Yanping
 * @date 2021/6/14 16:03
 */
public class MachineNode {
    private String ip;

    public MachineNode(String ip, String name) {
        this.ip = ip;
        this.name = name;
    }

    private String name;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.ip;
    }
}
