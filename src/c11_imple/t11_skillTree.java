package c11_imple;

public class t11_skillTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
public int solution(String skill, String[] skill_trees) {
        
        int count = 0;
        
        for(String tree : skill_trees){
            String[] tmp = tree.split("");
            
            
            int idx = 0;
            boolean flag = true;
            for(int i=0;i<tmp.length;i++){
                if(skill.indexOf(tmp[i])==idx){
                    idx++;
                }
                else if(idx < skill.indexOf(tmp[i])){
                    flag = false;
                }
            }
            if(flag == true) count++;
        }
        
        
        int answer = count;
        return answer;
    }

}
