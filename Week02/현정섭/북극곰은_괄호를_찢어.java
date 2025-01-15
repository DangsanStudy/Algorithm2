package Week02.현정섭;
import java.io.*;
import java.util.*;

public class 북극곰은_괄호를_찢어 {

	public static void main(String[] args) throws Exception {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int len = Integer.parseInt(bf.readLine());

        if(len % 2 == 1){
            System.out.println(-1);
            return;
        }

        String question = bf.readLine();
        
        Stack<Character> stack = new Stack<>();

        int answer = 1;

        for (int i = 0; i < question.length(); i++) {
            
            if(stack.isEmpty()){
                stack.add(question.charAt(i));
            }
            else{
                if(question.charAt(i) == stack.peek()){ 
                    stack.add(question.charAt(i));       
                }
                else{
                    stack.pop();
                }    
            }

            answer = Math.max(answer, stack.size());
        }

        if (!stack.isEmpty()) {
            answer = -1;
        }

        System.out.println(answer);
    }
}

