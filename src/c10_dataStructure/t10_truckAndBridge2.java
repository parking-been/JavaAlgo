package c10_dataStructure;
import java.io.*;
import java.util.*;
public class t10_truckAndBridge2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static class Pack{
        int idx;
        int time; //들어간 시각
        public Pack(int idx, int time){
            this.idx = idx;
            this.time = time;
        }
        
        @Override
        public String toString(){
            return ("[" + idx + "]");
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<Pack> queue = new LinkedList<>();
        int curWeight = truck_weights[0];
        int curTime =2;
        queue.add(new Pack(0,1)); //1초에 들어감 
        int curIdx = 1;
        
        while(!queue.isEmpty()){
            
            //System.out.println("~~~~~" + curTime + "초 입니다. ~~~~~~~~");
            
            if(curTime - queue.peek().time ==bridge_length){
                Pack de = queue.poll();
                curWeight -= truck_weights[de.idx];
                
            }
            
            if(curIdx<truck_weights.length && curWeight + truck_weights[curIdx]<=weight){
                queue.add(new Pack(curIdx,curTime));
                curWeight +=truck_weights[curIdx];
                curIdx++;
                curTime++;
            }    
            else {
                if(!queue.isEmpty()){
                    curTime = queue.peek().time + bridge_length;
                }
            }
            //System.out.println(queue);
            
            
            
        }
        
        
        
        int answer = curTime;
        return answer;
    }

}
