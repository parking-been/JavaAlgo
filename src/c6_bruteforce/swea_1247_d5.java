package c6_bruteforce;
import java.io.*;
import java.util.*;
public class swea_1247_d5 {
	static int N;
	static int[] office;
	static int[] home;
 	static int[][] custom;
 	static int minDistance;
 	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			minDistance = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			visited = new boolean[N];
			//일단 회사
			StringTokenizer st = new StringTokenizer(br.readLine());
			int officeX = Integer.parseInt(st.nextToken());
			int officeY = Integer.parseInt(st.nextToken());
			office = new int[] {officeX, officeY};
			// 집
			int homeX = Integer.parseInt(st.nextToken());
			int homeY = Integer.parseInt(st.nextToken());
			home = new int[] {homeX, homeY};
			custom = new int[N][2];
			for(int i=0;i<N;i++) {
				custom[i] = new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
			}
			
			//System.out.println(Arrays.deepToString(custom));
			//dfs
			dfs(0,0,office[0], office[1]);
			//System.out.println(minDistance);
			sb.append("#" + t + " " + minDistance + "\n");
		}
		System.out.println(sb.toString());

	}
	static int distance(int x, int y, int x2, int y2) {
		return Math.abs(x-x2)+Math.abs(y-y2);
	}
	
	static void dfs(int depth,int sum, int cX, int cY) {
		if (depth==N) {
			//회사까지 거리 구하고, min update
			sum += distance(cX, cY, home[0], home[1]);
			minDistance = Math.min(sum, minDistance);
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(!visited[i]) {
				int tmp = distance(cX, cY, custom[i][0], custom[i][1]);
				visited[i] = true;
				dfs(depth+1, sum+tmp, custom[i][0], custom[i][1]);
				visited[i] = false;
			}
		}
	}

}
