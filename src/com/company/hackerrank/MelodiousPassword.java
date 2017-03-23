package com.company.hackerrank;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuanwang on 3/23/17.
 */
public class MelodiousPassword {
    // https://www.hackerrank.com/contests/w30/challenges/melodious-password

    //TODO: change to memorization
    static char[] vows = {'a', 'e', 'i', 'o', 'u'};
    static char[] cons = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'z'};

    public static List<String> generateAllMelodiousPassword(int n){
        List<String> res = new ArrayList<>();
        if(n == 0){
            return res;
        }

        helper(res, new StringBuilder(), false, n);
        helper(res, new StringBuilder(), true, n);
        return res;
    }

    private static void helper(List<String> res, StringBuilder path, boolean lastIsVow, int remain){
        if(remain == 0){
            res.add(path.toString());
            return;
        }

        if(lastIsVow){
            for(int i = 0; i < cons.length; i++){
                path.append(cons[i]);
                helper(res, path, false, remain - 1);
                path.setLength(path.length() - 1);
            }
        } else {
            for (int i = 0; i < vows.length; i++) {
                path.append(vows[i]);
                helper(res, path, true, remain - 1);
                path.setLength(path.length() - 1);
            }
        }
    }

    public static void main(String[] args){
        List<String> res = generateAllMelodiousPassword(3);
        int i = 0;
    }
}
