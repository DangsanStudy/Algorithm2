
import java.util.Scanner;
import java.util.Stack;

public class 쇠막대기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력받기
        String pipeStr = scanner.next();
        StringBuilder transformed = new StringBuilder();

        // i) 레이저 검출 및 변환
        for (int i = 0; i < pipeStr.length(); i++) {
            char current = pipeStr.charAt(i);
            if (current == ')' && i > 0 && pipeStr.charAt(i - 1) == '(') {
                // "()" 레이저를 숫자 1로 변환
                transformed.setCharAt(transformed.length() - 1, '1');
            } else {
                // "(" 또는 ")"을 그대로 추가
                transformed.append(current);
            }
        }

        System.out.println("Transformed: " + transformed);

        // ii) 스택에 넣으면서 조각 계산
        Stack<Character> stack = new Stack<>();
        int total = 0;

        for (int i = 0; i < transformed.length(); i++) {
            char current = transformed.charAt(i);

            if (current == '(') {
                // "("이면 스택에 push
                stack.push(current);
            } else if (current == '1') {
                // 레이저 -> 현재 스택의 크기를 total에 더함
                total += stack.size();
            } else if (current == ')') {
                // ")"이면 스택에서 pop하고 total에 1 추가
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                total++;
            }
        }

        // 결과 출력
        System.out.println(total);
    }
}