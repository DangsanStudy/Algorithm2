/* GPT-4o가 작성한 코드. */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine(); // 괄호 문자열 입력 받기
        Stack<Character> stack = new Stack<>(); // 스택 초기화
        int totalPieces = 0; // 총 조각 개수

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);

            if (current == '(') {
                // 여는 괄호는 무조건 스택에 push
                stack.push(current);
            } else { // current == ')'
                // 닫는 괄호인 경우
                stack.pop(); // 스택에서 하나 꺼냄
                
                if (input.charAt(i - 1) == '(') {
                    // 바로 직전이 '('인 경우 → 레이저
                    totalPieces += stack.size(); // 현재 스택의 크기만큼 조각 추가
                } else {
                    // 쇠막대기의 끝인 경우
                    totalPieces += 1; // 쇠막대기 끝부분으로 인해 1개의 조각 추가
                }
            }
        }

        System.out.println(totalPieces); // 결과 출력
    }
}

