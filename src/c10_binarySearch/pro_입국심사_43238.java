package c10_binarySearch;
import java.io.*;
import java.util.*;
public class pro_입국심사_43238 {
	public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        
        //이진 분류이자, lowerbound이다. lowerbound 구현하고 되는지 확인하자.
        long result = lowerBound(times, n);
        
        return result;
    }
    
    public static long check(long x, int times[]){
        long sum = 0;
        for(int time: times){
            sum +=(x/time);
        }
        return sum;
    }
    
    public static long lowerBound(int[] times, int n){
        long answer = 1_000_000_000_000_000_000L;
        long left = 0;
        long right = 1_000_000_000_000_000_000L;
        while(left<=right){
            long mid = (left + right)/2;
            if(check(mid, times)<n){ //여기서 재고 a[mid]<x
                left = mid + 1;
                
            }else{
                right = mid -1;
            }
        }
        
        return left;
    }

}
