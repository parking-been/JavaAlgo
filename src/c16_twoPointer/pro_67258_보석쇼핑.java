package c16_twoPointer;
import java.io.*;
import java.util.*;

public class pro_67258_보석쇼핑 {
	static HashMap<String, Integer> map;
    static HashSet<String> set;
    static int minl;
    static int minr;

    public int[] solution(String[] gems) {
        map = new HashMap<>();
        set = new HashSet<>(List.of(gems));
        for(String dia : set){
            map.put(dia, 0);
        }
        
        shopping(gems);
        int[] answer = new int[] {minl+1, minr+1};
        return answer;
    }

    public static void shopping(String[] gems){
        int left = 0;
        int right = 0;
        int minLen = gems.length;
        minl = 0;
        minr = 0;
        
        HashSet<String> tmp = new HashSet<>();
        while(tmp.size() != set.size()){
            tmp.add(gems[right]);
            map.put(gems[right], map.get(gems[right])+1);
            right ++;
        }
        right --;
        
        minl = left;
        minr = right;
        minLen = right - left + 1;

        // 수정 1: right가 끝에 도달했더라도 left는 더 움직일 수 있어야 하므로 right < gems.length로 변경
        while(left <= right && right < gems.length){ 
            
            // 현재 상태에서 먼저 정답을 업데이트 해줍니다.
            if(right - left + 1 < minLen) {
                minl = left;
                minr = right;
                minLen = right - left + 1;
            }

            int leftM = map.get(gems[left]);
            
            // 만약 left 보석이 구간 내에 2개 이상 있다면 안전하게 줄이기
            if(leftM >= 2){
                map.put(gems[left], leftM - 1);
                left ++;
            } 
            // 더 이상 left를 줄일 수 없다면 right를 늘려야 함
            else {
                // 수정 2: right를 늘리기 전에 배열 범위를 체크하고, 안전할 때만 전진
                if (right + 1 < gems.length) {
                    right++;
                    int rightM = map.get(gems[right]); // 필요할 때만 정확한 인덱스로 가져옴
                    map.put(gems[right], rightM + 1);
                } else {
                    // right가 이미 끝인데 left도 못 줄인다면 더 이상 최단 구간을 만들 수 없으므로 종료
                    break;
                }
            }
        }
    }

}
