package c11_imple;
import java.io.*;
import java.util.*;

public class pro_68645_»ï°¢´ŞÆØÀÌ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	static int[][] map;
    static boolean[][] visited;
    static int[][] moves = {{1,0}, {0,1},{-1,-1}};
    public int[] solution(int n) {
        
        if(n==1) return new int[] {1};
        
        map = new int[n][n];
        visited = new boolean[n][n];
        
        int x = 0;
        int y = 0;
        visited[x][y] = true;
        map[x][y] = 1;
        int idx = 0;
        int number = 2;
        int N = n*(n+1)/2;
        
        
        
        while(true){
            int nx = x + moves[idx][0];
            int ny = y + moves[idx][1];
            if(nx>=n || ny>=n || nx<ny || visited[nx][ny]) {
                idx = (idx+1)%3;
                continue;
            }
            
            map[nx][ny] = number;
            number++;
            visited[nx][ny] = true;
            x = nx;
            y = ny;
            if(number == N+1) break;
            
        }
        int[] answer = new int[N];
        int t=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i>=j){
                    answer[t] = map[i][j];
                    t++;
                }
            }
        }
        
        return answer;
    }

}
