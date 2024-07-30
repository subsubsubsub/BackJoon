import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Deque<Integer> dq = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String order = st.nextToken();


            if (order.equals("push_front")) {
                int num = Integer.parseInt(st.nextToken());
                dq.addFirst(num);
            } else if (order.equals("push_back")) {
                int num = Integer.parseInt(st.nextToken());
                dq.addLast(num);
            } else if (order.equals("pop_front")) {
                if (dq.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(dq.pollFirst());
                }
            } else if (order.equals("pop_back")) {
                if (dq.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(dq.pollLast());
                }
            } else if (order.equals("size")) {
                System.out.println(dq.size());
            } else if (order.equals("empty")) {
                if (dq.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (order.equals("front")) {
                if (dq.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(dq.peekFirst());
                }
            } else if (order.equals("back")) {
                if (dq.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(dq.peekLast());
                }
            }
        }
    }
}
