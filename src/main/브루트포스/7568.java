import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 덩치 silber 5
/*
이차원 배열에 키와 몸무게를 입력받고 2번 인덱스에 랭크를 입력
초기 랭크는 모두 1로 초기화
브루트포스 이용
이중 for문을 돌며 각각의 키와 몸무게를 비교하고, 키와 몸무게 모두가 자신보다 큰경우 내 랭크를 +1
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];

        int rank = 1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            arr[i][2] = rank;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    arr[i][2] += 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i][2] + " ");

        }
    }
}