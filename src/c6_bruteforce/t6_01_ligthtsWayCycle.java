package c6_bruteforce;
import java.io.*;
import java.util.*;
//빝의 경로 사이클
public class t6_01_ligthtsWayCycle {
	static int N,M;
	static Lense[][] array;
	static ArrayList<Integer> save;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] grid = new String[N];
		for(int i=0;i<N;i++) {
			grid[i] = br.readLine();
		}
		//System.out.println(Arrays.toString(grid));
		Solution(grid);

	}
	
	public static class Lense{
		//0 위, 1 오, 2 아래, 3왼
		boolean[] visited = new boolean[4];
		String type;
		
		Lense(String type) {
			this.type = type;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			
			
			return "{" + type + "}";
		}
	}
	
	public static int reflect(int x, int y, int dir) {
		
		if(array[x][y].type.equals("S")) {
			
		}
		else if(array[x][y].type.equals("R")) {
			dir++; if(dir>3) {dir=0;}
		}
		else if(array[x][y].type.equals("L")) {
			dir--; if(dir<0){dir=3;}
		}
		return dir;
	}
	
	public static void visite(int x, int y, int dir) {
		int cnt=0;
		while(true) {
			//방문했으면 탈출, 아니면 진행
			if(array[x][y].visited[dir]==true) {
				if(cnt==0) {
					
				}else {
					save.add(cnt);
					cnt=0;
				}
				return;
			}
			
			array[x][y].visited[dir]=true;
			//dir 따라 방향이동 - 막다른 길일 경우 반대편으로!...
			if(dir==0) {
				x--; if(x<0) {x=N-1;}
			}
			else if(dir==1) {
				y++; if(y==M) {y=0;}
			}else if(dir==2) {
				x++; if(x==N) {x=0;}
				
			}else if(dir==3) {
				y--; if(y<0) {y=M-1;}
			}
			
			
			// 현재 존재하는 방향으로 dir 바꾸기 (방향 회전)
			dir = reflect(x,y,dir);
			
			cnt++;
			
		}
	}
	
	public static int[] Solution(String grid[]) {
		
		N = grid.length;
		M = grid[0].length();
		save = new ArrayList<>();
		array = new Lense[N][M];
		
		//lense 형식의 배열형태로 저장하기
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				array[i][j] = new Lense(grid[i].charAt(j)+"");
			}
		}
		
		//System.out.println(Arrays.deepToString(array));
		int cnt=0;
		//순회하면서 방문하지 않은 곳일 경우 사이클 돌기
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				for(int d=0;d<4;d++) {
					//이미 방문했다는 뜻
					if(array[i][j].visited[d]==true) {
						continue;
					}
					//방문 안한 경우
					else {
						visite(i,j,d);
					}
				}
			}
		}
		
		//System.out.println(save);
		Collections.sort(save);
		
		int[] answer = new int[save.size()];
		for(int i=0;i<save.size();i++) {
			answer[i] = save.get(i);
		}
		
		return answer;
		
		
	}

}
