import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*  주몽 silver 4
재료의 개수 (배열의 크기) n
갑옷을 만드는데 필요한 수 (배열 내의 두 원소의 합 기준) m
재료의 고유 수
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int cnt = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int i = 0;
        int j = n - 1;
        while (i < j) {
            if (arr[i] + arr[j] == m) {
                cnt++;
                i++;
                j--;
            } else if (arr[i] + arr[j] > m) {
                j--;
            } else if (arr[i] + arr[j] < m) {
                i++;
            }
//            System.out.println(arr[i] + arr[j]);
        }
//        System.out.println();
        System.out.println(cnt);
        br.close();
    }
}
