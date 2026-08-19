package c11_imple;
import java.io.*;
import java.util.*;
public class pro_12938_최고의집합 {
	public int[] solution(int n, int s) {
        //각 component의 원가격
        int x = s/n;
        //n개 에 대한 +1 offset
        int y = s%n;
        
        if(x==0) return new int[]{-1};
        
        int[] answer = new int[n];
        for(int i=0;i<n;i++){
            answer[i] = x;
        }
        for(int i=0;i<y;i++){
            answer[i] +=1;
        }
        
        Arrays.sort(answer);
        //System.out.println(Arrays.toString(answer));
        
        return answer;
    }

}
