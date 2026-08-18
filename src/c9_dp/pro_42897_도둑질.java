package c9_dp;
import java.io.*;
import java.util.*;
public class pro_42897_µµµÏÁú {
	static int[] dp1;
    static int[] dp2;
    static int maxi=0;
    public int solution(int[] money) {
        dp1 = new int[money.length];
        dp2 = new int[money.length];
        
        //Ã³À½²¨ ÅÐ¾úÀ» ¶§
        dp1[0] = money[0];
        dp1[1] = money[0];
        
        for(int i=2;i<money.length-1;i++){
           dp1[i] = Math.max(dp1[i-1], dp1[i-2] + money[i]);     
            maxi = Math.max(maxi, dp1[i]);
        }
        
        //System.out.println(Arrays.toString(dp1));
        
        //Ã³À½²¨ ¾ÈÅÐ¾úÀ» ¶§ 
        dp2[0] = 0;
        dp2[1] = money[1];
        
        for(int i=2;i<money.length;i++){
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + money[i]);     
            maxi = Math.max(maxi, dp2[i]);
        }
        //System.out.println(Arrays.toString(dp2));
        
        //int answer = 0;
        return maxi;
    }

}
