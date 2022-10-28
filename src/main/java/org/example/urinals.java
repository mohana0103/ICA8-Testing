package org.example;
import java.io.*;
import java.util.Scanner;
//Author Mohana Deepthi Karumanchi

public class urinals {

    public static boolean validString(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0' || str.charAt(i) == '1') {
                if (i > 0 && str.charAt(i) == '1' && str.charAt(i - 1) == '1') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static int resultUrinals(String urinals) {

        String[] uri = urinals.split("");
        int result = 0;
        if(urinals.equals(null)) return 0;
        if(urinals.equals("0")) return 1;
        if(urinals.equals("1")) return 0;
        if(urinals.contains("11")) return -1;
        boolean bool = true;
        for (int i = 0; i < uri.length; i++) {
            boolean prev = bool && (i == 0 || uri[i - 1].equals("0"));
            boolean current = uri[i].equals("0");
            boolean next = (i + 1) == uri.length || uri[i + 1].equals("0");
            if (prev && current && next) {
                result++;
                bool = false;
            } else {
                bool = true;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Input Preference\n");
        System.out.println("PRESS 1 to explicitly give input ");
        System.out.println("PRESS 2 to take input from file~ Urinals.dat");
        Scanner sc = new Scanner(System.in);
        int temp = sc.nextInt();
        if (temp == 1) {
            System.out.println("Enter a string: ");
            while (sc.hasNext()) {
                String str = sc.next();
                if (!str.equals("-1")) {
                    if (validString(str)) {
                        System.out.println(resultUrinals(str));
                    } else {
                        System.out.println("-1");
                    }
                } else System.exit(0);
            }
        } else {
            String[] fileNames = new String[100];
            for(int i=0;i<100;i++){
                if(i==0){
                    fileNames[0] = "rule.txt";
                }
                else{
                    fileNames[i] = "rule"+ i +".txt";
                }
            }
            FileReader fs = new FileReader("src/main/java/org/example/Urinals.dat");
            BufferedReader fb = new BufferedReader(fs);
            String filePath = "src/main/java/org/example/";
            for(int i=0;i<100;i++){
                File f = new File(filePath+fileNames[i]);
                if(f.exists() && !f.isDirectory()) {
                    continue;
                }
                else{
                    filePath = filePath + fileNames[i];
                    break;
                }
            }
            File myObj = new File(filePath);
            myObj.createNewFile();
            BufferedWriter ob = new BufferedWriter(new FileWriter(filePath));

            String str = fb.readLine();

            while (str != null) {
                if (!str.equals("-1")) {
                    if (validString(str)) {
                        str= String.valueOf(resultUrinals(str));
                        ob.write(str);
                        ob.newLine();
                        //System.out.println(resultUrinals(str));
                    } else {
                        ob.write("-1");
                        ob.newLine();
                    }
                } else System.exit(0);
                str = fb.readLine();
            }
            ob.close();
        }
    }
}