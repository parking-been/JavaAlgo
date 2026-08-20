package c11_imple;
import java.io.*;
import java.util.*;

public class pro_161988_연속펄스부분수열의합 {
	 public long solution(int[] sequence) {
	        int N = sequence.length;
	        //long[] sum = new long[N];
	        long tmp = 0;
	        long mini = 0;
	        long maxi = 0;
	        for(int i=0;i<N;i++){
	            tmp+=sequence[i]*(i%2==1?-1:1);
	            //sum[i] = tmp;
	            mini = Math.min(mini, tmp);
	            maxi = Math.max(maxi, tmp);
	        }
	        
	        //System.out.println(Arrays.toString(sum));
	        
	        long answer = 0;    
	        return (Math.abs(mini-maxi));
	    }

}
