package c15_heap;
import java.io.*;
import java.util.*;
public class pro_디스크컨트롤러_42627 {
	 public class Node implements Comparable<Node>{
	        int index;
	        int req;
	        int dur;
	        
	        public Node(int index, int req, int dur){
	            this.index = index;
	            this.req = req;
	            this.dur = dur;
	        }
	        
	        @Override
	        public int compareTo(Node o){
	            if(this.dur == o.dur){
	                if(this.req == o.req){
	                    return this.index - o.index;
	                }
	                return this.req - o.req;
	            }
	            
	            return this.dur - o.dur;
	        }
	        
	        @Override
	        public String toString(){
	            return this.index + ": " + this.req +"," + this.dur;
	        }
	        
	        
	        
	    }
	    
	    public int solution(int[][] jobs) {
	        
	        Arrays.sort(jobs, (o1,o2) -> o1[0] - o2[0]);
	        
	        
	        PriorityQueue<Node> pq = new PriorityQueue<>();
	        
	        int throughPuts = 0;
	        int curTime = 0;
	        int jobsIdx = 0;
	        int count = 0;
	        
	        while(count< jobs.length){
	            //현재 시간(curTime) 이전에 들어온 모든 작업
	            while(jobsIdx < jobs.length && jobs[jobsIdx][0]<=curTime){
	                pq.add(new Node(jobsIdx, jobs[jobsIdx][0],jobs[jobsIdx][1]));
	                jobsIdx++;
	            }
	            
	            if(pq.isEmpty()){
	                curTime = jobs[jobsIdx][0];
	            }else{
	                Node cur = pq.poll();
	                curTime +=cur.dur;
	                throughPuts+=curTime - cur.req;
	                count++;
	            }
	        }
	        
	        
	        int answer = throughPuts/jobs.length ;
	        return answer;
	    }

}
