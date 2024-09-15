import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/*
silver 5 임스와 함께 하는 미니게임
플레이할 미니게임은 윳놀이 Y, 같은 그림찾기 F, 원카드 O
각각 2, 3, 4명이 플레이하는 게임, 인원수가 부족하면 게임을 시작할 수 없음

같이 플레이하기를 신청한 횟수 n 과 임스가 플레이할 게임의 종류가 주어질 때, 최대 몇 번이나 임스와 함께 게임을 플레이할 수 있나?
한 번 플레이 한 사람은 다시 플레이 못함
동명이인은 없다
set이용?
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> hset = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        char kind = st.nextToken().charAt(0);

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            hset.add(str);
        }
//        System.out.println(hset);

        if(kind == 'Y'){
            System.out.println(hset.size());
        }else if(kind == 'F'){
            System.out.println(hset.size()/2);
        }else
            System.out.println(hset.size()/3);

        br.close();
    }
}
