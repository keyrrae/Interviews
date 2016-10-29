package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by xuanwang on 10/21/16.
 */
public class PathLength {
    public static void main(String[] args){

        String s1 = "dir1\n" +

                " dir11\n" +
                " dir12\n" +
                "  picture.jpeg\n" +
                "  dir121\n" +
                "  file1.txt\n" +
                "dir2\n" +
                " fire2.gif\n";

        String s2 = "a.jpeg";
        int k = getLength3(s2);
        System.out.println("Hello World");


    }

    private static int getLength(String input) {
        HashMap<Integer, Integer> levelMap = new HashMap<>();
        HashMap<Integer, Boolean> dupMap = new HashMap<>();
        levelMap.put(-1, 1);
        dupMap.put(-1, false);
        int result = 0;
        for (String s : input.split("\n")) {
            int level = s.lastIndexOf(" ") + 1;
            String dir = s.substring(level);
            int len = dir.length();
            dupMap.put(level, false);
            if (s.contains(".jpeg") || s.contains(".png") || s.contains(".gif")) {
                if (dupMap.containsKey(level - 1) && dupMap.get(level - 1)) {
                    continue;
                }
                result += levelMap.get(level - 1);
                dupMap.put(level - 1, true);

            } else if (s.contains(".")) {
                continue;
            } else {
                levelMap.put(level, levelMap.get(level - 1) + len);
            }
        }
        return result;

    }

    private static int getLength2(String input) {
        HashMap<Integer, Integer> levelMap = new HashMap<>();
        HashMap<Integer, Boolean> dupMap = new HashMap<>();
        levelMap.put(0, 0);
        dupMap.put(0, false);
        int result = 0;
        for (String s : input.split("\n")) {
            int level = s.lastIndexOf(" ") + 2;
            String dir = s.substring(level - 1);
            int len = dir.length();
            dupMap.put(level, false);
            if (s.contains(".jpeg") || s.contains(".png") || s.contains(".gif")) {
                if (dupMap.containsKey(level - 1) && dupMap.get(level - 1)) {
                    continue;
                }
                if (level == 1) {
                    result += 1;
                } else {
                    result += levelMap.get(level - 1);
                }
                dupMap.put(level - 1, true);

            } else if (s.contains(".")) {
                continue;
            } else {
                levelMap.put(level, levelMap.get(level - 1) + len + 1);
            }
        }
        return result;

    }

    private static int getLength3(String S) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 0);
        int result = 0;
        for (String s : S.split("\n")) {
            int level = s.lastIndexOf(" ") + 1;
            int len = s.substring(level).length();
            if (s.contains(".jpeg") || s.contains(".gif") || s.contains("tif")) {
                if(level == 0){
                    result = Math.max(result, 1);
                }else {
                    result = Math.max(result, hashMap.get(level));
                }
            } else {
                hashMap.put(level + 1, hashMap.get(level) + len + 1);
            }
        }
        return result;
    }

    private static int getLength4(String input) {

        List<Integer> arr = new ArrayList<>();
        arr.add(0);
        int result = 0;
        for (String s : input.split("\n")) {
            int level = s.lastIndexOf(" ") + 1;
            int len = s.substring(level).length();
            if (s.contains(".jpeg") || s.contains(".gif") || s.contains("tif")) {
                result = Math.max(result, arr.get(level));
            } else {
                if (arr.size() < level + 2) {
                    arr.add(arr.get(level) + len + 1);
                } else {
                    arr.set(level + 1, arr.get(level) + len + 1);
                }
            }
        }
        return result;
    }
}
