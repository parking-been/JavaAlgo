package c5_recursion;
import java.io.*;
import java.util.*;
public class t5_02_hanoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Solution {
	    public static List<int[]> arr = new ArrayList<>();
	    public int[][] solution(int n) {
	        move(n, 1, 2, 3);
	        int[][] answer = arr.toArray(new int[arr.size()][]);
	        
	        return answer;
	    }
	    
	    public static void move(int cnt, int start, int mid, int end){
	        if(cnt==0) return;
	        move(cnt-1, start, end, mid);
	        arr.add(new int[]{start,end});     
	        move(cnt-1, mid, start, end);
	    }
	}

}
