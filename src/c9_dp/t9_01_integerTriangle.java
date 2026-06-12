package c9_dp;
import java.io.*;
import java.util.*;
public class t9_01_integerTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static int N;
    static int[][] sum;
    public int solution(int[][] triangle) {
        int answer = 0;
        N = triangle.length;
        sum = new int[N][N];
        
        answer = dp(0,0,triangle);
        
        
        
        return answer;
    }
    
    public static int dp(int i, int j, int[][] triangle){
        if(N-1==i){
            return triangle[i][j];
        }
        if(sum[i][j]!=0) return sum[i][j];
        
        sum[i][j] = triangle[i][j] + Math.max(dp(i+1,j,triangle), dp(i+1,j+1,triangle));
        return sum[i][j];
        
    }

}
