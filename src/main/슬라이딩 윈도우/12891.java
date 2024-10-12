import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*  DNA 비밀번호 silver 2
슬라이딩 윈도우 알고리즘 사용 => 2개의 포인터로 범위를 지정한 다음 범위를 유지한 채로 이동하면서 문제를 해결
모든 문자열에 등장하는 문자는 {'A','C','G','T'} => 문자열에 다른 문자가 있으면 DNA 문자열이 아니다
부분 문자열에 'A', 'C', 'G'는 1 개 이상, 'T'는 0개 이상

*/

public class Main {
    static int[] myArr; // 부분 문자열에서 A, C, G, T의 실제 개수를 저장할 배열
    static int[] checkArr;  // 부분 문자열에 포함되어야 할 최소 개수 배열
    static int checkSecret; // 몇 개의 문자와 관련된 개수를 충족했는지 판단하는 변수(A, G, C, T 모두 충족되면 4)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int result = 0;
        checkArr = new int[4];
        myArr = new int[4];
        char[] A = new char[s];
        checkSecret = 0;

        A = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0) {
                checkSecret++;  // 최소 개수가 0일 경우 부분 문자열에 몇개가 오던 충족하기 때문
            }
        }

        for (int i = 0; i < p; i++) {   // 부분 문자열 처음 받을때 세팅
            Add(A[i]);
        }

        if (checkSecret == 4)
            result++;

        // 슬라이딩윈도우
        for (int i = p; i < s; i++) {
            int j = i - p;  // i는 부분 문자열에 가장 마지막 인덱스, j는 가장 처음 인덱스
            Add(A[i]); // 슬라이딩윈도우 가장 마지막 인덱스 한 칸 이동
            Remove(A[j]);   // 가장 처음 인덱스 한 칸 이동
            if (checkSecret == 4)
                result++;
        }

        System.out.println(result);

        br.close();
    }

    private static void Remove(char c) {
        switch (c) {
            case 'A':
                if (myArr[0] == checkArr[0])
                    checkSecret--;
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1])
                    checkSecret--;
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == checkArr[2])
                    checkSecret--;
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3])
                    checkSecret--;
                myArr[3]--;
                break;
        }
    }

    private static void Add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0])    // 비교 연산자가 >= 가 되는 경우 클경우 계속 ++ 되기 때문에 딱 맞는 경우만 ++
                    checkSecret++;
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1])
                    checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2])
                    checkSecret++;
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3])
                    checkSecret++;
                break;
        }
    }
}
