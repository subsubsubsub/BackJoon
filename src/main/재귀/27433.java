import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
첫 째줄에 가정한 횟수 t가 주어진다.
다음 t개 줄에는 한 줄에 하나씩 가정에 대한 정보가 주어진다. 각 줄에는 두 개의 음이 아닌 정수 a와 b가 공백 하나를 사이에 두고 주어진다.
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(recursion(n));
        br.close();
    }

    static long recursion(int n) {
        if (n <= 0) return 1;

        return n * recursion(n - 1);
    }
}
