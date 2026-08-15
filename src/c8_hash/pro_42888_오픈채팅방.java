package c8_hash;
import java.io.*;
import java.util.*;

public class pro_42888_¿ÀÇÂÃ¤ÆÃ¹æ {
	static HashMap<String,String> map;
    static HashMap<String, String> mm;
    static List<String> result;
    public String[] solution(String[] record) {
        map = new HashMap<>();
        mm = new HashMap<>();
        mm.put("+","´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.");
        mm.put("-","´ÔÀÌ ³ª°¬½À´Ï´Ù.");
            
        result = new ArrayList<>();
        
        for(String re : record){
            String[] tmp = re.split(" ");
            recording(tmp);
            
        }
        String[] answer = new String[result.size()];
        int i=0;
        for(String re : result){
            int n = re.length();
            //System.out.println(n);
            answer[i] = re.replace(re.substring(0,n-1), map.get(re.substring(0,n-1)));
            int t = answer[i].length()-1;
            answer[i] = answer[i].substring(0,t)+ mm.get(String.valueOf(answer[i].charAt(t)));
            
            //System.out.println(answer[i]);
            i++;
            
            //re.replace(re.subString(re.length()-2, re.length()-1), )
        }
        //System.out.println(map);
        //System.out.println(result);
        
        
        return answer;
    }
    
    public static void recording(String[] tmp){
        
        if(tmp[0].equals("Enter")){
            result.add(tmp[1]+"+");
            map.put(tmp[1],  tmp[2]);
        }else if(tmp[0].equals("Leave")){
            result.add(tmp[1]+"-");
            //map.put(tmp[1],  tmp[2]);
            
        } else if (tmp[0].equals("Change")){
            map.put(tmp[1], tmp[2]);
        }
    }
}
