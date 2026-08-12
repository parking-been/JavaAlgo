package c12_greedy;
import java.io.*;
import java.util.*;
public class pro_단속카메라_42884 {
	 static List<int[]> arr;
	    public int solution(int[][] routes) {
	        Arrays.sort(routes, (o1, o2) -> o1[0] - o2[0]);
	        arr = new ArrayList<>();
	        for(int[] route : routes){
	            if(arr.size()==0){
	                arr.add(route);
	                continue;
	            }
	            int[] cur = arr.get(arr.size()-1);
	            if(cur[1] >= route[0]){
	                //겹치는거다. 
	                arr.remove(arr.size()-1);
	                arr.add(new int[]{Math.max(route[0], cur[0]), Math.min(route[1], cur[1])});
	            }
	            else{
	                arr.add(new int[] {route[0], route[1]});
	            }
	            
	            
	        }
	        
	        // for(int[] a : arr){
	        //     System.out.println(Arrays.toString(a));
	        // }
	        
	        
	        
	        return arr.size();
	    }

}
