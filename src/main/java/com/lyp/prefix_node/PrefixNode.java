package com.lyp.prefix_node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 前缀树 的实现
 *
 * @author Liu Yanping
 * @date 2022/10/23 10:45
 */
public class PrefixNode {
    /**
     * 当前单词出现个数
     */
    private int count;
    /**
     * 前缀相同的个数
     */
    private int prefixCount;

    /**
     * 前缀树的后续节点
     */
    private PrefixNode[] nextNodes = new PrefixNode[26];

    private Character[] characters = new Character[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public PrefixNode(){
        count = 0;
        prefixCount = 0;
    }

    public void insert(String str) {
        PrefixNode root = this;
        if (str == null || str.length() < 1) {
            return;
        }
        for (char c : str.toCharArray()) {
            if (root.nextNodes[c - 'a'] == null) {
                root.nextNodes[c - 'a'] = new PrefixNode();
            }
            root = root.nextNodes[c - 'a'];
            root.prefixCount++;
        }
        root.count++;
    }

    public boolean startWith(String str) {
        if (count(str)==-1) {
            return false;
        }
        return true;
    }

    /**
     * 返回该字符串在前缀树中存在的个数
     *
     * 
     * @param str
     * @return
     */
    public int count(String str) {
        if (str == null || str.length() < 1) {
            return -1;
        }
        PrefixNode root = this;
        for (char c : str.toCharArray()) {
            if (root.nextNodes[c-'a']==null) {
                return -1;
            }
            root = root.nextNodes[c - 'a'];
        }
        return root.count;
    }

    /**
     * 返回具有相同前缀的子字符串个数
     *
     * @param str
     * @return
     */
    public int countPrefix(String str) {
        if (str == null || str.length() < 1) {
            return -1;
        }
        PrefixNode root = this;
        for (char c : str.toCharArray()) {
            if (root.nextNodes[c-'a']==null) {
                return root.prefixCount;
            }
            root = root.nextNodes[c - 'a'];
        }
        return root.prefixCount;
    }

    /**
     * 返回具有相同前缀的字符串
     *
     * @param prefix
     * @return
     */
    public List<String> prefixStr(String prefix) {
        if (prefix==null) {
            return null;
        }
        PrefixNode root = this;
        StringBuilder sb = new StringBuilder();
        List<String> strList = new ArrayList<>();
        for (char c : prefix.toCharArray()) {
            // 前缀部分在前缀树中
            if (root.nextNodes[c - 'a'] == null) {
                if (root.prefixCount < 1) {
                    return strList;
                }
                subNode(root, sb, strList);
                return strList;
            }
            sb.append(c);
            root = root.nextNodes[c - 'a'];
        }
        // 整个前缀都在前缀树中
        subNode(root, sb, strList);
        return strList;
    }

    private void subNode(PrefixNode root, StringBuilder sb,List<String> strList) {
        for (int i = 0; i < root.nextNodes.length; i++) {
            StringBuilder innerSb = new StringBuilder(sb);
            if (root.nextNodes[i] != null) {
                innerSb.append(characters[i]);
                if (root.nextNodes[i].count >0) {
                    strList.add(innerSb.toString());
                }
                subNode(root.nextNodes[i], innerSb, strList);
            }
        }
    }

}
