import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<String> stStr = new Stack<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            String[] arrStr = str.split(" ");   // 입력받은 문자열을 공백 단위로 나눠 배열에 저장
            sb = new StringBuilder();   // 마지막에 저장 후 출력해줄 문자열

            for (int j = 0; j < arrStr.length; j++) {
                stStr.push(arrStr[j]); // 공백단위로 나눈 담은 배열을 하나씩 스택에 저장
            }
            for (int j = 0; j < arrStr.length; j++) {
                sb.append(stStr.pop() + " ");   // 마지막에 삽입한 문자부터 pop 하여 sb에 저장
            }
                System.out.println("Case #" + i + ": " + sb);
        }
    }
}
