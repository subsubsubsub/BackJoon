import java.io.*;

// 수들의 합 silver 5
/*
서로 다른 n개의 자연수의 합이 s라고 한다. s를 알때 n의 최댓 값은 얼마일까?
문제에 정보가 너무 없어서 이해하기 힘들다.
-> 자연수의 합 s가 주어졌을때 서로 다른 정수를 더해서 s를 만들어야 한다.
즉, s = 200일때 199 + 1 이면 n = 2가 되는 것이다.
간단하게 1부터 s보다 누적 합이 커질때까지 더하면서 count 해주면 된다.
s=200일때 1부터 20까지 더한 누적합은 210이고 여기서 10을 빼주면 200이 된다.
즉, count는 20이 나오며 정수 10 한 개를 빼주니 결과 값은 19가 된다.
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Long n = Long.parseLong(br.readLine());

        Long sum = 0L;
        int cnt = 0;

        int i = 1;
        while (sum <= n) {
            System.out.println(i);
            sum += i;
            i++;
            cnt++;

        }
        System.out.println(sum);
        System.out.println(cnt - 1);

    }
}