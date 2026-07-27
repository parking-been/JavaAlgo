package c7_BfsDfs;
import java.io.*;
import java.util.*;
public class pro_수식최대화_67257 {
	static long TotalResult = 0;
    static Queue<String> queue = new LinkedList<>();
    static String[] opt = {"+", "-", "*"};
    static List<Integer> order;
    static boolean[] visited;
    public long solution(String expression) {
        long answer = 0;
        String tmp = "";
        for(int i=0;i<expression.length();i++){
            char cur = expression.charAt(i);
            if(cur>='0' && cur <='9' ){
                tmp+=cur;
            }
            else{
                queue.add(tmp);
                queue.add(String.valueOf(cur)); //
                tmp = "";
            }
        }
        queue.add(tmp);
        
        //System.out.println(queue);
        
        
        order = new ArrayList<>();
        visited = new boolean[3];
        dfs(0);
        System.out.println(TotalResult);    
        return TotalResult;
    }
    
    
    public static long calculate(long a, long b, String op){
        if(op.equals("+")){
            return a + b;
        }
        else if(op.equals("-")){
            return a-b;
        }
        else if (op.equals("*")){
            return a*b;
        }
        return -1;
    }
    
    
    public static void check(){
        Queue<String> tmpQueue = new LinkedList<>();
        tmpQueue.addAll(queue);
        
        Stack<String> tmpStack = new Stack<>();
        for(int i: order){
            String cur = opt[i];
            while(!tmpQueue.isEmpty()){
                String tt = tmpQueue.poll();
                
                if(tt.equals(cur)){
                    
                    long a = Long.parseLong(tmpStack.pop());
                    long b = Long.parseLong(tmpQueue.poll());
                    tmpStack.add(String.valueOf(calculate(a, b, tt)));
                }
                else{
                    tmpStack.add(tt);    
                }
            }
            
            //System.out.println("안녕하세요 " +tmpStack);
            tmpQueue.addAll(tmpStack);
            tmpStack = new Stack<>();
            //System.out.println("녕안 " + tmpQueue);
            
        }
        
        TotalResult = Math.max(TotalResult, Math.abs(Long.parseLong(tmpQueue.poll())));
        
    }
    
    public static void dfs(int depth){
        if(depth==3){
            //여기서 계산
            //System.out.println(order);
            check();
            
            return;
        }
        for(int i=0;i<3;i++){
            if(visited[i]==false){
                order.add(i);
                visited[i] = true;
                dfs(depth+1);
                order.remove(order.size()-1);
                visited[i] = false;
            }
        }
        
    }

}
