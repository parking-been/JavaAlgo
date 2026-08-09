package c11_imple;
import java.io.*;
import java.util.*;
//다음에는 stringbuilder 사용해보도록하자
public class pro_124나라의숫자_12899 {
	static List<Integer> arr;
    static String result;
    public String solution(int n) {
        arr = new ArrayList<>();
        result = "";
        dfs(n);
        //dfs(18);
        //System.out.println(arr);
        //System.out.println(result);
        result = result.replaceAll("3", "4");
        System.out.println(result);
        //String answer = "";
        return result;
    }
    
    public static void dfs(int x){
        if(x<=3){
            arr.add(x);
            result =  String.valueOf(x) + result;
            return;
        }
        
        if(x%3==0){
            arr.add(3);
            result = String.valueOf(3) + result;
            dfs(x/3 -1);
        }else{
            arr.add(x%3);
            result = String.valueOf(x%3) + result;
            dfs(x/3);
        }
    }
}
