package com.saurabhSeleniumAuto.ex_selenium_18_Jul_2024;

public class L319 {


    public static void main(String[] args) {
        String s = "Neeru";
        char a[] = new char[s.length()];
        int j = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            a[j] = s.charAt(i);
            System.out.print(a[j]);
        }

        System.out.println(a);
        for (int k = 0; k < a.length; k++)
            System.out.print(a[k]);
    }

}
