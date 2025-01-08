
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class 스택수열 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //수열 입력
        System.out.print("몇 가지 수열인가요 : ");
        int len = scanner.nextInt();
        int[] sequence = new int[len];
        ArrayList<String> push_pop = new ArrayList<>();
        for(int i = 0; i<len ; i++){
            int num = scanner.nextInt();
            sequence[i] = num;
        }
        int max_num = Arrays.stream(sequence).max().getAsInt();

        //Stack 클래스 생성
        Stack<Integer> stackInt = new Stack<>();

        int index = 0;
        int pp_index = 0;
        for(int i = 1; i< max_num+1; i++){
            stackInt.push(i);
            push_pop.add("+");
            // 스택의 맨 위 값과 현재 수열 값을 비교
            while (!stackInt.isEmpty() && stackInt.peek() == sequence[index]) {
                stackInt.pop();
                push_pop.add("-");
                index++;
            }

        }

        // 결과 확인 및 출력
        if (index == len) { // 모든 수열을 만족시킨 경우
            for (String operation : push_pop) {
                System.out.println(operation);
            }
        } else { // 만족시키지 못한 경우
            System.out.println("NO");
        }


    }
}
