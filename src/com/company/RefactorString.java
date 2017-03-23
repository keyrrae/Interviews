package com.company;

import java.util.*;

public class RefactorString {

    public static void main(String[] args) {
        /*
        String s = "dir1\n" +

                " dir11\n" +
                " dir12\n" +
                "  picture.jpeg\n" +
                "  dir121\n" +
                "  file1.txt\n" +
                "dir2\n" +
                " fire2.gif\n";*/

        String res = refactorSerialNumber("82-skSk29-s", 5);


        //int res = getLength(s);
        //int rav = removeav(0);

        System.out.println("Hello World!");

    }

    public static String refactorSerialNumber(String s, int k){

        if (s == null || s.length() == 0){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        int idx = s.length()-1;

        int cnt = 0;
        while(idx >= 0){
            char c = s.charAt(idx);
            if(c == '-'){
                idx--;
                continue;
            }

            if(idx == 0 ){
                sb.append(c);
            }
            else if(cnt == k-1){
                sb.append(Character.toUpperCase(c));
                sb.append('-');
                cnt = 0;
            }else {
                sb.append(Character.toUpperCase(c));
                cnt++;
            }
            idx--;
        }
        return sb.reverse().toString();
    }



}