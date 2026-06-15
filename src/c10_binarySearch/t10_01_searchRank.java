package c10_binarySearch;
import java.io.*;
import java.util.*;

public class t10_01_searchRank {
	static HashMap<String, List<Integer>> store;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] solution(String[] info, String[] query) {  
        int[] answer = new int[query.length];
        store = new HashMap<>();
        
        for(String tmp: info){
            String[] result = tmp.split(" ");
            makeSentence(result, "", 0);
        }
        
        // for(String key : store.keySet()){
        //     System.out.println(key + " " + store.get(key));
        // }
        //binary sort를 쓰려면 sorting 필요하다
        for(String key : store.keySet()){
            Collections.sort(store.get(key));
            //System.out.println(store.get(key));
        }
        
        
        
        int idx = 0;
        for(String tmp: query){
            String tr = tmp.replaceAll(" and ", "");
            String[] sp = tr.split(" ");
            if(store.containsKey(sp[0])){
                //만약 포함이 되어있다면
                answer[idx] = binarySearch(sp[0],Integer.parseInt(sp[1]));
                
            }
            else{
                //0
                answer[idx] = 0;
            }
            idx++;
            
        }
        //System.out.println(Arrays.toString(answer));
        
        return answer;
    }
    
    public static int binarySearch(String key, int score){
        //x 점 이상
        List<Integer> array = store.get(key);
        int start = 0;
        int end = array.size()-1;
        while(start<=end){
            int mid = (start + end)/2;
            if(array.get(mid)<score){
                start = mid+1;
            }else{
                end = mid -1;
            }
            
        }
        return array.size() - start;
        
    }
    
    
    public static void makeSentence(String[] p, String sentence, int depth){
        if(depth==4){
            
            if(store.containsKey(sentence)){
                //기존에 있다면? 
                store.get(sentence).add(Integer.parseInt(p[4]));
                return;
            }
            //없다면?
            List<Integer> list = new ArrayList<>();
            store.put(sentence, list);
            store.get(sentence).add(Integer.parseInt(p[4]));
            return;
            
            
        }
        
        makeSentence(p, sentence + "-", depth+1);
        makeSentence(p, sentence + p[depth], depth+1);
        
    }

}
