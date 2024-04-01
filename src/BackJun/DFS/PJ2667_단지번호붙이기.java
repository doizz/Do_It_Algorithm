package BackJun.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class PJ2667_단지번호붙이기 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int[][] arr;
    static int N, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        visited = new boolean[N][N];
        arr = new int[N][N];
        ArrayList<Integer> arrayList = new ArrayList<>();


        for(int i=0 ; i<N ; i++){
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j=0 ; j<N ; j++){
                arr[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        for(int i=0 ; i<N ; i++){
            for(int j=0 ; j<N ; j++){
                count = 0;
                if(arr[i][j] != 0 &&  !visited[i][j]){
                    dfs_2667(i, j);
                    arrayList.add(count);
                }
            }
        }
        System.out.println(arrayList.size());
        Collections.sort(arrayList);
        arrayList.forEach(System.out::println);
    }

    private static void dfs_2667(int i, int j) {
        count++;
        visited[i][j] = true;

        for(int k = 0 ; k <4 ;k ++){
            int x = i + dx[k];
            int y = j + dy[k];
            if(x >= 0 && y >= 0 && x < N && y < N){
                if(!visited[x][y] && arr[x][y] == 1){
                    dfs_2667(x,y);
                }
            }
        }
    }
}
