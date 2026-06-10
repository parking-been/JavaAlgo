package c7_BfsDfs;
import java.io.*;
import java.util.*;

public class t7_03_shortestPath {
	static boolean[][] visited;
    static int[][] move = {{0,-1},{0,1},{-1,0},{1,0}};
    static int N;
    static int M;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int solution(int[][] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length;
        visited = new boolean[N][M];        
        answer = bfs(0,0,maps);
        System.out.println(answer);
        return answer;
    }
    
    public static int bfs(int x, int y,int[][] maps){
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new int[]{x,y,1});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(cur[0]==N-1 && cur[1]==M-1){
                return cur[2];
            }
            
            for(int[] m : move){
                int nx = cur[0] + m[0];
                int ny = cur[1] + m[1];
                if(nx<0 || nx>=N || ny<0 || ny>=M||visited[nx][ny]==true || maps[nx][ny]==0) continue;
                
                queue.add(new int[]{nx, ny, cur[2]+1});
                visited[nx][ny] = true;
                
            }
        }
        
        return -1;
    }
	
}
