import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Deque<Integer> dq = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int order = Integer.parseInt(st.nextToken());

            switch (order) {
                case 1:
                    int num = Integer.parseInt(st.nextToken());
                    dq.addFirst(num);
                    break;
                case 2:
                    int x = Integer.parseInt(st.nextToken());
                    dq.addLast(x);
                    break;
                case 3:
                    if (dq.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(dq.poll()).append("\n");
                    }
                    break;
                case 4:
                    if (dq.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(dq.pollLast()).append("\n");
                    }
                    break;
                case 5:
                    sb.append(dq.size()).append("\n");
                    break;
                case 6:
                    if (dq.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case 7:
                    if (dq.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(dq.peek()).append("\n");
                    }
                    break;
                case 8:
                    if (dq.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(dq.peekLast()).append("\n");
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println(sb);
        br.close();
    }
}
