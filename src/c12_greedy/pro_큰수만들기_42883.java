package c12_greedy;
import java.io.*;
import java.util.*;
//이건 그냥 원리를 알고 있어야할듯
//이전 풀이가 틀린 반례 32145
public class pro_큰수만들기_42883 {
	public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int len = number.length();
        
        for(int i=0;i<len;i++){
            char cur = number.charAt(i);
            
            while(sb.length() >0 && sb.charAt(sb.length()-1)<cur && k>0){
                sb.deleteCharAt(sb.length()-1);
                k--;
            }
            
            sb.append(cur);
        }
        
        
        //만약 9876 처럼 완벽한 내림차순이라서 위에서 하나도 안지워지고 k가 남았다면 k를 뒤에서부터 잘라냅니다.
        return sb.substring(0, sb.length()-k);
    }
}
