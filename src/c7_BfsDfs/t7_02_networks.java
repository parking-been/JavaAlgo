package c7_BfsDfs;
import java.io.*;
import java.util.*;
public class t7_02_networks {
	public static void main(String[] args) {
		
	}
	
	static boolean[] visited;
    static int N;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        N = computers.length;
        visited = new boolean[N];
        
        for(int i=0;i<N;i++){
            if(!visited[i]){
                //bfs
                bfs(i, computers);
                answer++;
            }
        }
        
        System.out.println(answer);
        
        return answer;
        
        
    }
    
    public static void bfs(int x,int[][] computers){
        Queue<Integer> queue = new LinkedList<>();
        visited[x] = true;
        queue.add(x);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int i=0;i<N;i++){
                if(computers[cur][i]==1 && visited[i]==false){
                    //추가한다.
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        
    }
}
