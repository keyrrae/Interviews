package com.company;

import java.util.*;

/**
 * Created by xuanwang on 10/28/16.
 */
public class GooglePhone {
    public static void main(String[] args){
        Set<String> dict = new HashSet<String>(){{
            add("hello");
            add("hi");
            add("lot");
            add("laugh");
            add("me");
        }};
        char[] lst = {'h', 'l', 'm'};
        List<String> l = getLongestWord(dict, lst);
        return;
    }

    public static List<String> getLongestWord(Set<String> dict, char[] lst){
        List<String> ans = new ArrayList<>();

        if(dict == null || lst == null || lst.length == 0){
            return ans;
        }

        Map<Character, String> map = new HashMap<>();
        for(String s: dict){
            char c = s.charAt(0);
            if(!map.containsKey(c)) {
                map.put(c, s);
                continue;
            }
            if(s.length() > map.get(c).length()){
                map.put(c, s);
            }
        }
        for(char c: lst){
            ans.add(map.get(c));
        }
        return ans;
    }
}
