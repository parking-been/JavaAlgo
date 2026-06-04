package c3_array;
import java.io.*;
import java.util.*;

public class t3_01_MakeAStar {
	
	static HashSet<Point> pSet = new HashSet<>();
	static long maxiX = Long.MIN_VALUE; 
	static long miniX =  Long.MAX_VALUE;
	static long maxiY = Long.MIN_VALUE;
	static long miniY = Long.MAX_VALUE;
	
	public static class Point {
		long x;
		long y;
		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
		
		// HashSet이 중복을 올바르게 제거할 수 있도록 equals와 hashCode 추가
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Point point = (Point) o;
			return x == point.x && y == point.y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
		
	}
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int n = Integer.parseInt(br.readLine());
		int[][] iPut = new int[n][3];
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				iPut[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// input
		//System.out.println(Arrays.deepToString(iPut));
		Solution(iPut);
		// output
		

	}
	
	public static void calculate(int[] line1, int[] line2) {
		long a = line1[0];
		long b = line1[1];
		long e = line1[2];
		long c = line2[0];
		long d = line2[1];
		long f = line2[2];
		
		long abcd = a*d-c*b;
		if(abcd==0) {
			// 예외처리 -> 그냥 안담으면 된다. 
		}
		else {
			double y = (c*e-a*f)/(double)abcd;
			double x = (b*f-e*d)/(double)abcd;
			
			if(x%1==0 && y%1==0) {
				
				long X = (long)x;
				long Y = (long)y;
				pSet.add(new Point(X,Y));
				miniX = Math.min(X, miniX);
				maxiX = Math.max(X, maxiX);
				
				miniY = Math.min(Y, miniY);
				maxiY = Math.max(Y, maxiY);
						
			}
			
			
		}
		
	}
	
	public static void Solution(int[][] line) {
		
		for(int i=0;i<line.length;i++) {
			for(int j=i+1;j<line.length;j++) {
				calculate(line[i], line[j]);
			}
			
		}
		
//		for(Point x : pSet) {
//			System.out.println(x.x + " " + x.y);
//		}
		
		long height = maxiY - miniY + 1;
		long width = maxiX - miniX + 1;
		String[] answer = new String[(int)height];
		String[][] tmp = new String[(int)height][(int)width];
		for(int i=0;i<height;i++) {
			for(int j=0;j<width;j++) {
				tmp[i][j] = ".";
			}
		}
		
		
		
		for(Point p:pSet) {
			long ny = maxiY - p.y;
			long nx = p.x - miniX;
			
			
			tmp[(int)ny][(int)nx] = "*";
			
		}
		
		for(int i=0;i<(int)height;i++) {
			String re = String.join("", tmp[i]);
			answer[i] = re;
		}
		
		
		System.out.println(Arrays.toString(answer));
		
	}

}
