package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xuanwang on 10/26/16.
 */
public class Microsoft {

    public static void main(String[] args){
        int[] arr = {0,1,3,6,7,8,10,11,12};
        int[] nzp = {43,0,324,-324,-56,-34,0,234,7,0,-34};
        int[] tc2s = {2,3,7,4,5,6,3};

        List<int[]> aa = twoSumLarger(tc2s, 10);
        List<Integer> ans = closestK(arr, 9, 5);
        sortNZP(nzp);
        String vvv = atoi(Integer.MIN_VALUE);
        return;
    }


    public static String atoi(int a){
        String sign = "";
        int value = a;
        if(a < 0){
            if(a == Integer.MIN_VALUE) return "-2147483648";
            value = -value;
            sign = "-";
        }
        StringBuilder sb = new StringBuilder();
        while(value != 0){
            sb.append(value % 10);
            value /= 10;
        }
        sb.append(sign);
        return sb.reverse().toString();
    }

    public static List<int[]> twoSumLarger(int[] a, int target){

        List<int[]> ans = new ArrayList<>();
        if(a == null || a.length <= 1) return ans;

        int left = 0, right = a.length - 1;
        Arrays.sort(a);
        while(left <= right){
            int v = a[left] + a[right];
            int cur = left;
            if(v >= target){
                while(left < right) {
                    int[] temp = new int[2];
                    temp[0] = a[left++];
                    temp[1] = a[right];
                    ans.add(temp);
                }
                left = cur;
                right--;
            }else{
                left++;
            }

        }
        return ans;
    }

    public static void sortNZP(int[]a){
        int left = 0, right = a.length-1;

        int cur = 0;
        while(cur <= right){
            if(a[cur] < 0){
                swap(a, left, cur);
                left++;
                cur++;
            }else if(a[cur] > 0){
                swap(a, cur, right);
                right--;
            }else{
                cur++;
            }
        }
    }

    public static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static List<Integer> closestK(int[]a, int target, int k){
        List<Integer> ans = new ArrayList<>();
        if(a == null || a.length == 0) return ans;
        int left = 0, right = a.length - 1;

        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(a[mid] < target){
                left = mid;
            }else{
                right = mid;
            }
        }
        int count = 0;

        while(left >= 0 && right < a.length && count < k){
            if( target - a[left] < a[right] - target){
                ans.add(a[left--]);
                count++;
            } else {
                ans.add(a[right++]);
                count++;
            }
        }

        if(count == k){
            return ans;
        }

        while(left >= 0 && count < k){
            ans.add(a[left--]);
            count++;
        }
        while(right < a.length && count < k){
            ans.add(a[right++]);
            count++;
        }
        return ans;
    }

}
