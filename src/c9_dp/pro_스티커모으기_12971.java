package c9_dp;
import java.io.*;
import java.util.*;
public class pro_스티커모으기_12971 {

	public int solution(int sticker[]) {
        int answer = 0;
        int n = sticker.length;
        
        if(n==1) return sticker[0];
        else if(n==2) {
            return Math.max(sticker[0], sticker[1]);
        }
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");
        //첫번째 스티커를 선택하냐
        dp1[0] = sticker[0];
        dp1[1] = sticker[0];
        for(int i=2;i<n-1;i++){
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + sticker[i]);
            answer = Math.max(answer, dp1[i]);
        }
        
         //첫번 째 스티커 선택 안하냐
        dp2[0] = 0;
        dp2[1] = sticker[1];
        
        for(int i=2;i<n;i++){
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + sticker[i]);
            answer = Math.max(answer, dp2[i]);
        }
        
        //System.out.println(Arrays.toString(dp2));
        
       
        
        
        return answer;
    }
}
