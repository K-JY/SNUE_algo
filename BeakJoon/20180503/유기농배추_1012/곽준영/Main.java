package 유기농배추_1012.곽준영;

import java.util.Scanner;

public class Main {
	public static void main(String args[]){
		
		Main m = new Main();

		
	}

	private boolean checkMatrix[][]; // 근접 배추 체크했는지 알수있는 매트릭스
	private int matrix[][]; // 밭의 정보를 가지고있는 매트릭스
	private int[][] cabbage; // 배추의 정보를 가지고 있는 매트릭스
	private int m,n,k; // 초기 셋팅값
	private Scanner s;
	
	public Main(){
		s = new Scanner(System.in);
		
		String size = s.nextLine();
		
		int num = Integer.parseInt(size);
		int []cnt = new int[num];
		
		for(int i = 0;i<num;i++){
			cnt[i] = play();
		}
		for(int i = 0;i<num;i++){
			if(i == num-1){
				System.out.print(cnt[i]);
			}else{
				System.out.println(cnt[i]);
			}
			
		}

	}
	
	public int play(){

		String setting = s.nextLine();
		
		m = Integer.parseInt(setting.split(" ")[0]);
		n = Integer.parseInt(setting.split(" ")[1]);
		k = Integer.parseInt(setting.split(" ")[2]);
		
		checkMatrix = new boolean[n][m];
		matrix = new int[n][m];
		cabbage = new int[k][2];
		
		int cnt = 0;
		
		for(int i = 0;i<n;i++){
			for(int j = 0; j< m;j++){
				checkMatrix[i][j] = false;
				matrix[i][j] = 0;
			}
		}
		
		
		for(int i = 0;i<k;i++){
			String line = s.nextLine();
			
			cabbage[i][0] = Integer.parseInt(line.split(" ")[0]);
			cabbage[i][1] = Integer.parseInt(line.split(" ")[1]);
			
			matrix[cabbage[i][1]][cabbage[i][0]] = 1;
		}
		
		for(int i = 0; i<k; i++){
			if(checkMatrix[cabbage[i][1]][cabbage[i][0]] == false){
				cnt++;
				search(cabbage[i][0],cabbage[i][1]);
			}
		}
		
		return cnt;
	}
	
	public void search(int x, int y){
		check(x+1,y);
		check(x-1,y);
		check(x,y-1);
		check(x,y+1);
	}
	
	public void check(int x, int y){
		if(x>=0 && x<=m-1 && y>=0 && y<=n-1 ){
			if(matrix[y][x] == 1 && checkMatrix[y][x] == false){
				checkMatrix[y][x] = true;
				search(x,y);
			}
		}
		
	}
}

