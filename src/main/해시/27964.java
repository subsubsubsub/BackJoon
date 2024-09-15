import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/*
첫 번째 줄에 토핑의 개수가 1이상 100이하의 정수로 주어진다.
두 번째 줄에는 한줄로 구성된 토핑의 목록이 주어진다.
각 토핑들은공백으로 구분되어 있으며, 1개 이상 100개 이하의 영문 대소문자로 구성되어 있다.
대소문자 구분
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<String> hset = new HashSet<>();

        int n = Integer.parseInt(st.nextToken());
        String keyword = "Cheese";


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            String menu = st.nextToken();

            if (menu.endsWith(keyword)) {
                hset.add(menu);
            }
        }

        if (hset.size() >= 4) {
            System.out.println("yummy");
        } else
            System.out.println("sad");

        br.close();
    }
}
