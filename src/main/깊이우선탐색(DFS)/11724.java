import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*  연결 요소의 개수 silver 2
노드의 개수 n 과 간선의 개수 m이 주어졌을때
연결 요소의 개수 출력 => 서로 연결된 노드들을 한 집합으로 했을때 몇 개의 집합이 나오는가?
깊이우선탐색(DFS)사용
방문 여부를 판단할 배열 필요
간선들을 표현할 ArrayList 필요
*/

public class Main {
    static boolean[] visited;   // 방문 여부를 판단할 배열
    static ArrayList<Integer>[] A;  // 간선을 표현할 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        A = new ArrayList[n + 1];

        for (int i = 1; i < n + 1; i++) {
            A[i] = new ArrayList<>(); // 한 개의 노드가 여러 노드와 연결 될 수 있기 때문에 각각의 노드는 ArrayList 로 초기화
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            // s->e , e->s 로 모두 움직일 수 있어야 하기 때문에 양쪽에 추가
            A[s].add(e);
            A[e].add(s);
        }
//        for (int i = 1; i < n + 1; i++) {
//            System.out.println("A[" + i + "]" + A[i]);
//        }
        int cnt = 0;
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {  // 방문 하지 않은 배열일 경우에만 cnt 를 올려주고 DFS실행
                cnt++;
                DFS(i);
            }
        }

        System.out.println(cnt);
        br.close();
    }

    private static void DFS(int v) {
        if (visited[v])
            return;
        visited[v] = true;

        for (int i : A[v]) {
            DFS(i);
        }
    }
}
