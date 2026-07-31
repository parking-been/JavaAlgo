package c9_dp;
import java.io.*;
import java.util.*;
public class pro_땅따먹기_12913 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int solution(int[][] land) {
        int n = land.length;
        int[][] dp = new int[n][4];
        
        for(int i=0;i<4;i++){
            dp[0][i] = land[0][i];
        }
        
        for(int i=1;i<n;i++){
            
            for(int j=0;j<4;j++){
            
                //윗행에서 최대값 구하기 같은 열 제외하고 
                int tmp = 0;
                for(int k=0;k<4;k++){
                    if(j!=k){
                        tmp = Math.max(dp[i-1][k], tmp);
                    }
                }
                dp[i][j] = land[i][j] + tmp;
                
            }
        }
        
        // for(int[] tt : dp){
        //     System.out.println(Arrays.toString(tt));
        // }
        
        int result= 0;
        for(int i=0;i<4;i++){
            result = Math.max(dp[n-1][i], result);
        }
        
        int answer = 0;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return result;
    }
}
