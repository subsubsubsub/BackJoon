import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// bronze 2
// 4종류의 과일이 최대 5개까지 그려져 있다.
// 첫 줄에 펼쳐진 카드의 수 n이 주어진다
// 두번째 줄에 n개의 줄에 걸쳐 한 줄에 하나씩 펼쳐진 카드의 정보가 주어진다.
// 카드의 정보는 공백으로 구분된, 광리의 종류를 나타내는 문자열 s와 과일의 개수를 나타내는 양의 정수 x로 이루어져 있다.
// S는 STRAWBERRY, BANANA, LIME, PLUM중 하나
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<String, Integer> map = new HashMap<>(); // HashMpa 선언

        int n = Integer.parseInt(st.nextToken());
        String bell = "NO"; // 출력갑 기본 NO설정

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String str = st.nextToken();
            int x = Integer.parseInt(st.nextToken());

            if (!map.containsKey(str)) {    // key 값이 없다면 그대로 저장
                map.put(str, x);
            } else {    // key 가 존재한다면 value 업데이트
                map.put(str, map.get(str) + x);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue()); // map의 key, value쌍 확인
            if (entry.getValue() == 5) {
                bell = "YES";
                break;
            }
        }

        System.out.println(bell);
//        System.out.println(map.keySet());
    }
}
