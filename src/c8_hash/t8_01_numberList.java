package c8_hash;
import java.io.*;
import java.util.*;

public class t8_01_numberList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashSet<String> set = new HashSet<>();
        
        for(String tmp : phone_book){
            set.add(tmp);
        }
        
        for(String tmp: phone_book){
            for(int i=1;i<tmp.length();i++){
                if(set.contains(tmp.substring(0,i))){
                    answer = false;
                    return answer;
                }
            }
        }
        
        return answer;
    }

}
