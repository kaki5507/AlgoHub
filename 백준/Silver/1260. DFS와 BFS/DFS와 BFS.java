import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.List;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Main{
    static int N; // 정점의 개수
    static int M; // 간선의 개수
    static int V; // 정점 시작 번호
    static List<List<Integer>> adjList; // 근접 노드
    static boolean[] visited; // 방문

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        adjList = new ArrayList<>(N+1);
        for(int i=0; i<=N; i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){ // 간선 입력 받아서 넣기
            st = new StringTokenizer(br.readLine()," ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        // 각 리스트들 작은 값 먼저 나와야 함
        for(int i=1; i<=N; i++){
            Collections.sort(adjList.get(i));
        }

        visited = new boolean[N+1]; // 방문체크
        dfs(V);
        System.out.println("");// 줄바꿈
        visited = new boolean[N+1]; // 방문체크
        bfs(V);
    }

    // dfs private으로
    public static void dfs(int n){
        visited[n] = true; // 방문했으니
        System.out.print(n + " ");
        for(int neighbor : adjList.get(n)){ // 방문한 노드 연결된 숫자 체크
            if(!visited[neighbor]){
                dfs(neighbor); // 방문 안했으면 다시 넣어서 방문
            }
        }
    }

    // bfs private으로
    public static void bfs(int n){
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = true; // 방문했으니 true

        while(!q.isEmpty()){ // q가 비어있지 않을때 까지
            int current = q.poll(); // 현재 꺼 꺼냄
            System.out.print(current + " ");
            for(int next : adjList.get(current)){
                if(!visited[next]){
                    visited[next] = true;
                    q.add(next); // next 방문 안했으면 다시 넣음
                }
            }
        }
    }
}