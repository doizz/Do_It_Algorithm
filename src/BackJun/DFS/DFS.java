package BackJun.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS {
    static boolean visited[];
    static ArrayList<Integer>[] A;
    static ArrayList<Integer> bfs_result = new ArrayList<>();
    static ArrayList<Integer> dfs_result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        A = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }
        for(int j=1 ; j < A.length ; j++){
            Collections.sort(A[j]);
        }
        dfs_ex(start);
        bfs_ex(n, start);
        dfs_result.forEach(e -> System.out.print(e+ " "));
        System.out.println();
        bfs_result.forEach(e -> System.out.print(e+ " "));
    }

    private static void bfs_ex(int n, int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[n + 1];
        visited[start] = true;
        bfs_result.add(start);
        queue.offer(start);
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int i : A[now]){
                if(!visited[i]){
                    visited[i] = true;
                    bfs_result.add(i);
                    queue.offer(i);
                }
            }
        }
    }

    private static void dfs_ex(int v) {
        if (visited[v]) {
            return;
        }
        visited[v] = true;
        dfs_result.add(v);
        for (int i : A[v]) {
            if (!visited[i]) {
                dfs_ex(i);
            }
        }
    }

}

