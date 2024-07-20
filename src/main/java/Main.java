import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stNum1 = new Stack<>();
        Stack<Integer> stNum2 = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        int bigest = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            stNum1.push(num);
        }


        for (int i = 0; i < n; i++) {
            int popnum = stNum1.pop();
//            System.out.println("현 사이즈: " + stNum1.size());

            if (stNum2.isEmpty() || bigest < popnum) {
                cnt++;
                bigest = popnum;
//                System.out.println(bigest);
            }
            stNum2.push(popnum);
        }

        System.out.println(cnt);
    }
}
