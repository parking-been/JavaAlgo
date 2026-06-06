package c5_recursion;
//최적화한 버전
import java.io.*;
import java.util.*;
public class t5_01_quard_compress2 {
	static int[] answer;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//System.out.println(Arrays.deepToString(arr));
		Solution(arr);

	}
	
	public static boolean zipChk(int[][] arr, int x, int y, int len) {
		 
		int pre = arr[x][y];
		
		for(int i=x;i<x+len;i++) {
			for(int j=y;j<y+len;j++) {
				if(pre!=arr[i][j]) {
					return false;
				}
			}
		}
		
		return true;
		
	}
	
	public static void recursive(int[][] arr, int x, int y, int len) {
		
		
		
		
		if (zipChk(arr, x, y, len)) {
			if(arr[x][y]==1) answer[1]++;
			else answer[0]++;
			return ;
		}
		
		
		int nlen = len/2;
		recursive(arr, x, y, nlen);
		recursive(arr, x+nlen, y, nlen);
		recursive(arr, x, y+nlen, nlen);
		recursive(arr, x+nlen, y+nlen, nlen);
		
	}
	
	public static int[] Solution(int[][] arr) {
		
		answer = new int[2];
		recursive(arr, 0, 0, arr.length);
		
		System.out.println(Arrays.toString(answer));
		
		return answer;
		
		
	}
}
