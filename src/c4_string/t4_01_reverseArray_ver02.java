package c4_string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.*;
import java.io.*;

public class t4_01_reverseArray_ver02 {
	static ArrayList<Integer> save;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		Solution(n);

	}
	public static int[] Solution(long n) {
		String s = new StringBuilder(String.valueOf(n)).reverse().toString();
		
		int[] answer = new int[s.length()];
		for(int i=0;i<s.length();i++) {
			answer[i] = s.charAt(i) -'0';
		}
		return answer;
	}

}
