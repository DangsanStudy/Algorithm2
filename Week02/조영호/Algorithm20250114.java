package Week02.조영호;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.io.IOException;

public class Algorithm20250114 {
    public static void main(String[] args) throws IOException{
    // BufferedReader 객체 생성
    // 표준 입력으로부터 데이터 읽기 위해 BufferedReader 객체 생성
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

   
        // 문자열 길이 입력
        int length = Integer.parseInt(bf.readLine());

        // 문자열 초기화
        int answer = -1;


        //짝이 맞는 괄호 검사 및 최대 스택 크기 계산

        // 길이가 짝수인지 확인
        if(length %2 == 0) {
            char[] parentheses = bf.readLine().toCharArray();
            // 괄호를 짝지어가며 상태를 추적하기 위해 Stack<Character> stack 생성.
            Stack<Character> stack = new Stack<>();

            // 괄호 배열 순회
            for (char parenthesis : parentheses) {
                // 여는 괄호 또는 스택이 비었거나, 현재 문자와 스택 최상단 문자가 같으면 스택에 추가.
                if (stack.isEmpty() || stack.peek().equals(parenthesis)) {
                    stack.push(parenthesis);
                // 짝이 맞는 닫는 괄호를 만나면 스택에서 제거
                } else {
                    stack.pop();
                }
                // 반복 과정 중 스택 크기를 answer에 저장하며 최대값 갱신
                answer = Math.max(answer, stack.size());
            }
            if (!stack.isEmpty()) {
                answer = -1;
            }
        }
        System.out.println(answer);
        bf.close();

        
        
    }
    
}
