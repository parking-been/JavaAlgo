package c7_BfsDfs;
import java.io.*;
import java.util.*;

public class pro_거리두기확인하기_81302 {
	 static char[][] map;
	    static List<int[]> persons;
	    static int[][] moves = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	    static boolean Tresult;
	    public int[] solution(String[][] places) {
	        //int[] answer = {};
	        List<Integer> resultss = new ArrayList<>();
	        for(String[] place : places){
	            map = new char[5][5];
	            persons = new ArrayList<>();
	            Tresult = true;
	            for(int i=0;i<5;i++){
	                String tmp = place[i];
	                for(int j=0;j<5;j++){
	                    map[i][j] = tmp.charAt(j);
	                    if(map[i][j]=='P'){
	                        persons.add(new int[]{i,j});
	                    }
	                }
	            }
	            
	            
	            //각각 person에서 depth 2 까지만 해서 bfs 돌리기
	            for(int[] person : persons){
	                if(!bfs(person[0], person[1])){
	                    Tresult = false;
	                }
	                
	                
	            }
	            
	            //System.out.println(Tresult);
	            if(Tresult){
	                resultss.add(1);
	            }
	            else{
	                resultss.add(0);
	            }
	        }
	        
	        System.out.println(resultss);
	        int[] answer = new int[resultss.size()];
	        int y=0;
	        for(int r : resultss){
	            answer[y] = r;
	            y++;
	        }
	        //System.out.println(Arrays.deepToString(map));
	        
	        return answer;
	    }
	    
	    public static boolean bfs(int x, int y){
	        Queue<int[]> queue = new LinkedList<>();
	        boolean[][] visited = new boolean[5][5];
	        visited[x][y] = true;
	        queue.add(new int[] {x, y, 0});
	        while(!queue.isEmpty()){
	            int[] cur = queue.poll();
	            if(cur[2]==2) continue;
	            
	            for(int[] move : moves){
	                int nx = move[0] + cur[0];
	                int ny = move[1] + cur[1];
	                if(0<=nx && nx<5 && ny>=0 && ny<5 && !visited[nx][ny] ){
	                    if(map[nx][ny]=='O'){
	                        //통과
	                        queue.add(new int[] {nx, ny, cur[2]+1});
	                        visited[nx][ny] = true;
	                    }
	                    else if(map[nx][ny]=='P'){
	                        return false;
	                    }
	                }
	            }
	        }
	        
	        return true;
	    }

}
