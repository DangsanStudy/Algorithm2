package beakjoon_25918;

import java.util.*;

public class 북금곰은_괄호를_찢어 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 문자열의 길이 N과 문자열 S를 입력받기
        String str;
        int len = 0;
        while (true) {
            System.out.print("문자열의 길이는 : ");
            len = scanner.nextInt();

            System.out.print("문자열은 : ");
            str = scanner.next();

            if (str.length() == len) break;
            System.out.println("다시 입력하세요(입력된 문자열과 길이가 다릅니다)");
        }

        List<Character> arrList = new ArrayList<>();

        Stack<Character> stack = new Stack<>();
        int day = 1;

        // List에 문자열 추가하기
        for (char ch : str.toCharArray()) {
            arrList.add(ch);
        }

        while (true) {
            // 스택에 문자열 push하기
            for (char ch : arrList) {
                stack.push(ch);
            }
            System.out.println("stack = " + stack);

            // 스택에 문자열 pop하기
            List<Character> tempList = new ArrayList<>();

            while (!stack.isEmpty()) {
                char current = stack.pop();
                if (!stack.isEmpty() && current != stack.peek()) {
                    stack.pop();
                } else {
                    tempList.add(current);
                }
            }

            Collections.reverse(tempList); // 순서 복구
            arrList = tempList;

            if (arrList.isEmpty()) break;

            day++;
        }

        System.out.println("day = " + day);
    }
}
