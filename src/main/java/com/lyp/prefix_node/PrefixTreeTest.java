package com.lyp.prefix_node;

import java.util.Arrays;

/**
 * @author Liu Yanping
 * @date 2022/10/23 11:15
 */
public class PrefixTreeTest {
    public static void main(String[] args) {
        PrefixNode prefixNode = new PrefixNode();
        prefixNode.insert("abc");
        prefixNode.insert("abe");
        prefixNode.insert("apple");
        prefixNode.insert("be");
        prefixNode.insert("abe");
        prefixNode.insert("bec");
        prefixNode.insert("be");
        System.out.println(prefixNode.count("ab"));
        System.out.println(prefixNode.countPrefix("a"));
        System.out.println(Arrays.toString(prefixNode.prefixStr("apl").toArray()));
    }
}
