package c4_string;

import java.io.*;
import java.util.*;

public class t4_01_reverseArray {
	static ArrayList<Integer> save;
	//Array 를 list로 바꾸는 방법!! <- 알아보기
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		Solution(n);
		
	}
	
	public static int[] Solution(long n) {
		long x = n;
		save = new ArrayList<>();
//		System.out.println(1234%10);
//		System.out.println(1234/10);
		
		while(true) {
			//왜 틀린거냐? : 원래는 (int) x%10 을 했다. 
			// -> 근데 (int) 연산자는 나머지 연산자 % 보다 우선순위가 높다.
			// 따라서 (int)x 가 먼저 실행된 후 %10 이 계산됨으로 틀린것이다. 
			int t = (int)(x%10);
			save.add(t);
			long waste = x / 10;
			if(waste==0) {
				break;
			}else {
				x = waste;
			}
		}
		
		
		int[] answer = new int[save.size()];
		int i= 0;
		for(int y: save) {
			answer[i] = y;
			i++;
		}
		
		System.out.println(Arrays.toString(answer));
		return answer;
	}
}
