package ssafy;
import java.io.*;
import java.util.*;

public class swea_1940 {
	static int distance = 0;
	static int curSpeed = 0;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int N = Integer.parseInt(br.readLine());
			distance = 0;
			curSpeed = 0;
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int curCom = Integer.parseInt(st.nextToken());
				
				if(curCom==0) {
					distance = curSpeed + distance;
					
				} else if(curCom==1) {
					
					int dt = Integer.parseInt(st.nextToken());
					curSpeed = curSpeed + dt;
					distance = curSpeed + distance;
				} else if(curCom==2) {
					int dt = Integer.parseInt(st.nextToken());
					curSpeed = Math.max(curSpeed - dt, 0);
					distance = curSpeed + distance;
				}
				
			}
			
			sb.append("#" + t + " " + distance ).append("\n");
			
			
		}
		System.out.println(sb.toString());
		

	}

}
