package Week01.조영호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class 쇠막대기 {
    public static int countCutPieces(String brackets) {
        Stack<Character> stack = new Stack<>();
        int totalPieces = 0;

        for (int i = 0; i < brackets.length(); i++) {
            char current = brackets.charAt(i);

            if (current == '(') {
                stack.push(current);
            } else {
                stack.pop();
                if (brackets.charAt(i - 1) == '(') {
                    // 레이저: 스택의 크기만큼 조각 추가
                    totalPieces += stack.size();
                } else {
                    // 쇠막대기의 끝: 조각 하나 추가
                    totalPieces += 1;
                }
            }
        }

        return totalPieces;
    }

    public static void main(String[] args) throws IOException {
         // 입력을 위한 BufferedReader
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // 괄호 문자열 입력받기
        System.out.print("괄호 문자열을 입력하세요: ");
        String brackets = bf.readLine();

        // 결과 계산
        int result = countCutPieces(brackets);

        // 결과 출력
        System.out.println("잘려진 쇠막대기의 총 조각 수: " + result);
    }
}