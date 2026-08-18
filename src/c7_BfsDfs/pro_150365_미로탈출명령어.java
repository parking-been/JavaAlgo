package c7_BfsDfs;
import java.util.*;
public class pro_150365_미로탈출명령어 {
	// 1. 사전순 정렬: d(아래) -> l(왼쪽) -> r(오른쪽) -> u(위)
    static int[][] moves = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
    static String[] tt = {"d", "l", "r", "u"};
    
    static int N, M, R, C, K;
    static String answer = null;
    static StringBuilder sb = new StringBuilder();

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        N = n; M = m; R = r; C = c; K = k;
        answer = null;
        sb.setLength(0); // 격투 초기화

        // 최단 거리 계산
        int distance = Math.abs(x - r) + Math.abs(y - c);
        
        // 거리가 k보다 크거나, 남은 이동 횟수와 거리의 차이가 홀수라면 탈출 불가
        if (distance > k || (k - distance) % 2 != 0) {
            return "impossible";
        }

        // 이 문제의 특징: 같은 칸을 중복 방문해도 되므로 visited 배열이 필요 없습니다.
        dfs(x, y, 0);

        return answer == null ? "impossible" : answer;
    }

    public static void dfs(int x, int y, int depth) {
        // 이미 정답을 찾았다면 다른 탐색은 모두 스킵
        if (answer != null) return;

        // 가지치기: 현재 위치에서 목적지까지 남은 최단 거리
        int remainingDist = Math.abs(x - R) + Math.abs(y - C);
        int remainingMoves = K - depth;
        
        // 남은 이동 횟수로 목적지에 도달할 수 없다면 즉시 종료
        if (remainingDist > remainingMoves) return;

        // K번 이동했을 때 목적지에 도달했다면 정답 기록 후 종료
        if (depth == K) {
            if (x == R && y == C) {
                answer = sb.toString();
            }
            return;
        }

        // 사전순(d, l, r, u)으로 탐색 진행
        for (int i = 0; i < 4; i++) {
            int nx = x + moves[i][0];
            int ny = y + moves[i][1];

            if (nx > 0 && ny > 0 && nx <= N && ny <= M) {
                sb.append(tt[i]);
                dfs(nx, ny, depth + 1);
                sb.deleteCharAt(sb.length() - 1); // 백트래킹 (원상복구)
            }
        }
    }

}
