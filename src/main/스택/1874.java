import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*  스택 수열 silver 2
첫 째줄에 수열의 갯수 n
다음 줄부터 n개의 숫자 입력 m
1~m 스택에 push 를 하면 + pop을 하면 - 출력
pop을 한 뒤에 다시 1 부터 하는 것이 아니라 계속 이어서 숫자를 스택에 추가한다.
추가해도 표현할 수 없는 경우 NO 출력

*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());

        int j = 1;
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());

            if (j > m && stack.peek() > m) {
                stack.push(0);
                break;
            }

            while (true) {
                if (j <= m) {
                    sb.append("+\n");
                    stack.push(j);
                    j++;
                } else if (stack.peek() == m) {
                    sb.append("-\n");
                    stack.pop();
                    break;
                }
            }
        }

        if (!stack.isEmpty()) {
            System.out.println("NO");
        } else {
            System.out.println(sb);
        }
    }
}
