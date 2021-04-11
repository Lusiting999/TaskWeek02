package com.test.week02;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        //遍历
        for (String str : strs) {
            char[] array = str.toCharArray();
            //排序
            Arrays.sort(array);
            String key = new String(array);
            //按照array转成字符串作为key保存
            //获取之前是否已有保存，没有则新建聊表
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            //按照key保存链表
            map.put(key, list);
        }
        //返回链所有值
        return new ArrayList<List<String>>(map.values());
    }
}
