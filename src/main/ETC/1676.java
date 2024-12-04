import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 팩토리얼 0의 개수 silver 5
/*
뒷자리가 0이 n개 있다는 의미는 2와 5가 n 개씩 짝지어 존재한다는 것이다(2*5=10)
팩토리얼 값은 2는 5보다 작은 수여서 연속된 수를 곱하게 되면 모든 값들의 소인수 분해들은 2의 개수가 5의 개수보다 많다
즉 5의 개수에 따라 값이 변화한다.
반복문을 이용해 5로 나누면서 누적합을 구한다.
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        while (n >= 5) {
            cnt += n / 5;
            n /= 5;
        }
        System.out.println(cnt);
    }
}