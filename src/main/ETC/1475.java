import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 방 번호 silver 5
/*
정수가 주어졌을때 필요한 0~9까지 있는 숫자 세트가 몇 개 필요한지 구한다.
6과 9는 뒤집어서 사용할 수 있다.

cntArr[10] 변수를 만들어 주고 각각의 인덱스에 맞는 수를 넣어주고, 각각의 인덱스의 정수를 비교한 후 가장 큰 수 만큼 세트가 필요하다.
문자열로 입력 받은 뒤 반복문을 통해 계산해준다
c - '0' : '0'의 아스키 번호는 48이므로 '1', '2'...는 49,50..이 된다. 여기서 '0'을 빼주면 각각의 수를 정수로 만들어 줄 수 있다.
6과 9는 뒤집어 사용할 수 있으므로 하나로 합쳐준 뒤 2로 나누어 계산 할 수 있다.
이때, 입력 받은 수가 1666이라고 하면 6과 9번 인덱스 수를 합친 결과는 3, 2로 나누면 1이 된다. 이렇게 되면 필요한 수가 맞지 않으므로
6과 9를 합산한것에 1을 더한 뒤 2로 나누면 맞아 떨어진다.

*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num = br.readLine();

        int[] cntArr = new int[10];
        int result = 0;

        for (char c : num.toCharArray()) {
            cntArr[c - '0']++;
        }

        cntArr[6] = (cntArr[6] + cntArr[9] + 1) / 2;
        cntArr[9] = 0;

        for (int i : cntArr) {
            result = Math.max(result, i);
        }
        System.out.println(result);
    }
}