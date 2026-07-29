package c11_imple;
import java.io.*;
import java.util.*;
public class pro_½Ã¼ÒÂ¦²á_152996 {
public long solution(int[] weights) {
        
        Arrays.sort(weights);
        //System.out.println(Arrays.toString(weights));
        long answer = 0;
        HashMap<Double, Integer> map = new HashMap<>();
        //System.out.println((double)answer);
        
        //1, (3/2), (4/2), (4/3)
        for(int w : weights){
            double weight = (double) w;
            if(map.containsKey(weight)) {
                answer += map.get(weight);
                //System.out.println(weight);
            }
            
            if(map.containsKey(weight * (2.0/3.0))) {
                answer += map.get(weight * (2.0/3.0));
                //System.out.println(weight);
            }
            if(map.containsKey(weight * (2.0/4.0))){ 
                answer += map.get(weight * (2.0/4.0));
                //System.out.println(weight);
            }
            if(map.containsKey(weight * (3.0/4.0))){ 
                answer += map.get(weight * (3.0/4.0));
                //System.out.println(weight);
            }
            
            if(map.containsKey(weight)) {
                map.put(weight, map.get(weight) +1);
                
            }
            else {map.put(weight, 1);}
            
        }
        
        //long answer = 0;
        
        return answer;
    }

}
