package com.company;

import java.util.regex.*;
/**
 * Created by xuanwang on 10/25/16.
 */
public class RegMatch {

    public static void main(String[] args){
        String s = "<select name=\"state\">\n" +
                "<option value=\"Alabama\">Alabama</option>\n" +
                "<option value=\"Alaska\">Alaska</option>\n" +
                "<option value=\"Arizona\">Arizona</option>\n" +
                "<option value=\"Arkansas\">Arkansas</option>\n" +
                "<option value=\"California\">California</option>\n" +
                "</select>";

        boolean ans = match(s);
        return;

    }

    public static boolean match(String s){
        String[] t = s.split("\\n");
        String patternSelect = "^<select name=\"\\.*\">$";
        String patternMid = "^<option value=\".*\">.*</option>$";
        String patternEndSelect = "^</select>$";


       if(!t[0].matches(patternSelect)){
           return false;
       }


       for(int i =1; i <= t.length-2; i++){
           if(!t[i].matches(patternMid)) return false;
       }

        return t[t.length - 1].matches(patternEndSelect);

    }
}
