import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*  미로탐색 silver 1
n X m 크기의 배열로 표현되는 미로가 있을때, 미로에서 1은 이동할 수 있는 칸을 나타내고 0은 이동할 수 없는 칸을 나타낸다.
정수 n, m 이 주어지고, n개의 줄에 m개의 정수로 미로가 주어진다. (각 수들은 붙어서 입력)
(n, m)까지 도달하는데 이동해야 하는 최소 칸수를 출력
*/

public class Main {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static boolean[][] visited;
    static int[][] A;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        A = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            // 공백없이 입력받기 때문에 문자열로 받아 하나씩 나눠 정수로 변환 후 각 index 에 넣어준다.
            String line = st.nextToken();
            for (int j = 0; j < m; j++) {
                A[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }
        BFS(0, 0);

        System.out.println(A[n-1][m-1]);
    }

    private static void BFS(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer((new int[]{i, j}));
        while (!q.isEmpty()) {
            int now[] = q.poll();
            visited[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if (x >= 0 && y >= 0 && x < n && y < m) {   // 주어진 2차원 배열 범위
                    if (A[x][y] != 0 && !visited[x][y]) { // 값이 0이여서 갈 수 없거나, 이미 방문한 배열이면 안됨
                        // 이제 탐색할 수 있는 공간
                        visited[x][y] = true;
                        A[x][y] = A[now[0]][now[1]] + 1;
                        q.add(new int[]{x, y});
                    }
                }
            }
        }
    }
}
