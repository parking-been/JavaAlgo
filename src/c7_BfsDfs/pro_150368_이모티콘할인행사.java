package c7_BfsDfs;
import java.io.*;
import java.util.*;
public class pro_150368_이모티콘할인행사 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static int[] policy = {10, 20, 30, 40 };
    static int depth = 4;
    static List<Integer> tmp;
    static int Rpaid = 0;
    static int RVIP = 0;
    public int[] solution(int[][] users, int[] emoticons) {   
        
        tmp = new ArrayList<>();
        // 이모티콘 할인율 dfs 
        // 계산 마지막에 
        //완탐으로
        dfs(0,users, emoticons);
        //System.out.println(RVIP+","+Rpaid);
        
        int[] answer = {RVIP, Rpaid};
        return answer;
    }
    public static int check(int percent, int maximum, int[] emoticons){
        int paid = 0;
        int vip = 0;
        for(int i=0;i<emoticons.length;i++){
            if(policy[tmp.get(i)]>=percent){
                paid+=((100-policy[tmp.get(i)])*emoticons[i])/100;
                //System.out.println(paid);      
            }
            if(paid>=maximum) {
                //vip 등록
                return -1;
            }
        }
        //구매
        
        return paid;
    }
    
    public static void calculate(int[][] users, int[] emoticons){
        //tmp 를 사용하여 각각 구하기
        
        int paid = 0;
        int VIP = 0;
        for(int[] user: users){
            
            float result = check(user[0], user[1], emoticons);
            
            if (result <0) {
                VIP++;}
            else{
                paid+=result;
            }
            
        }
        
        //System.out.println(paid);
        
        if(VIP> RVIP){
            Rpaid = paid;
            RVIP = VIP;
        }else if (RVIP == VIP){
            if(Rpaid<paid) Rpaid = paid;
        }
        
        
    }
    
    public static void dfs(int d, int[][] users,int[] emoticons){
        if(d==emoticons.length){
            //System.out.println(tmp);
            calculate(users, emoticons);
            //여기서 돌리기
            return;
        }
        
        for(int i=0;i<depth;i++){
            tmp.add(i);
            dfs(d+1, users, emoticons); //d++ 했다가 에러남
            tmp.remove(tmp.size()-1);
        }
        
    }

}
