import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
첫째 줄에 자연수 N(1 <= N <= 100,000)이 주어진다.
둘째 줄에 N개의 정수 A[]가 준어진다.
셋째 줄에 자연수 M(1 <= M <= 100,000)이 주어진다.
다음 줄에 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아보고
존재하면 1, 존재하지 않으면 0 출력
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A); // A 배열 정렬

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            // 배열 A에 존재하는지 확인할 정수
            int num = Integer.parseInt(st.nextToken());

            // binarySearch의 결과에 따라 출력
            if (binarySearch(A, num) >= 0) {
                // mid 값이 반환 되는 경우 수가 존재하는 것이기 때문에 1 출력
                System.out.println(1);
            } else
                // -1 이 반환되는 경우 비교하는 수가 존재하지 않기 때문에 0 출력
                System.out.println(0);
        }

    }

    // 이진탐색을 위한 메서드
    public static int binarySearch(int[] A, int t) {
        // A[]는 이미 작은 수 부터 큰 수 까지 정렬 완료
        int lo = 0; // 가장 작은수 인덱스 번호
        int hi = A.length - 1;  // 가장 큰수 인덱스 번호

        // 가장 작은 수가 큰 수 보다 작은 동안 반복
        while (lo <= hi) {
            // mid 값은 lo 값과 hi 갑의 중앙 값
            int mid = (lo + hi) / 2;

            if (t < A[mid]) {
                // A[mid]값이 비교하는 수보다 크면
                // hi 값을 mid 값보다 하나 작은 수로 변경
                hi = mid - 1;
            } else if (t > A[mid]) {
                // A[mid]값이 비교하는 수보다 작으면
                // lo 값을 mid 값보다 하나 큰 수로 변경
                lo = mid + 1;
            } else {
                // 위 두 경우가 아니라면 mid==t 이므로 mid return
                return mid;
            }
        }
        return -1;
    }
}
