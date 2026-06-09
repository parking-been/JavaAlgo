package c7_BfsDfs;
import java.io.*;
import java.util.*;

//앞으로 프로그래머스 문제는 ide 가 아닌 프로그래머스 화면에서 풀 것이다... ㅠㅠ 

public class t7_01_travelRoute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 static ArrayList<String> route;
	    static boolean[] visited;
	    public String[] solution(String[][] tickets) {
	        int N = tickets.length;
	        visited = new boolean[N];
	        route = new ArrayList<>();
	        
	        dfs(0,"ICN" , "ICN", tickets);
	        
	        Collections.sort(route);
	        
	        String[] answer = (route.get(0).split(" "));
	        
	        //String[] answer = {};
	        return answer;
	    }
	    
	    public static void dfs(int depth, String now, String line, String[][] tickets){
	        if(depth == tickets.length){
	            route.add(line);
	            return;
	        }
	        
	        for(int i=0;i<tickets.length;i++){
	            if(!visited[i] && now.equals(tickets[i][0])){
	                visited[i] = true;
	                String lineTmp = line + " " + tickets[i][1];
	                dfs(depth+1, tickets[i][1], lineTmp, tickets);
	                visited[i] = false;
	            }
	        }
	        
	    }

}
