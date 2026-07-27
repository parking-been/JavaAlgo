package c13_mst;
import java.io.*;
import java.util.*;
public class pro_섬연결하기_42861 {
	static List<Edge> arr;
    static int[] parent;
    public class Edge implements Comparable<Edge>{
        int from;
        int to;
        int cost;
        
        public Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Edge edge){ //compareTo구나
            return this.cost - edge.cost;
        }
        
        @Override
        public String toString(){
            return this.from + ", " + this.to + ": " + this.cost;
        }
    }
    
    
    public int solution(int n, int[][] costs) {
        arr = new ArrayList<>();
        parent = new int[n];
        int cost = 0;
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        
        int answer = 0;
        for(int[] mem : costs){
           arr.add(new Edge(mem[0],mem[1],mem[2]));
        }
        Collections.sort(arr);
        //System.out.println(arr);
        
        for(int i=0;i<arr.size();i++){
            Edge cur = arr.get(i);    
            if(find(cur.from)!=find(cur.to)){
                union(cur.from, cur.to);
                cost+=cur.cost;
            }
            
            //find(cur.from)!=from(cur.to) -> 합치기
            
        }
        
        //System.out.println(cost);
        
        
        
        return cost;
    }
    
    //find
    public static int find(int x){
        if (x == parent[x]) return x;
        
        return parent[x] = find(parent[x]);
    }
    //union
    
    public static boolean union(int x, int y){
        int px = find(x);
        int py = find(y);
        if(px!=py){
            parent[px] = py;
            return true;
        }
        else{
            return false;
        }
    }

}
