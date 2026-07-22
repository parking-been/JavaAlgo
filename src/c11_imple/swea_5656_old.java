package c11_imple;
import java.io.*;
import java.util.*;
public class swea_5656_old {
	static int T;
	static int N,W,H;
	static int[][] map;
	static int[][] map2;
	static int[][] visitedMap;
	static List<Integer> tmp;
	static int[][] move = {{-1,0},{1,0},{0,-1},{0,1}};
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			
			for(int i=0;i<H;i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				for(int j=0;j<W;j++) {
					map[i][j] = Integer.parseInt(st2.nextToken());
				}
			}
			
			//System.out.println(Arrays.deepToString(map));
			tmp = new ArrayList<>();
			
			
			
			caseCheck(0);
			
		}

	}
	
	public static void bomb(int y) {
		
		//처음 마주치는 블럭 찾기
		int x = 0;
		while(x<H && map2[x][y]==0) {
			x++;
			
		}
		
		if(x>=H) return;
		
		Queue<int[]> queue = new LinkedList<>();
		visited = new boolean[H][W];
		queue.add(new int[] {x, y, map2[x][y]});
		visited[x][y]= true;
		
		System.out.println("start:"+ " ("+x+","+y+")");
		//System.exit(0);
		
		while(!queue.isEmpty()) {
			
			int[] cur = queue.poll();
			int nn = cur[2];
			visited[cur[0]][cur[1]] = true;
			for(int m[] : move) {
				int tX = cur[0];
				int tY = cur[1];
				for(int i=1;i<nn;i++) {
					tX +=m[0];
					tY +=m[1];
					
					if(tX>=0 && tX<H && tY>=0 && tY<W && map2[tX][tY]>0 && !visited[tX][tY]) {
						queue.add(new int[] {tX,tY,map2[tX][tY]});
						visited[tX][tY] = true;
						
						System.out.println("bomb : "+ "(" +tX + "," + tY + ")");
					}
					
				}
			}
			
		}
		
		System.out.println("~~~~~~~~~~~~~~~~~~~");
	}
	
	public static void clean(int x, int y) {
		if(x<=0)return;
		int tX = x-1;
		int tY = y;
		while(tX>=0 && map2[tX][tY]==0) {
			
			tX--;
			
		}
		if(tX<0) return;
		map2[tX][tY] = map2[x][y];
		map2[x][y] = 0;
		
		
		
	}
	
	public static void cleans() {
		
		//visited 대상으로 정리하기
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				if(visited[i][j]==true) {
					map2[i][j]=0;
				}
			}
		}
		
		
		
		
		
		
		for(int j=0;j<W;j++) {
			for(int i=H-1;i>=0;i--) {
				 if(map2[i][j]!=0) {
					 //down 내리기
					 if(i-1>=0 && map2[i-1][j]==0) {
						 clean(i,j);
					 }
					 
				 }
				
				
			}
		}
	}
	
	public static void simulation() {
		
		map2 = new int[H][W];
		
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				map2[i][j] = map[i][j];
			}
		}
		
		for(int e: tmp) {
			// 폭탄 터뜨리기
			 bomb(e);
			// 블록 정리하기
			 cleans();
			 
			 for(int[] ma: map2) {
				 System.out.println(Arrays.toString(ma));
			 }
			 System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
//			 System.out.println("여기까지 왔습니다");
//			 System.exit(0);
		}
	}
	
	
	public static void caseCheck(int depth) {
		if(depth==N) {
			//System.out.println(tmp);
			//각 case에 대해 시뮬레이션 돌리기 
			//System.out.println("진행중");
			simulation();
			
			
			return;
		}
		
		
		
		
		
		//마지막에 한번에 계산하기 
		for(int i=0;i<W;i++) {
			tmp.add(i);
			caseCheck(depth+1);
			tmp.remove(tmp.size()-1);
		}
	}

}
