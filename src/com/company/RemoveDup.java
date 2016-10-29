package com.company;

/**
 * Created by xuanwang on 10/21/16.
 */
public class RemoveDup {

    public static void main(String[] args){
        int test = 32110;
        int rr = removedup(test);
        int rs = removesb(test);
        System.out.println("Hello World");

    }

    private static int removedup(int t) {
        if (t / 10 == 0) {
            return t;
        }
        String s = String.valueOf(t);

        String res = "" + s.charAt(0);
        boolean foundInc = false;
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i - 1) && s.charAt(i) < s.charAt(i + 1)) {
                res += s.substring(i + 1);
                foundInc = true;
                break;
            }
            res += s.charAt(i);
        }

        if (!foundInc && s.charAt(s.length() - 2) != s.charAt(s.length() - 1)) {
            res += s.charAt(s.length() - 1);
        }
        return Integer.valueOf(res);
    }

    private static int removeav(int t) {
        if (t / 10 == 0) {
            return t;
        }
        String s = String.valueOf(t);

        String res = "";

        boolean foundInc = false;
        for (int i = 0; i < s.length() - 1; i++) {
            int avg = (int) Math.ceil((s.charAt(i) - '0' + s.charAt(i + 1) - '0') / 2.0);
            if (s.charAt(i) < s.charAt(i + 1)) {
                res += (char) (avg + '0') + s.substring(i + 2);
                foundInc = true;
                break;
            }
            res += s.charAt(i);
        }

        if (!foundInc) {
            res += s.charAt(s.length() - 1);
        }
        return Integer.valueOf(res);
    }

    private static int removesb(int X) {
        if (X / 10 == 0) {
            return X;
        }
        String s = String.valueOf(X);

        StringBuilder sb = new StringBuilder();

        boolean foundInc = false;
        for (int i = 0; i < s.length() - 1; i++) {
            int avg = (int) Math.ceil((s.charAt(i) - '0' + s.charAt(i + 1) - '0') / 2.0);
            if (s.charAt(i) < s.charAt(i + 1)) {
                sb.append(avg);
                sb.append(s.substring(i+2));
                foundInc = true;
                break;
            }
            sb.append(s.charAt(i));
        }

        if (!foundInc) {
            sb.deleteCharAt(sb.length()-1);
            int avg = (int) Math.ceil((s.charAt(s.length() - 1) - '0' + s.charAt(s.length() - 2) - '0') / 2.0);
            sb.append(avg);
        }
        return Integer.valueOf(sb.toString());
    }
}
