import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

/*  구간 합 구하기 4 silver 3
수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램 작성
첫째 줄 : 수의 개수 n, 합을 구해야 하는 횟수 m
둘째 줄 : n개의 수
셋째 줄 ~ : m개의 줄에는 합을 구해야 하는 구간 i와 j


*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        int[] sumArr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            sumArr[i] = sumArr[i - 1] + arr[i];

//            System.out.print(sumArr[i] + " ");
        }

        for (int k = 0; k < m; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            System.out.println(sumArr[j] - sumArr[i - 1]);
        }
    }
}
