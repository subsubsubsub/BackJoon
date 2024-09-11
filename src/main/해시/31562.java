import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
bronze 1 <전주 듣고 노래 맞히기>

첫 줄에 정환이 음을 아는 노래의 개수 N, 정환이 맞히기를 시도할 노래의 개수 M이 공백으로 구분되어 주어진다.
두 번째 줄부터 N개의 줄에 걸쳐 노래 제목의 길이 T, 영어 대소문자로 이루어진 문자열 노래 제목 S, 해당 노래에서 처음 등장하는 일곱 개의 음이름
a1, a2, a3, a4, a5, a6, a7 이 공백으로 구분되어 주어진다.

첫 세 음이 동일한 노래가 하나만 있다면 해당 노래의 제목을, 두 개 이상이면 ?을, 없다며 ㄴ!을 한 줄에 하나씩 출력

*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<String, String> map = new HashMap<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 노래 제목 길이, 노래제목, 일곱개의 음 입력 후 map에 저장(map에 저장 하는건 노래이름과 첫 세 음절)
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            // 하나씩 입력받지 않고 한 번에 받은 다음에 짤라주면 안될까?
            String s = st.nextToken();
            String a1 = st.nextToken();
            String a2 = st.nextToken();
            String a3 = st.nextToken();
            String a4 = st.nextToken();
            String a5 = st.nextToken();
            String a6 = st.nextToken();
            String a7 = st.nextToken();
            String a = a1 + a2 + a3;

            map.put(s, a);
        }

//        for(Map.Entry<String, String> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String key = "";
            int cnt = 0;
            // 위에서 한 번에 받아주면 이것도 더 쉽게 될꺼같은데
            String a1 = st.nextToken();
            String a2 = st.nextToken();
            String a3 = st.nextToken();
            String a = a1 + a2 + a3;

            for(Map.Entry<String, String> entry : map.entrySet()) {
                if (a.equals(entry.getValue())) {
                    key = entry.getKey();
                    cnt++;
                }
            }
            if(cnt==0)
                System.out.println("!");
            else if (cnt==1) {
                System.out.println(key);
            } else System.out.println("?");
        }
        br.close();
    }
}
