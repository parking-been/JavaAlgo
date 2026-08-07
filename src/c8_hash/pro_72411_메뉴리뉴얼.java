package c8_hash;
import java.io.*;
import java.util.*;
public class pro_72411_메뉴리뉴얼 {
	static HashMap<String,Integer> map;
    static List<Integer> tmp;
    static HashSet<Integer> cour;
    static List<String> result;
    public String[] solution(String[] orders, int[] course) {
        map = new HashMap<>();
        tmp = new ArrayList<>();
        cour = new HashSet<>();
        result = new ArrayList<>();
        int[] topcourse = new int[course.length];
        for(int c : course){
            cour.add(c);
        }
        
        for(String order : orders){
            
            dfs(sortString(order), 0); 
        }
        // System.out.println("~~~~~~~~~~~~~~");
        System.out.println(map);
        
        //각각 돌면서 top 찾기 
        for(String st : map.keySet()){
            for(int i=0;i<course.length;i++){
                if(st.length() == course[i]){
                    topcourse[i] = Math.max(map.get(st), topcourse[i]);
                    
                }
            }
        }
        
        //각각 돌면서 top에 맞는 부분집합 주기 
        for(String st : map.keySet()){
            for(int i=0;i<course.length;i++){
                if(topcourse[i]<=1) continue;
                if(map.get(st) == topcourse[i] && st.length() == course[i]){
                    
                    result.add(st);
                    
                    
                }
            }
        }
        
        
        
        
        String[] answer = new String[result.size()];
        
        int i=0;
        for(String an : result){
            answer[i] = an;
            i++;
        }
        
        Arrays.sort(answer);
        System.out.println(Arrays.toString(answer));
        
        return answer;
    }
    
    public static String sortString(String x){
        char[] so = x.toCharArray();
        Arrays.sort(so);
        String sortedStr = new String(so);
        return sortedStr;
    }
    
    public static void check(String x){
        if(! cour.contains(tmp.size())) return;
        String cur = "";
        for(int t : tmp){
            cur += String.valueOf(x.charAt(t));
        }
        //System.out.println(cur);
        map.put(cur, map.getOrDefault(cur, 0)+1);
        
    }
    
    public static void dfs(String x, int depth){
        if(depth == x.length()){
            //System.out.println(tmp);
            check(x);
            return;
        }
        tmp.add(depth);
        dfs(x, depth+1);
        tmp.remove(tmp.size()-1);
        dfs(x, depth+1);
    }

}
