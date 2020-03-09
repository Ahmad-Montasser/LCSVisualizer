package com.company;

import java.util.Arrays;

public class LCS {
    private int[][] c ;
    private String[][] b ;

    public int[][] getC() {
        return c;
    }

    public String[][] getB() {
        return b;
    }

    public LCS(String firstWord, String secondWord){
        int m = firstWord.length();
        int n = secondWord.length();
        c = new int [m+1][n+1];
        b = new String[m+1][n+1];

        for (int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                if(firstWord.charAt(i-1)==secondWord.charAt(j-1)){
                    c[i][j] =c[i-1][j-1]+1;
                    b[i][j] ="TL";
                }
                else if(c[i-1][j]>=c[i][j-1]){
                    c[i][j]=c[i-1][j];
                    b[i][j]="T";
                }
                else {
                    c[i][j] = c[i][j - 1];
                    b[i][j] = "L";
                }
            }
        }
        for (int i = 0; i < c.length; i++)
            System.out.println(Arrays.toString(c[i]));
        for (int i = 0; i < c.length; i++)
            System.out.println(Arrays.toString(b[i]));
    }

}
