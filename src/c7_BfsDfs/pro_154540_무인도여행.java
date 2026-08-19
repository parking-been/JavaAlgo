package c7_BfsDfs;
import java.io.*;
import java.util.*;
public class pro_154540_무인도여행 {
	static char[][] world;
    static boolean[][] visited;
    static List<Integer> history;
    static int[][] moves = {{-1,0},{1,0},{0,-1},{0,1}};
    static int N;
    static int M;
    
    public int[] solution(String[] maps) {
        history = new ArrayList<>();
        world = new char[maps.length][maps[0].length()];
        N = maps.length;
        M = maps[0].length();
        visited = new boolean[maps.length][maps[0].length()];
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length();j++){
                world[i][j] = maps[i].charAt(j);
            }
        }
        
        int flag = -1;
        //돌아다니면서 dfs 돌리고 저장하기
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length();j++){
                if(!visited[i][j] && world[i][j]!='X'){
                    flag = 1;
                    //System.out.println(bfs(i,j));   
                    history.add(bfs(i,j));
                }
                
            }
        }
        
        if (flag ==-1) {
            return new int[]{-1};
        }
        
        int[] answer = new int[history.size()];
        //history.add(bfs(i,j));
        int i = 0;
        for(int a : history){
            answer[i] = a;
            i++;
        }
        Arrays.sort(answer);
        return answer;
        
    }
    
    public static int bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[]{x, y, world[x][y]-'0'});
        visited[x][y] =true;
        int result = world[x][y]-'0';
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            
            for(int[] move: moves){
                int nx = move[0] + cur[0];
                int ny = move[1] + cur[1];
                if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
                if(!visited[nx][ny] && world[nx][ny]!='X'){
                    result = result + (world[nx][ny]-'0');
                    queue.add(new int[]{nx, ny, result});
                     
                    visited[nx][ny] = true;
                }
            }
        }
        
        return result;
            
            
    }

}
