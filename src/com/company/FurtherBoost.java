package com.company;

/**
 * Created by xuanwang on 10/24/16.
 */
public class FurtherBoost {
    public static void main(String[] args){
        int[] tc1 = {0, 1, 2, 3, 4, 5};
        int[] tc2 = {0, 1, 2, 3, 3, 5};
        int[] tc3 = {0, 1, 2, 3, 2, 1};
        int[] tc4 = {4, 3, 2, 1, 0, 2, 3 };
        int[] tc5 = {0, 0, 0, 0};
        boolean r = isMono(tc5);
        return;
    }

    public static boolean isMono(int[] nums){
        if(nums == null || nums.length <= 1) return false;

        boolean inc = false, dec = false;
        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] < nums[i]){
                if(dec) {
                    return false;
                } else {
                    inc = true;
                }
            }
            if(nums[i-1] > nums[i]){
                if(inc){
                    return false;
                } else {
                    dec = true;
                }
            }
        }
        return dec || inc;
    }
}
