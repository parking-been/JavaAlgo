package c7_BfsDfs;
import java.io.*;
import java.util.*;

public class pro_불량사용자_64064 {
	static String[] userIds;
    static String[] bannedIds;
    static boolean[] visited;
    static HashSet<HashSet<String>> result;
    public int solution(String[] user_id, String[] banned_id) {
        userIds = user_id;
        bannedIds = banned_id;
        
        result = new HashSet<>();
        dfs(0, new HashSet<>());
        //System.out.println(result.size());
        //int answer = 0;
        return result.size();
    }
    public static boolean check(String a, String b){
        if(a.length() != b.length()) return false;
        
        for(int i=0;i<a.length();i++){
            
            if(a.charAt(i)!='*' && b.charAt(i)!='*' && a.charAt(i)!= b.charAt(i)){
                return false;        
            }
        }
        
        return true;
    }
    public static void dfs(int depth, HashSet<String> tmp){
        if(depth == bannedIds.length){
            result.add(new HashSet<>(tmp)); // 이부분이 틀렸었다.
            
            return;
        }
        
        for(int i=0;i<userIds.length;i++){
            //이미 포함되어있음
            if(tmp.contains(userIds[i])) continue;
            //맞는지 확인
            if(check(userIds[i],bannedIds[depth])){
                tmp.add(userIds[i]);
                dfs(depth+1, tmp);
                tmp.remove(userIds[i]); //지우고자 하는 문자열을 넣어야함
            }
        }
        
    }

}
