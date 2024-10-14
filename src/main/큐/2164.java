import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*  스택 수열 silver 2
N장의 카드가 있을때 1~N까지 차례대로 카드가 쌓여있다. 가장 위에는 1이 놓여진다.
먼저 가장 위에 카드를 한 장 버린다. 그 다음 남은 카드에서 가장 위에 카드를 카드의 아래로 옮긴다.
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());

        for(int i=1;i<=n;i++) {
            q.add(i);
        }

        while (q.size() != 1) {
            q.poll();
            q.add(q.poll());
        }
        System.out.println(q.peek());
        br.close();
    }
}
