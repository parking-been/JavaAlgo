package c7_BfsDfs;
import java.io.*;
import java.util.*;
public class swea_1949 {
	static int T;
	static int N;
	static int K;
	static int[][] map;
	static boolean[][] visited;
	static int[][] move = {{-1,0 }, {1,0}, {0,-1},{0,1}};
	static int maxLen;
	static List<int[]> tops;
	public static int findTop() {
		int top = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				top = Math.max(top, map[i][j]);
			}
		}
		return top;
	}
	
	public static void findRoute(int x, int y, int h,int len) {
		
		maxLen = Math.max(maxLen, len);
		
		for(int[] m : move) {
			int nx = x + m[0];
			int ny = y + m[1];
			
			if(nx>=0 && ny>=0 && nx<N && ny<N && h> map[nx][ny] && !visited[nx][ny]) {
				visited[nx][ny] = true;
				findRoute(nx, ny, map[nx][ny], len+1);
				visited[nx][ny] = false;
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for(int i=0;i<N;i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st2.nextToken());
				}
			}
			
			//System.out.println(Arrays.deepToString(map));
			//일단 젤 긴 길 찾기 함수 만들기
			//findRoute(int x, int y, int h);
			//maxLen = 0;
			//findRoute(3,2, map[2][3]);
			//System.out.println(maxLen);
			//System.out.println(K);
			visited = new boolean[N][N];
			maxLen = 0;
			
			
			
			tops = new ArrayList<>();
			int top = findTop();
			//경로 찾기
			for(int a=0;a<N;a++) {
				for(int b=0;b<N;b++) {
					if(top==map[a][b]) {
						
						visited[a][b] = true;
						findRoute(a, b, map[a][b], 1);
						visited[a][b] = false;
						tops.add(new int[] {a,b});
					}
				}
			}
			
			
			
			
			
			
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					for(int k=1;k<=K;k++) {
						
						if(map[i][j] - k < 0) {
							continue;
						}
						
						map[i][j] =map[i][j] -k;
						//큰 봉우리 찾고,
						
						//System.out.println(Arrays.deepToString(map));
						
						for(int[] tot : tops) {
							int a = tot[0];
							int b = tot[1];
							visited[a][b] = true;
							findRoute(a, b, map[a][b], 1);
							visited[a][b] = false;
						}
						
									
									
								
						
						map[i][j] =map[i][j] +k;
					}
				}
			}
			sb.append("#" + t + " " + maxLen + "\n");
			
			
		}
		
		System.out.println(sb);
	}

}
