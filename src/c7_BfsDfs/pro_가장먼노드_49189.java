package c7_BfsDfs;
import java.io.*;
import java.util.*;
public class pro_가장먼노드_49189 {
	public class Node{
        int idx;
        int weight;
        
        public Node(int idx, int weight){
            this.idx = idx;
            this.weight = weight;
        }
    }
    static int[] visited;
    static List<List<Integer>> graph;
    static int maxi;
    public int solution(int n, int[][] edge) {
        maxi = 0;
        //graph 만들기
        graph = new ArrayList<>();
        for(int i=0;i<n+1;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] ed : edge){
            graph.get(ed[0]).add(ed[1]);
            graph.get(ed[1]).add(ed[0]);
        }
        
        //bfs 수행하기
        visited = new int[n+1];
        
        for(int i=0;i<n+1;i++){
            visited[i] = -1;
        }
        
        Queue<Node> queue = new LinkedList<>();
        
        queue.add(new Node(1,0));
        visited[1] = 0;
        
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            
            for(int e : graph.get(cur.idx)){
                if(visited[e]>=0) continue;
                queue.add(new Node(e, cur.weight + 1));
                visited[e] = cur.weight + 1;
                
                maxi = Math.max(maxi, visited[e]);
            }
            
        }
        
        int total = 0;
        for(int vi: visited){
            if(vi == maxi){
                total++;
            }
        }
        //System.out.println(Arrays.toString(visited));
        
        
        //int answer = 0;
        return total;
    }
}
