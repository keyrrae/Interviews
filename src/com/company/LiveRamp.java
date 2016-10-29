package com.company;

import java.util.Arrays;

/**
 * Created by xuanwang on 10/22/16.
 */
public class LiveRamp {
    public static void main(String[] args){
        //int[] a = {1,2,5,5,5,5,9,8,8,9};
        int[] a = {1,2};

        String r = maxTime(8,8,8,8);
        int res = sol(a);
        System.out.println("");
    }

    public static int sol(int[] a){

        if(a.length <= 1) return 0;

        int[] left = new int[a.length];
        int max = a[0];
        left[0] = a[0];
        for(int i = 1; i < a.length; i++){
            max = Math.max(max, a[i]);
            left[i] = max;
        }
        int rightIdx = -1;
        for(int i = a.length - 1; i >= 0; i--){
            if(a[i] != left[i]){
                rightIdx = i;
                break;
            }
        }
        int[] right = new int[a.length];
        right[a.length - 1] = a[a.length - 1];
        int min = a[a.length - 1];
        for(int i = a.length-1; i >= 0; i--){
            min = Math.min(min, a[i]);
            right[i] = min;
        }
        int leftIdx = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i] != right[i]){
                leftIdx = i;
                break;
            }
        }

        return rightIdx - leftIdx + 1;
    }


    public static String maxTime(int A, int B, int C, int D){
        int[] a = new int[4];
        boolean[] b = new boolean[4];
        Arrays.fill(b, true);
        a[0] = A; a[1] = B; a[2] = C; a[3] = D;

        StringBuilder sb = new StringBuilder();

        String s = "";

        s = helper(a, b, 0, 2);
        if(s.equals("NOT POSSIBLE")) return s;
        sb.append(s);

        s = helper(a, b, 0, 3);
        if(s.equals("NOT POSSIBLE")) return s;
        sb.append(s);

        sb.append(':');

        s = helper(a, b, 0, 5);
        if(s.equals("NOT POSSIBLE")) return s;
        sb.append(s);

        s = helper(a, b, 0, 9);
        if(s.equals("NOT POSSIBLE")) return s;
        sb.append(s);

        return sb.toString();

    }

    public static String helper(int[] a, boolean[] b, int minVal, int maxVal){
        int max = -1;
        int maxIdx = -1;
        boolean valid = false;
        for(int i = 0; i < 4; i++){

            if(a[i] > max && a[i] <= maxVal && b[i]){
                max = a[i];
                maxIdx = i;
                valid = true;
            }
        }

        if(!valid) return "NOT POSSIBLE";
        b[maxIdx] = false;
        return String.valueOf(max);
    }
}
