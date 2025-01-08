package Week01.조영호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스택수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        System.out.print("수열의 크기를 입력하세요: ");
        int n = Integer.parseInt(br.readLine());

        System.out.println("수열을 입력하세요:");
        int[] sequence = new int[n];
        for (int i = 0; i < n; i++) {
            sequence[i] = Integer.parseInt(br.readLine());
        }

        // 연산 수행
        String result = canGenerateSequence(sequence, n);

        // 결과 출력
        System.out.println(result);
    }

    public static String canGenerateSequence(int[] sequence, int n) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int currentNumber = 1; // 스택에 넣을 숫자

        for (int num : sequence) {
            // 스택에 현재 숫자를 추가하여 목표 숫자까지 도달
            while (currentNumber <= num) {
                stack.push(currentNumber++);
                sb.append("+\n"); // push 연산
            }

            // 스택의 top이 목표 숫자와 같다면 pop 수행
            if (stack.peek() == num) {
                stack.pop();
                sb.append("-\n"); // pop 연산
            } else {
                // 목표 숫자를 만들 수 없는 경우
                return "NO";
            }
        }

        return sb.toString();
    }
}
