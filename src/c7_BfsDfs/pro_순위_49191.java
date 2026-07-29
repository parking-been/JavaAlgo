package c7_BfsDfs;
import java.io.*;
import java.util.*;

public class pro_순위_49191 {
	static List<List<Integer>> graph;
    static List<List<Integer>> reGraph;
    static boolean[] visited;
    public int solution(int n, int[][] results) {   
        graph = new ArrayList<>();
        reGraph = new ArrayList<>();
        int count = 0;
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
            reGraph.add(new ArrayList<>());
        }
        
        for(int[] result : results){
            graph.get(result[0]).add(result[1]);
            reGraph.get(result[1]).add(result[0]);
        }
        
        for(int i=1;i<=n;i++){
            //bfs 돌리기
            visited = new boolean[n+1];
            bfs(i, graph);
            bfs(i, reGraph);
            //System.out.println("여기까지 잘되나?");
            
            if(check(n))count++; 
            
        }
        System.out.println(count);
        
        //int answer = 0;
        return count;
    }
    
    public static boolean check(int n){
        for(int i=1;i<=n;i++){
            if(visited[i] == false) return false;
        }
        return true;
    }
    
    public static void bfs(int x, List<List<Integer>> gph){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x] = true;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            
            for(int next: gph.get(cur)){
                if (visited[next] == false){
                    queue.add(next);
                    visited[next] = true;    
                }
                
            }
        }
        
        //System.out.println(Arrays.toString(visited));
        
    }

}
