import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

/*
bronze 1 문자열 게임

구분자 : 문자열을 나누는 기준
병합자 : 구분자에서 제외하는 조건

문자열을 규칙에 따라 나누는 게임이다
문자열을 공백과 주어진 구분자들로 나눈다.
각 문자 구분자는 영어 대소문자 중 하나이다.
각 숫자 구분자는 0부터 9까지의 숫자 중 하나이다.
병합자로 주어진 문자들은 구분자로 취급하지 않는다.
각 병합자는 영어 대소문자와 0부터 9까지의 숫자 중 하나이다.
구분자와 병합자는 모두 한 글자로 이루어져 있다.
나눌 문자열인 기준 문자열은 영어 대소문자, 숫자, 공백으로 이루어져 있다.
같은 구분자 및 병합자가 주어질 수 있다.

N개의 문자 구문자, M개의 숫자 구분자, K개의 병합자, 문자열의 길이 S와 기준 문자열이 주어질 때 해당 규칙들을 적용한 결과를 출력한다.

*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashSet<Character> hSet = new HashSet<>();

        int n = Integer.parseInt(br.readLine()); // 문자 구분자 수
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 구분자 입력
        for (int i = 0; i < n; i++) {
            String strN = st.nextToken();
            hSet.add(strN.charAt(0));
        }

        int m = Integer.parseInt(br.readLine());    // 숫자 구분자 수
        st = new StringTokenizer(br.readLine());

        // 병합자 입력
        for (int i = 0; i < m; i++) {
            String strM = st.nextToken();
            hSet.add(strM.charAt(0));
        }

//        System.out.println(hSet);

        // 병합자 수
        int k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        // 병합자 입력
        for (int i = 0; i < k; i++) {
            String strK = st.nextToken();

            if (hSet.contains(strK.charAt(0))) {
                hSet.remove(strK.charAt(0));
            }
        }

        int s = Integer.parseInt(br.readLine());    // 문자열 수
        String str = br.readLine(); // 문자열 입력

        boolean flag = false;   // 구분자와 같은 문자이거나 공백일경우 무조껀 "\n"를 실행하기 때문에 이를 방지하기 위해 필요
        for (int i = 0; i < s; i++) {   // 위에서 입력받은 문자열 길이 만큼 반복
            char ch = str.charAt(i);    // 문자 입력
            if (ch == ' ' || hSet.contains(ch)) {   // 입력 받은 문자가 공백이거나 구분자이면 if문 진입
                if (flag) {
                    // flag가 true이면 if문 진입(아래 '예제1' 의 경우 해당 flag가 없으면 구분자가 나올 때마다 "\n"를 입력하게 된다.
                    // 하지만 한번 이 조건문을 진입하면 flag가 false가 되고 연속해서 구분자가 등장해도 flag가 false이기 때문에 "\n"가 계속해서 입력되지 않는다.
                    sb.append("\n");
                    flag = false;
                }
                continue;
            }
            sb.append(ch);
            flag = true;
        }
        /* 예제1)
        3
        b c d
        1
        1
        1
        e
        6
        abcde1
        */

        System.out.println(sb);
    }
}
