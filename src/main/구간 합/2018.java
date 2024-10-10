import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*  수들의 합 silver 5
어떠한 자연수 n은 몇 개의 연속된 자연수의 합으로 나타낼 수 있다.
첫 줄에 정수 n
정수 n이하의 수 중 연속된 자연수의 합으로 n을 만들 수 있는 경우 cnt
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int start = 1, end = 1, sum = 1, cnt = 1;

        while (end != n) {
            if (sum == n) {
                cnt++;
                end++;
                sum += end;
            } else if (sum < n) {
                end++;
                sum += end;
            } else if (sum > n) {
                sum -= start;
                start++;
            }
        }
        System.out.println(cnt);
        br.close();
    }
}
