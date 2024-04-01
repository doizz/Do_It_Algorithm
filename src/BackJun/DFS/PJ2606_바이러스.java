package BackJun.DFS;

import java.util.ArrayList;
import java.util.Scanner;

public class PJ2606_바이러스 {
    static boolean[] visited;
    static int N, M;
    static int count =0;
    static ArrayList<Integer>[] A;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        visited = new boolean[N +1];
        A = new ArrayList[N +1];
        for(int i=1 ; i<N +1; i++){
            A[i] = new ArrayList<>();
        }
        for (int i=0 ; i<M ; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            A[x].add(y);
            A[y].add(x);
        }
        dfs(1);
        System.out.println(count);
    }
    private static void dfs(int v) {
        if(visited[v]){
            return;
        }

        visited[v] = true;
        for(int i : A[v]){
            if(!visited[i]){
                count++;
                dfs(i);
            }
        }
    }
}
