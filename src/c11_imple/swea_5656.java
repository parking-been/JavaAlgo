package c11_imple;
import java.io.*;
import java.util.*;
public class swea_5656 {
	static int T;
	static int N, W, H;
	static int[][] map;
	static int[][] map2;
	static List<Integer> tmp;
	static int[][] move = {{-1,0}, {0,-1}, {1,0}, {0,1}};
	static int mini;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			mini = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			map = new int[H][W];
			tmp = new ArrayList<>();
			for(int i=0;i<H;i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				for(int j=0;j<W;j++) {
					map[i][j] = Integer.parseInt(st2.nextToken());
				}
			}
			
			checkCase(0);
			
			System.out.println("#" + t + " " + mini);
			
		}	
		
		

	}
	
	static void bomb(int y) {
		int x = 0;
		//젤 위에 있는거 찾기 
		if(map2[x][y]==0) {
			while(x<H && map2[x][y]==0) {
				x++;
			}
			
			//System.out.println("(" +x+","+y+ ")");
		}
		//System.out.println("안녕안녕안녕 (" +x+","+y+ ")");
		if(x>=0 && x<H &&y>=0 &&y<W) {
			//폭탄 터뜨리기
			bfs(x,y);
		}
		
	}
	
	static void bfs(int x, int y) {
		boolean visited[][] = new boolean[H][W];
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y, map2[x][y]} );
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int nn = cur[2];
			for(int[] m : move) {
				int tX = cur[0];
				int tY = cur[1];
				for(int i=0;i<nn-1;i++) {
					tX += m[0];
					tY += m[1];
					
					if(tX >=0 && tX <H && tY >=0 && tY<W && !visited[tX][tY] && map2[tX][tY]!=0) {
						queue.add(new int[] {tX, tY, map2[tX][tY]});
						visited[tX][tY] = true;
					}
				}
			}
			
		}
//		for(boolean[] m : visited) {
//			System.out.println(Arrays.toString(m));
//		}
//		
//		System.exit(0);
		
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				if(visited[i][j]==true)
					map2[i][j] = 0;
			}
		}
		
//		for(int[] m :map2) {
//			System.out.println(Arrays.toString(m));
//		}
//		System.exit(0);
		
		
		
		
	}
	
	static void cleaning() {
        for(int i=0; i<W; i++) {
            Stack<Integer> stack = new Stack<>();
            // 위에서 아래로 내려가며 0이 아닌 숫자를 스택에 수집
            for(int j=0; j<H; j++) {
                if(map2[j][i] != 0) {
                    stack.push(map2[j][i]);
                    map2[j][i] = 0; // 우선 빈칸으로 리셋
                }
            }
            
            // 아래 칸(H-1)부터 스택에서 꺼내어 차례대로 채움
            int idx = H - 1;
            while(!stack.isEmpty()) {
                map2[idx--][i] = stack.pop();
            }
        }
    }
	
	static void drop(int x, int y) {
		
		int tX = x;
		
		//System.out.println("=>"+ x + ", " + y);
		x++;
		while(x<H && map2[x][y]==0 ) {
			x++;
		}
		x--;
		map2[x][y] = map2[tX][y];
		map2[tX][y] = 0;
		//System.out.println("!" + x + ", " + y);
		//System.out.println("~~~~~~~~~~~~~~~~~");
		
	}
	
	static void simulation() {
		
		//맵 복사부터 하기
		map2 = new int[H][W];
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				map2[i][j] = map[i][j];
			}
		}
		
		for(int e : tmp) {
			// 폭탄 터뜨리기
			bomb(e);
			//bomb(2);
			//bomb(2);
			
			// 블록 한번 더 내리기

			
			
			cleaning();
			
//			for(int[] m : map2) {
//				System.out.println(Arrays.toString(m));
//			}
//			System.out.println("~~~~~~~~~~~~~~~~~~~~~~");
			//			
		}
		
		int count = 0;
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				if(map2[i][j]!=0) {
					count++;
				}
			}
		}
		
		mini = Math.min(mini, count);
		
		
	}
	
	
	static void checkCase(int depth) {
		if(depth ==N) {
			//여기서시뮬레이션 진행하기
			
			simulation();
						
			return ;
		}
		for(int i=0;i<W;i++) {
			tmp.add(i);
			checkCase(depth+1);
			tmp.remove(tmp.size()-1);
		}
	}
	
	
	

}
