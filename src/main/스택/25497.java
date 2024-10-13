import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String[] arrStr = str.split("");

//        for (int i = 0; i < arrStr.length; i++) { // 정상적으로 배열에 입력됬는지 확인
//            System.out.println(arrStr[i]);
//        }

        int cnt = 0;
        int cntL = 0;
        int cntS = 0;
        for (int i = 0; i < arrStr.length; i++) {
            if (arrStr[i].equals("L")) {
                cntL++;
            } else if (arrStr[i].equals("R")) {
                if (cntL > 0) {// 0보다 큰 경우 앞서 L가 나왔으므로 cntL을 하나 빼주고 cnt 를 하나 올린다.
                    cntL--;
                    cnt++;
                }else if(cntL == 0){    // cntL이 0인경우 앞에 L이 한번도 나오지 않은 상태이기 때문에 R이 나오면 꼬이게 된다.
                    break;
                }
            }else if(arrStr[i].equals("S")){
                cntS++;
            }else if (arrStr[i].equals("K")) {
                if (cntS > 0) { // 0보다 큰 경우 앞서 S가 나왔으므로 cntS를 하나 빼주고 cnt 를 하나 올린다.
                    cntS--;
                    cnt++;
                } else if (cntS == 0) { // cntS이 0인경우 앞에 S이 한번도 나오지 않은 상태이기 때문에 K이 나오면 꼬이게 된다.
                    break;
                }
            } else cnt++;
        }

        System.out.println(cnt);
    }
}
