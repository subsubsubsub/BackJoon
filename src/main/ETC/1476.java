import java.io.*;
import java.util.StringTokenizer;

// 날짜 계산 silver 5
/*
1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19
e, s, m이 주어지고 각 수는 해당 범위를 넘어가면 1로 변한다.
단순하게 while 문을 돌리며 조건을 맞춰주니 풀리는 문제였다.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int i = 0;
        int j = 0;
        int k = 0;
        int cnt = 0;

        while (true) {
            i++;
            j++;
            k++;
            cnt++;
            if (i == 16)
                i = 1;
            if (j == 29)
                j = 1;
            if (k == 20)
                k = 1;
            if (i == e && j == s && k == m) {
                break;
            }
        }
        System.out.println(cnt);

    }
}