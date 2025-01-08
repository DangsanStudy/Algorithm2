/* GPT-4o가 작성한 코드입니다. */

package java_자료구조_알고리즘;

import java.util.Scanner;
import java.util.Stack;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 수열의 크기

        int[] sequence = new int[n];
        for (int i = 0; i < n; i++) {
            sequence[i] = scanner.nextInt(); // 수열 입력
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        int current = 1; // 스택에 push할 숫자
        boolean isPossible = true;

        for (int i = 0; i < n; i++) {
            int target = sequence[i];

            // 스택에 필요한 숫자를 push
            while (current <= target) {
                stack.push(current++);
                result.append("+\n");
            }

            // 스택에서 숫자를 pop
            if (stack.peek() == target) {
                stack.pop();
                result.append("-\n");
            } else {
                // 수열을 만들 수 없는 경우
                isPossible = false;
                break;
            }
        }

        if (isPossible) {
            System.out.println(result);
        } else {
            System.out.println("NO");
        }

        scanner.close();
    }
}


