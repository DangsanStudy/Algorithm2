package Week01.현정섭;
import java.io.*;
import java.util.*;

public class 쇠막대기 {

	public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        String question = bf.readLine();
        
        Stack<Character> stack = new Stack<>();
 
        int result = 0;

        for (int i = 0; i < question.length(); i++) {
            
            if (question.charAt(i) == '(') {
                stack.push('(');
                continue;
            }

            if (question.charAt(i) == ')') {
                stack.pop();
 
                if (question.charAt(i - 1) == '(') {
                    result += stack.size();
                } else {
                    result++;
                }
            }
        }

        System.out.println(result);

    }
}