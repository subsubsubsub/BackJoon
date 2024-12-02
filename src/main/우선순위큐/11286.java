import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.LinkedList;

/*  절댓값 힙 silver 1
1. 연산의 수 n입력
2. 정수를 n번 입력
3. 입력 받은 정수가 0이 아니라면 배열에 정수 추가, 0이라면 배열에서 절댓값이 가장 작은 정수 출력 후 배열에서 해당 정수 삭제
4. 입력 받은 정수가 0일 때, 배열 안에 절댓값이 가장 작은 정수가 여러개 라면 가장 작은 수를 출력
    - 예) 배열이 [1, -1, 3, -3]인 경우 절댓값이 가장 작은 수는 3, -3 / 그 중 -3이 가장 작으므로 -3 출력후 배열에서 제거
5. 배열이 비어 있다면 0 출력

우선순위 큐 사용
    - 절댓값 기준으로 정렬되도록 설정
    - 단, 절댓값이 같으면 음수 우선 정렬
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> {
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);

            if (first_abs == second_abs) {
                return o1 > o2 ? 1 : -1;    // 절댓값이 같은 경우 음수 우선
            }

            return first_abs - second_abs;  // 절댓값 작은 데이터 우선
        });

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                if (q.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(q.poll());
                }
            } else {
                q.add(num);
            }
        }
        br.close();
    }
}
