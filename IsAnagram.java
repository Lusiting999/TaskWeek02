package com.test.week02;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {

    //思路1：先排序，再比较
    /*public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sChar = s.toCharArray();
        Arrays.sort(sChar);
        char[] tChar = t.toCharArray();
        Arrays.sort(tChar);
        return Arrays.equals(sChar,tChar);
    }*/

    //思路2：遍历消除=暴力法
    /*public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        for (int i = 0; i < sChar.length; ++i) {
            for (int j = i; j < tChar.length; ++j) {
                if (sChar[i] == tChar[j]) {
                    if (i != j) {
                        char temp = tChar[i];
                        tChar[i] = tChar[j];
                        tChar[j] = temp;
                    }
                    break;
                }
                if (j == sChar.length - 1 && sChar[i] != tChar[j]) {
                    return false;
                }
            }
        }
        return true;
    }*/

    //计数法1
    /*public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            int[] alpha = new int[26];
            for(int i = 0; i< s.length(); i++) {
                alpha[s.charAt(i) - 'a'] ++;
                alpha[t.charAt(i) - 'a'] --;
            }
            for(int i = 0; i < 26; i++)
                if(alpha[i] != 0) return false;
            return true;
    }*/



    //解决进阶问题，unicode字符
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        //int[] table = new int[26];
        Map<Character, Integer> table = new HashMap<>();
        //统计
        for (char sChar: s.toCharArray()) {
            //table[sChar - 'a']++;
            table.put(sChar, table.getOrDefault(sChar, 0) + 1);
        }
        //遍历检测
        for (char tChar: t.toCharArray()) {
            //table[tChar - 'a']--;
            table.put(tChar, table.getOrDefault(tChar, 0) - 1);
            //只要出现多出一个的一律是非异位词
            //if (table[tChar - 'a'] < 0) {
            if (table.getOrDefault(tChar, 0) < 0) {
                return false;
            }
        }
        return true;
    }
}
