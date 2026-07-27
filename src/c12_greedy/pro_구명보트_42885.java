package c12_greedy;
import java.io.*;
import java.util.*;
public class pro_구명보트_42885 {
	public int solution(int[] people, int limit) {
        int left = 0;
        int right = people.length-1;
        int count = 0;
        Arrays.sort(people);
        //System.out.println(Arrays.toString(people));
        while(left<=right){
            if(people[left] + people[right]<=limit){
                left++;
            }
            right--;
            count++;
        }
        
        //System.out.println(count);
        
        //int answer = 0;
        return count;
    }
}
