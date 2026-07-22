package c9_dp;
import java.io.*;
import java.util.*;
public class swea_1952 {
	static int[] money;
	static int[] plan;
	static int[] dp;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			money = new int[4];
			plan = new int[13];
			dp = new int[13];
			StringTokenizer m = new StringTokenizer(br.readLine());
			for(int i=0;i<4;i++) {
				money[i] = Integer.parseInt(m.nextToken());
			}
			
			StringTokenizer p = new StringTokenizer(br.readLine());
			for(int i=1;i<13;i++) {
				plan[i] = Integer.parseInt(p.nextToken());
			}
			
			//dp 
			int ans = dp();
			System.out.println("#"+t+" "+ans);
			
		}

	}
	
	public static int dp() {
		for(int i=1;i<=12;i++) {
			dp[i] = Math.min(dp[i-1] + plan[i]*money[0] , dp[i-1] + money[1]);
			if(i>=3) {
				dp[i] = Math.min(dp[i-3]+money[2], dp[i]);
			}
		}
		
		int ans = Math.min(dp[12],money[3]);
		return ans;
	}

}
