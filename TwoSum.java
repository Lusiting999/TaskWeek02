package com.test;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /**
     * 思路1：暴力解决：两个for循环寻找差值target - nums[i] = nums[j]
     */
    /*public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if(target - nums[i] == nums[j]) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }*/

    /**
     * 思路2：哈希表
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<>();
        //遍历数组
        for (int i = 0; i < nums.length; ++i) {
            //转换公式，map.key = target - nums[i]
            if (hashtable.containsKey(target - nums[i])) {
                //发现则找到两数之和
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            //未发现则保存在map中
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}
