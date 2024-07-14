import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 최종 생성자를 담아줄 변수
        int result = 0;

        for (int i = 1; i <= n; i++) {

            // num을 i로 초기화 하여 i를 변경해 주지 않고 수식 계산 가능
            int num = i;
            int sum = 0;

            while (num != 0) {
                //num을 10으로 나눈 나머지를 sum에 더해주고 num을 10으로 나눠준다.
                sum += num % 10;
                num /= 10;
            }

            if (sum + i == n) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
