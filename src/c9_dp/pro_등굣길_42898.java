package c9_dp;
import java.io.*;
import java.util.*;


public class pro_등굣길_42898 {
	//1은 장애물
    static int[][] map;
    static int[][] dp;
    public int solution(int m, int n, int[][] puddles) {
        //map 만들기
        map = new int[n][m];
        for(int[] pud : puddles){
            int x = pud[1];
            int y = pud[0];
            map[x-1][y-1] = 1;
        }
        //dp 만들기
        dp = new int[n][m];
        dp[0][0] = 1;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
                if((i == 0 && j == 0) || map[i][j] == 1) continue; 
                
                
                if(i-1>=0 && map[i][j]!=1 && map[i-1][j]!=1){
                    dp[i][j] += dp[i-1][j];
                }
                if(j-1>=0  && map[i][j]!=1 && map[i][j-1]!=1){
                    dp[i][j] += dp[i][j-1];
                }
                
                dp[i][j]%=1000000007;
            }
        }
        
        //System.out.println(dp[n-1][m-1]);
        // for(int[] d : dp){
        //     System.out.println(Arrays.toString(d));
        // }
        return dp[n-1][m-1];
        
    }

}
