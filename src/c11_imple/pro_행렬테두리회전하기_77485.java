package c11_imple;
import java.io.*;
import java.util.*;
public class pro_행렬테두리회전하기_77485 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static int[][] map;
    static int[][] moves= {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public int[] solution(int rows, int columns, int[][] queries) {
        map = new int[rows+1][columns+1];
        int x = 1;
        for(int i=1;i<=rows;i++){
            for(int j=1;j<=columns;j++){
                map[i][j] = x;
                x ++;
            }
        }
        
        
        int a = 0;
        int[] answer = new int[queries.length];
        for(int[] query: queries){
            int res = change(query);
            answer[a] = res;
            a++;
        }
        
        
        
        return answer;
    }
    
    public static int change(int[] query){
        
        List<Integer> nums = new ArrayList<>();
        List<int[]> posi = new ArrayList<>();
        
        int x = query[0];
        int y = query[1];
        
        int x2 = query[2];
        int y2 = query[3];
        
        int R = x2-x;
        int C = y2- y;
        
        nums.add(map[x][y]);
        posi.add(new int[]{x,y});
        int res = map[x][y];
        for(int i=1;i<=C;i++){
            x+=moves[0][0];
            y+=moves[0][1];
            nums.add(map[x][y]);
            posi.add(new int[]{x,y});
            res = Math.min(res, map[x][y]);
        }
        for(int i=1;i<=R;i++){
            x+=moves[1][0];
            y+=moves[1][1];
            nums.add(map[x][y]);
            posi.add(new int[]{x,y});
            res = Math.min(res, map[x][y]);
        }
        for(int i=1;i<=C;i++){
            x+=moves[2][0];
            y+=moves[2][1];
            nums.add(map[x][y]);
            posi.add(new int[]{x,y});
            res = Math.min(res, map[x][y]);
        }
        for(int i=1;i<R;i++){
            x+=moves[3][0];
            y+=moves[3][1];
            nums.add(map[x][y]);
            posi.add(new int[]{x,y});
            res = Math.min(res, map[x][y]);
        }
        
        int a = nums.size()-1;
        for(int[] po : posi){
            map[po[0]][po[1]] = nums.get(a);
            a = (a+1)%nums.size();
        }
        
        // for(int[] m: map){
        //     System.out.println(Arrays.toString(m));
        // }
        
        //System.out.println(res);
        return res;
        //System.out.println(nums);
    }

}
