package beakjoon_25918;

import java.util.Scanner;
import java.util.Stack;

public class 북극곰은_괄호를_찢어 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        System.out.print("문자열의 길이는: ");
        int n = scanner.nextInt();
        System.out.print("문자열은: ");
        String target = scanner.next();

        // 목표 문자열 검증
        if (target.length() != n || !isValidParentheses(target)) {
            System.out.println("올바른 길이와 괄호 문자열을 입력하세요.");
            return;
        }

        // 초기값 설정
        String current = ""; // 현재 문자열
        int days = 0;         // 며칠이 걸렸는지

        while (!current.equals(target)) {
            days++;
            Stack<Character> stack = new Stack<>();
            StringBuilder night = new StringBuilder();

            // 밤에 필요한 문자를 추가
            for (int i = 0; i < target.length(); i++) {
                if (i >= current.length() || current.charAt(i) != target.charAt(i)) {
                    night.append(target.charAt(i));
                } else {
                    night.append(' '); // 동일한 부분은 그대로 둠
                }
            }

            // 낮에 북극곰이 찢는 행동을 스택으로 구현
            for (char c : (current + night.toString()).toCharArray()) {
                if (c != ' ') {
                    if (!stack.isEmpty() && stack.peek() == '(' && c == ')') {
                        stack.pop(); // ()를 제거
                    } else {
                        stack.push(c);
                    }
                }
            }

            // 스택을 기반으로 새로운 문자열 생성
            StringBuilder newCurrent = new StringBuilder();
            for (char c : stack) {
                newCurrent.append(c);
            }
            current = newCurrent.toString();
        }

        System.out.println("최소 며칠이 걸렸는지: " + days);
    }

    // 유효한 괄호 문자열인지 확인
    private static boolean isValidParentheses(String s) {
        int balance = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                balance++;
            } else if (c == ')') {
                balance--;
                if (balance < 0) {
                    return false;
                }
            } else {
                return false; // 유효하지 않은 문자
            }
        }
        return balance == 0;
    }
}
