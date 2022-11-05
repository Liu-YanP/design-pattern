package com.lyp.bitmap;

import com.google.common.hash.BloomFilter;

import java.util.Arrays;
import java.util.BitSet;

/**
 * bitmap 位图数据结构
 *
 * @author Liu Yanping
 * @date 2022/10/22 22:10
 * 将 2 存入bitmap
 * 0 1 2 3 4 5 6
 * 0 0 1 0 0 0 0 = 4
 * 将 4 存入  2^n
 * 0 0 0 0 1 0 0 = 16
 *
 */
public class BitmapTest {
    public static void main(String[] args) {
        BitSet bitSet = new BitSet(8);
        bitSet.set(4); // 内部数据存储的值为  4
        bitSet.set(3);
        boolean b = bitSet.get(3);
        System.out.println(b);
        System.out.println(Arrays.toString(bitSet.toLongArray()));
    }
}
