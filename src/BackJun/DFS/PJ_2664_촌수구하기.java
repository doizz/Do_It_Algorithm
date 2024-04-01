package BackJun.DFS;

import java.util.ArrayList;
import java.util.Scanner;

public class PJ_2664_촌수구하기 {
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    static int N , M, start , end;
    static int result = -1;
    static int count =0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        start = sc.nextInt();
        end = sc.nextInt();
        M = sc.nextInt();
        A = new ArrayList[N +1];
        visited = new boolean[N + 1];
        for (int i = 1; i < N + 1; i++) {
            A[i] = new ArrayList<>();
        }

        for(int i = 0 ; i <M ; i++ ){
            int s = sc.nextInt();
            int e = sc.nextInt();
            A[s].add(e);
            A[e].add(s);
        }
        dfs_2664(start,end, count);
        System.out.println(result);
    }

    private static void dfs_2664(int start, int end, int count) {
        if(start == end){
            result = count;
            return;
        }
        visited[start] = true;

        for(int i=0 ; i< A[start].size() ; i ++){
            if(!visited[A[start].get(i)]){
                dfs_2664(A[start].get(i),end,count+1);
            }
        }
    }
}
