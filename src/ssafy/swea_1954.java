package ssafy;
import java.io.*;
import java.util.*;
public class swea_1954 {
	static int[][] move = {{0,1},{1,0},{0,-1},{-1,0}};
	static int N;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int T;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			N = Integer.parseInt(br.readLine());
			int[][] array = new int[N][N];
			int x = 0;
			int y = 0;
			int idx = 0;
			for(int i=1;i<=N*N;i++) {
				array[x][y] = i;
				
				//¥Ÿ¿Ωƒ≠ ≈Ωªˆ«œ±‚
				int tx = move[idx][0];
				int ty = move[idx][1];
				
				if(x+tx<0 || x+tx>=N || y+ty<0 || y+ty>=N || array[x+tx][y+ty]!=0) {
					//πÊ«‚¿ª πŸ≤€¥Ÿ.
					idx = (idx+1)%4;
					tx = move[idx][0];
					ty = move[idx][1];
				}
				
				x = tx + x;
				y = ty + y;
				
			}
			sb.append("#" + t + "\n");
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					sb.append(array[i][j] + " ");
				}
				sb.append("\n");
			}
			
			
			//System.out.println(Arrays.deepToString(array));
			
		}
		System.out.println(sb.toString());

	}

}
