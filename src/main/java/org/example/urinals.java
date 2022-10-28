package org.example;
import java.util.Scanner;
//Author Mohana Deepthi Karumanchi

public class urinals {

    public static boolean validString(String str) {
       for(int i=0; i<str.length();i++)
       {
           if(str.charAt(i)=='0' || str.charAt(i)=='1')
           {
               if (i > 0 && str.charAt(i) == '1' && str.charAt(i - 1) == '1')
               {
                   return false;
               }
           }
           else{
           return false;
           }
       }
       return true;
    }

    public static int resultUrinals(String urinals){
        
        String[] uri = urinals.split("");
        int result = 0;
        boolean bool = true;
        for (int i = 0; i < uri.length; i++) {
            boolean prev = bool && (i == 0 || uri[i - 1].equals("0"));
            boolean current = uri[i].equals("0");
            boolean next = (i + 1) == uri.length || uri[i + 1].equals("0");
            if(prev && current && next) {
                result++;
                bool = false;
            } else {
                bool = true;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        while(sc.hasNext()){
            String str= sc.next();
            if(!str.equals("-1")) {
                if (validString(str)) {
                    System.out.println("Free Urinals Count :" + resultUrinals(str));
                } else {
                    System.out.println("Invalid String, print -1");
                }
            }
            else System.exit(0);
        }
    }
}