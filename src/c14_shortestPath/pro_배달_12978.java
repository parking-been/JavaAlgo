package c14_shortestPath;
import java.io.*;
import java.util.*;
public class pro_배달_12978 {
	static List<List<Node>> graph = new ArrayList<>();
    static class Node implements Comparable<Node>{
        int to;
        int cost;
        
        public Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        //그래프 초기화 - 보고 배우자..
        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());
        }
        
        //그래프 간선 추가 
        for(int[] mo : road){
            graph.get(mo[0]).add(new Node(mo[1], mo[2]));
            graph.get(mo[1]).add(new Node(mo[0], mo[2]));
        }
        
        //시작 위치 : 1번 마을
        int[] result = dijkstra(N);
        
        //System.out.println("안녕하세요");
        for(int i=1;i<=N; i++){
            if (result[i]<=K){
                answer++;        
            }
        }
        
        return answer;
    }
    
    public static int[] dijkstra(int N){
        //일단 전체 길이 부터
        int[] distance = new int[N+1];
        for(int i=0;i<=N;i++){
            distance[i] = Integer.MAX_VALUE;
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1,0));
        distance[1] = 0;
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            //이미 처리된 최단 거리보다 현재 큐에서 꺼낸 거리가 더 크다면 패스 
            if(cur.cost > distance[cur.to]) continue;
            
            for(Node next: graph.get(cur.to)){
                if(distance[next.to] > distance[cur.to] + next.cost){
                    distance[next.to] = distance[cur.to] + next.cost;
                    pq.add(new Node(next.to, distance[next.to]));                
                }
            }
            
        }
        
        return distance;
    }

}
