package com.lyp.hash;

import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 实现一致性hash算法环的构建
 *
 * @author Liu Yanping
 * @date 2021/6/14 16:05
 */
public class ConsistentHash<T> {
    private IHashService hashService;
    private int numberOfReplicas;
    private final SortedMap<Long, T> circle = new TreeMap<>();

    public ConsistentHash(IHashService hashService, int numberOfReplicas, Collection<T> nodes) {
        this.hashService = hashService;
        this.numberOfReplicas = numberOfReplicas;
        for (T node : nodes) {
            add(node);
        }
    }

    private void add(T node) {
        //创建副本
        for (int i = 0; i < numberOfReplicas; i++) {
            this.circle.put(hashService.hash(node.toString() + i), node);
        }
    }

    //根据key 获取机器节点
    public T get(String key) {
        if (circle.isEmpty()) return null;

        long hashVal = hashService.hash(key);

        if (!circle.containsKey(hashVal)) {
            SortedMap<Long, T> tailMap = circle.tailMap(hashVal);
            hashVal = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
        }
        return circle.get(hashVal);
    }
}
