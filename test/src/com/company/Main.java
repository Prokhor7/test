package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int i,j;
        boolean act;
        String count,yn;
        String[] v;
        char[] cnt;
        boolean Arabic,Roman;
        Scanner scan=new Scanner(System.in);
        System.out.println("!!!Attention!!!\nThis calculator can work with Roman numerals from I to X and Arabic numerals from 1 to 10\nYou can enter a + b, a-b, a * b, a / b\n!!!Attention!!!");
        while(true){
            System.out.println("Enter your expression: ");
            count=scan.nextLine();
            count=count.replaceAll("\\s+","");
            act=false;
            cnt=new char[count.length()];
            cnt=count.toCharArray();
            for(i=0;i<cnt.length;i++){
                switch(cnt[i]){
                    case '+' : act=true;break;
                    case '-' : act=true;break;
                    case '*' : act=true;break;
                    case '/' : act=true;break;
                }
                if(act)break;
                if((!act)&&((i+1)==cnt.length)){
                    System.out.println("Wrong expression!!!");
                    break;
                    }
            }
            if(!act){System.out.println("Arithmetic operation not found");}
            v=count.split(String.valueOf("\\"+cnt[i]));
            if (v.length>2){
                System.out.println("Wrong expression!!!");
            } else {
                Arabic = false;
                Roman = false;
                for (j = 0; j < 2; j++) {
                    if (j == 0 || Arabic == true) {
                        switch (v[j]) {
                            case "1":
                                Arabic = true;
                                break;
                            case "2":
                                Arabic = true;
                                break;
                            case "3":
                                Arabic = true;
                                break;
                            case "4":
                                Arabic = true;
                                break;
                            case "5":
                                Arabic = true;
                                break;
                            case "6":
                                Arabic = true;
                                break;
                            case "7":
                                Arabic = true;
                                break;
                            case "8":
                                Arabic = true;
                                break;
                            case "9":
                                Arabic = true;
                                break;
                            case "10":
                                Arabic = true;
                                break;
                            default:
                                Arabic = false;
                        }
                    }
                }
                for (j = 0; j < 2; j++) {
                    if (j == 0 || Roman == true) {
                        switch (v[j]) {
                            case "I":
                                Roman = true;
                                break;
                            case "II":
                                Roman = true;
                                break;
                            case "III":
                                Roman = true;
                                break;
                            case "IV":
                                Roman = true;
                                break;
                            case "V":
                                Roman = true;
                                break;
                            case "VI":
                                Roman = true;
                                break;
                            case "VII":
                                Roman = true;
                                break;
                            case "VIII":
                                Roman = true;
                                break;
                            case "IX":
                                Roman = true;
                                break;
                            case "X":
                                Roman = true;
                                break;
                            default:
                                Roman = false;
                                break;
                        }
                    }
                }
                if(!(Roman||Arabic)){System.out.println("Wrong expression!!!");}
                if (Arabic) {
                    switch (cnt[i]) {
                        case '+':
                            System.out.println("=" + add(Integer.valueOf(v[0]), Integer.valueOf(v[1])));
                            break;
                        case '-':
                            System.out.println("=" + subtract(Integer.valueOf(v[0]), Integer.valueOf(v[1])));
                            break;
                        case '*':
                            System.out.println("=" + multiply(Integer.valueOf(v[0]), Integer.valueOf(v[1])));
                            break;
                        case '/':
                            System.out.println("=" + divide(Integer.valueOf(v[0]), Integer.valueOf(v[1])));
                            break;

                    }
                } else if (Roman) {
                    switch (cnt[i]) {
                        case '+':
                            System.out.println("=" + arabictoroman(add(romantoarabic(v[0]), romantoarabic(v[1]))));
                            break;
                        case '-':
                            System.out.println("=" + arabictoroman(subtract(romantoarabic(v[0]), romantoarabic(v[1]))));
                            break;
                        case '*':
                            System.out.println("=" + arabictoroman(multiply(romantoarabic(v[0]), romantoarabic(v[1]))));
                            break;
                        case '/':
                            if ((divide(romantoarabic(v[0]), romantoarabic(v[1])) % 1) == 0) {
                                System.out.println("=" + arabictoroman((int) divide(romantoarabic(v[0]), romantoarabic(v[1]))));
                            } else {
                                System.out.println("no fractional roman numbers!!!");
                            }
                            break;

                    }
                }
            }
            while (true){
                System.out.println("Try again?(Y/N)");
                yn=scan.next();
                if((yn.equals("Y"))||(yn.equals("y"))){
                    break;
                }else if((yn.equals("N"))||(yn.equals("n"))){
                    break;
                }else{
                    System.out.println("incorrect answer");
                }
            }
            if((yn.equals("N"))||(yn.equals("n"))){break;}
            scan.nextLine();
        }
    }

    private static int add(int a,int b){
        return a+b;
    }
    private static int subtract(int a,int b){
        return a-b;
    }
    private static int multiply(int a,int b){
        return a*b;
    }
    private static float divide(float a,float b){
        return a/b;
    }

    private static int romantoarabic(String r){
        int a;
        switch (r){
            case"I": a=1;break;
            case"II": a=2;break;
            case"III": a=3;break;
            case"IV": a=4;break;
            case"V": a=5;break;
            case"VI": a=6;break;
            case"VII": a=7;break;
            case"VIII": a=8;break;
            case"IX": a=9;break;
            case"X": a=10;break;
            default: a=0;System.out.println("Wrong expression!!!");
        }
        return a;
    }

    static int arabic[]  = {1, 4, 5, 9, 10, 50, 100, 500};

    static String roman[]  = { "I", "IV", "V", "IX", "X", "L", "C", "D"};

    private static String arabictoroman(int a){
        if(a==0){
            System.out.println("0 does not exist in roman numbers!!!");
            return "ERROR";
        } else {
            String r="";
            int n=a,i;
            if(a<0){
                n=-a;
            }
            while (n>0){
                for(i=0;i<arabic.length;i++){
                    if(n<arabic[i]){
                        n-=arabic[i-1];
                        r+=roman[i-1];
                        break;
                    }

                }
            }
            if(a<0){
                return "-"+r;
            }else {
                return r;
            }
        }
    }
}
