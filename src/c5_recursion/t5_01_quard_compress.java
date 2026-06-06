package c5_recursion;

import java.io.*;
import java.util.*;
public class t5_01_quard_compress {
	
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
	public static int[] recursive(int[][] arr, int x, int y, int len) {
		
		int[] answer = new int[2];
		
		int pre = arr[x][y];
		if (len==1) {
			//그냥 return
			answer[pre]=1;
			return answer;
		}
		
		
		boolean flag = true; //모두 같은 값이다. 
		
		for(int i=x;i<x+len;i++) {
			for(int j=y;j<y+len;j++) {
				if(pre!=arr[i][j]) {
					flag = false;
					break; // break 위치 관련 -> 이중 for문 나갈려면 how?
				}
			}
		}
		
		
		if(flag==true) {
			answer[pre]=1;
			return answer;
		}
		
		int nlen = len/2;
		
		int[] a1 = recursive(arr, x, y, nlen);
		int[] a2 = recursive(arr, x+nlen, y, nlen);
		int[] a3 = recursive(arr, x, y+nlen, nlen);
		int[] a4 = recursive(arr, x+nlen, y+nlen, nlen);
		
		answer[0] = a1[0] + a2[0] + a3[0] + a4[0];
		answer[1] = a1[1] + a2[1] + a3[1] + a4[1];
		return answer;
	}
	
	public static int[] Solution(int[][] arr) {
		
		int[] answer = recursive(arr, 0, 0, arr.length);
		
		//System.out.println(Arrays.toString(result));
		
		return answer;
		
		
	}
}
