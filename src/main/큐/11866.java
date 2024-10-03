import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> people = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }
        // 큐의 초기 상태 출력
        // System.out.println(q);

        sb.append("<");
        while (q.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                q.offer(q.poll());
                // 큐의 상태 출력
                // System.out.println(q);
            }
            sb.append(q.poll() + ", ");
            // 구분선 출력
            // System.out.println("-".repeat(20));
        }
        sb.append(q.poll() + ">");
        System.out.println(sb);
    }
}
