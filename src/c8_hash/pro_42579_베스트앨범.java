package c8_hash;
import java.io.*;
import java.util.*;

public class pro_42579_베스트앨범 {
	public class Node implements Comparable<Node>{
        int idx;
        int play;
        
        public Node(int idx, int play){
            this.idx = idx;
            this.play =play;
        }
        
        @Override
        public int compareTo(Node o){
            if (o.play == this.play) return this.idx - o.idx;
            else return o.play - this.play;
        }
        
        @Override
        public String toString(){
            return "idx : " + this.idx + ", play : " + this.play; 
        }
        
    }
    
    
    
    
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genMap = new HashMap<>();
        HashMap<String, List<Node>> typeMap = new HashMap<>();
        
        
        for(int i=0;i<genres.length;i++){
            //genMap 채우기
            genMap.put(genres[i], genMap.getOrDefault(genres[i],0 )+ plays[i]);
            
            //typeMap 채우기 
            if(typeMap.containsKey(genres[i])){
                typeMap.get(genres[i]).add(new Node(i,plays[i]));
            } else{
                typeMap.put(genres[i], new ArrayList<>());
                typeMap.get(genres[i]).add(new Node(i,plays[i]));
            }
            
        }
        
        //sorting 하기
        for(String t : typeMap.keySet()){
            //System.out.println(t);
            Collections.sort(typeMap.get(t));
            //System.out.println(typeMap.get(t));
        }
        
        //장르도 sorting 하기 
        List<String> genList = new ArrayList<>(genMap.keySet());
        
        
        
        Collections.sort(genList, (o1, o2) -> (genMap.get(o2) - genMap.get(o1) ));
        
        //System.out.println(genMap);
        //System.out.println(genList);
        List<Integer> result = new ArrayList<>();
        for(String g : genList){
            List<Node> nodes = typeMap.get(g);
            int cnt = Math.min(nodes.size(), 2);
            for(int i=0;i<cnt;i++){
                result.add(typeMap.get(g).get(i).idx);
            }
        }
        System.out.println(result);
        
        
        int[] answer = new int[result.size()];
        for(int i=0;i<result.size();i++){
            answer[i] = result.get(i);    
        }
        
        return answer;
        
    }
}
