package c11_imple;
import java.util.*;
import java.io.*;

public class codetree_아기고래첫항해 {

	static int N, r, c, d;
    static int[][] ocean;
    static boolean[][] visited;

    static int[] dr = {0, -1, 1, 0, 0};
    static int[] dc = {0, 0, 0, -1, 1};
    // 해당 방향이 정해진 걸 토대로 idx 를 가지고 dr, dc 적용
    static int[][] priority = {
         {0, 0, 0, 0}, // 전진, 좌회전, 우회전, 180도회전
        {1, 3, 4, 2}, //1(상)
        {2, 4, 3, 1}, //2(하)
        {3, 2, 1, 4}, //3(좌)
        {4, 1, 2, 3} //4(우)}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        ocean = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                ocean[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<String> result = new ArrayList<>();
        // 처음 시작 위치 처리
        visited[r][c] = true;
        result.add(r + " " + c);

        while(true) {
            boolean moved = false; // 움직임 유무
            // 인접 가능한 칸 이동
            for(int i = 0; i < 4; i++) {
                int next = priority[d][i]; // 방향
                int nr = r + dr[next];
                int nc = c + dc[next];

                // 인접 조건
                if(nr >= 1 && nc >= 1 && nr <= N && nc <= N
                        && ocean[nr][nc] != 1 && !visited[nr][nc]) {
                        
                    // 방문여부, 움직임유무, 현재위치, 현재 방향, 결과저장
                    visited[nr][nc] = true;
                    moved = true;
                    r = nr; c = nc; d = next;
                    result.add(nr + " " + nc);
                    break;
                }
            }

            // 이동 못할 때 방문 안한 바다 bfs찾기
            if(!moved) {
                Queue<int[]> q = new LinkedList<>();
                boolean[][] visitedBfs = new boolean[N+1][N+1];
                q.offer(new int[]{r, c, 0}); // 시작위치, 거리
                visitedBfs[r][c] = true;

                int dist = -1;
                // 방문 가능 여부 list
                List<int[]> list = new ArrayList<>();

                while(!q.isEmpty()) {
                    int[] current = q.poll();
                    int curR = current[0], curC = current[1], curD = current[2];

                    if(curD > dist && dist != -1) break;
                    // 미방문바다 칸 (visited = false)
                    if(!visited[curR][curC]) {
                        dist = curD;
                        list.add(new int[]{curR, curC});
                    }
                    
                    // 방향 탐색
                    for(int i = 1; i <= 4; i++) {
                        int nr = curR + dr[i];
                        int nc = curC + dc[i];
                        if(nr >= 1 && nc >= 1 && nr <= N && nc <= N
                                && ocean[nr][nc] != 1 && !visitedBfs[nr][nc]) {
                            q.offer(new int[]{nr, nc, curD + 1});
                            visitedBfs[nr][nc] = true;
                        }
                    }
                }

                if(list.isEmpty()) break;

                int[] target = list.get(0);
                for(int[] com : list) {
                    if(com[0] < target[0] || (com[0] == target[0] && com[1] < target[1])) {
                        target = com;
                    }
                }
                // target 까지 경로이동
                int tarR = target[0], tarC = target[1];

                Queue<int[]> tarQ = new LinkedList<>();
                tarQ.offer(new int[]{tarR, tarC});
                int[][] distMap = new int[N+1][N+1];
                for(int[] row : distMap) Arrays.fill(row, -1);
                distMap[tarR][tarC] = 0;

                while(!tarQ.isEmpty()) {
                    int[] curTar = tarQ.poll();
                    int curTarR = curTar[0], curTarC = curTar[1];

                    for(int i = 1; i <= 4; i++) {
                        int nextTr = curTarR + dr[i];
                        int nextTc = curTarC + dc[i];
                        if(nextTr >= 1 && nextTc >= 1 && nextTr <= N && nextTc <= N
                                && distMap[nextTr][nextTc] == -1 && ocean[nextTr][nextTc] != 1) {
                            distMap[nextTr][nextTc] = distMap[curTarR][curTarC] + 1;
                            tarQ.offer(new int[]{nextTr, nextTc});
                        }
                    }
                }

                int[] moveOrder = {3, 2, 4, 1};
                while(r != tarR || c != tarC) {
                    for(int i = 0; i < 4; i++) {
                        int moveDir = moveOrder[i];
                        int nr = r + dr[moveDir];
                        int nc = c + dc[moveDir];
                        if(nr >= 1 && nc >= 1 && nr <= N && nc <= N
                                && distMap[nr][nc] == distMap[r][c] - 1) {
                            if(!visited[nr][nc]) result.add(nr + " " + nc);
                            r = nr; c = nc; d = moveDir;
                            visited[nr][nc] = true;
                            break;
                        }
                    }
                }
            }
        }

        for(String s : result) {
            System.out.println(s);
        }
    }

}
