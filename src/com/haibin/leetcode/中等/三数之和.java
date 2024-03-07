package com.haibin.leetcode.中等;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @project: leetcode
 * @className: 三数之和
 * @description:
 * @author: zhanghaibin
 * @create: 2024-03-05
 */

/**
 * 第一思路就是三重循环，肯定不行
 * 第二思路：
 *
 */
public class 三数之和 {
    /**
     * 我最喜欢的版本
     * @param nums
     * @return
     */
    //定义三个指针，保证遍历数组中的每一个结果
    //画图，解答
    public List<List<Integer>> threeSum2(int[] nums) {
        //定义一个结果集
        List<List<Integer>> res = new ArrayList<>();
        //数组的长度
        int len = nums.length;
        //当前数组的长度为空，或者长度小于3时，直接退出
        if(nums == null || len <3){
            return res;
        }
        //将数组进行排序
        Arrays.sort(nums);
        //遍历数组中的每一个元素
        for(int i = 0; i<len;i++){
            //如果遍历的起始元素大于0，就直接退出
            //原因，此时数组为有序的数组，最小的数都大于0了，三数之和肯定大于0
            if(nums[i]>0){
                break;
            }
            //去重，当起始的值等于前一个元素，那么得到的结果将会和前一次相同
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int l = i +1;
            int r = len-1;
            //当 l 不等于 r时就继续遍历
            while(l<r){
                //将三数进行相加
                int sum = nums[i] + nums[l] + nums[r];
                //如果等于0，将结果对应的索引位置的值加入结果集中
                if(sum==0){
                    // 将三数的结果集加入到结果集中
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    //在将左指针和右指针移动的时候，先对左右指针的值，进行判断
                    //如果重复，直接跳过。
                    //去重，因为 i 不变，当此时 l取的数的值与前一个数相同，所以不用在计算，直接跳
                    while(l < r && nums[l] == nums[l+1]) {
                        l++;
                    }
                    //去重，因为 i不变，当此时 r 取的数的值与前一个相同，所以不用在计算
                    while(l< r && nums[r] == nums[r-1]){
                        r--;
                    }
                    //将 左指针右移，将右指针左移。
                    l++;
                    r--;
                    //如果结果小于0，将左指针右移
                }else if(sum < 0){
                    l++;
                    //如果结果大于0，将右指针左移
                }else if(sum > 0){
                    r--;
                }
            }
        }
        return res;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        // 首先对数组进行排序，这是双指针方法的前提
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        // 外层循环从数组的开始遍历到倒数第三个元素
        for(int k = 0; k < nums.length - 2; k++){
            // 如果当前数字大于0，则三数之和一定大于0，结束循环
            if(nums[k] > 0) break;
            // 跳过相同的数字，避免重复解
            if(k > 0 && nums[k] == nums[k - 1]) continue;
            // i，j分别为k后面的两端，向中间遍历
            int i = k + 1, j = nums.length - 1;
            while(i < j){
                int sum = nums[k] + nums[i] + nums[j];
                // 三数之和小于0，左指针向右移动
                if(sum < 0){
                    while(i < j && nums[i] == nums[++i]); // 跳过重复元素
                } else if (sum > 0) {
                    // 三数之和大于0，右指针向左移动
                    while(i < j && nums[j] == nums[--j]); // 跳过重复元素
                } else {
                    // 找到有效解，添加到结果中
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                    // 继续寻找其他解，跳过重复的元素
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                }
            }
        }
        // 返回所有满足条件的三元组
        return res;
    }
}
