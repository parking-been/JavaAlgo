package c11_imple;
import java.io.*;
import java.util.*;

public class pro_괄호변환 {

	class Solution {
	    public String solution(String p) {
	        
	        String result = simulation(p);
	        return result;
	        //System.out.println(result);
	        //System.out.println(checkRight(")("));
	        //String x = "1234";
	        //...
	        //System.out.println(x.substring(0,3));
	        
	        //String answer = "";
	        //return answer;
	    }
	    
	    public static String simulation(String x){
	        
	        
	        if(x.length()==0) return "";
	        
	        //String totalst = "";
	        
	        // u 랑 v로 나누기
	        int prefixA = 0; //( count
	        int prefixB = 0; //) count
	        int postfixU = 0; //u의 ) 부분
	        for(int i=0;i<x.length();i++){
	            char cc = x.charAt(i);
	            if(cc=='('){
	                prefixA ++;
	            }
	            else{
	                prefixB ++;
	            }
	            
	            if(prefixA>0 && prefixA ==prefixB){
	                postfixU = i;
	                break;
	            }
	        }
	        
	        //1.. u 부분 simulation 
	        // 올바른 괄호 문자열인지 확인하기
	        //System.out.println(postfixU);
	        String u = x.substring(0,postfixU+1);
	        String v = x.substring(postfixU+1,x.length());
	        
	        
	        if (checkRight(u)) {
	            return u + simulation(v);
	        } else {
	            return "(" + simulation(v) + ")" + change(u);
	        }
	        
	    }
	    
	    public static String change(String x){
	        
	        //앞뒤 문자 제거하고
	        String s = x.substring(1, x.length()-1);
	        
	        // 방향 바꾸기
	        String tmp = "";
	        for(int i=0;i<s.length();i++){
	            if(s.charAt(i)=='(') tmp+=')';
	            else tmp+='(';
	        }
	        
	        
	        return tmp;
	    }
	    
	    public static boolean checkRight(String x){
	        Stack<Character> stack = new Stack<>();
	        
	        for(int i=0;i<x.length();i++){
	            char cc = x.charAt(i);
	            if(cc=='('){
	                stack.push('(');
	            }else{
	                if(stack.isEmpty()) return false;
	                stack.pop();
	                
	            }
	            
	        }
	        
	        if(stack.isEmpty()) return true;
	        return false;
	    }
	    
	}

}
