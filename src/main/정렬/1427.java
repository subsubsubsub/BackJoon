import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*  소트인사이드 silver 5
정수 n을 입력 받고, 각 자리수를 내림차순으로 정렬한 뒤 출력 (선택정렬 사용)
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 배열의 크기 설정과 문자열을 하나 씩 자를때 오류가 없게 하기 위해서 문자열로 받는다
        // 정수로 받아 %10, /10을 하는경우 500613009 같은 예시가 들어올때 오류가 날 수 있다.
        String str = br.readLine();
        int[] arr = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = Integer.parseInt(str.substring(i, i + 1));
        }

        // 선택정렬
        for(int i=0;i<str.length();i++){
            int max = i;
            for(int j=i+1;j<str.length();j++){
                if(arr[j]>arr[max]){
                    max = j;
                }
            }
            if (arr[i] < arr[max]) {
                int tmp = arr[max];
                arr[max] = arr[i];
                arr[i] = tmp;
            }
        }

        for(int i=0;i<str.length();i++){
            System.out.print(arr[i]);
        }
        br.close();
    }
}
