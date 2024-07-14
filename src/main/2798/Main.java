import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // arr 에 입력 값이 들어갔는지 확인
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }

        int result = 0;
        // 숫자 3개를 뽑아야 하기 때문에  n - 2 까지
        for (int i = 0; i < n - 2; i++) {

            int tmpResult = 0;  // 임시로 합을 저장할 변수    // i 를 한 바퀴 돌때마다 초기화
            // 앞에 뽑은 숫 자를 제외하고 i + 1 부터 위에서 하나를 뽑았기 때문에 n - 1 까지
            for (int j = i + 1; j < n - 1; j++) {

                // 앞에 뽑은 숫 자를 제외하고 j + 1 부터 위에서 두 개를 뽑았기 때문에 n 까지
                for (int k = j + 1; k < n; k++) {
                    tmpResult = arr[i] + arr[j] + arr[k];
                    if (tmpResult == m) {   // 합이 m 보다 커지면 안되기 때문에 tmpResult == m 인경우가 가장 합이 큰수
                        result = tmpResult;
                        break;
                    }
                    if (tmpResult < m && result < tmpResult) {
                        // 세 수의 합이 m 보다 작고 result 보다 크면 result 에 저장
                        result = tmpResult;
                    }
                }
                if (result == m) {
                    break;
                }
            }
            if (result == m) {
                break;
            }
        }
        System.out.println(result);
    }
}
