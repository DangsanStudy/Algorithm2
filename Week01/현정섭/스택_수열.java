package Week01.현정섭;
import java.io.*;
import java.util.*;

public class 스택_수열 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int now = 1;

        Stack<Integer> stack = new Stack<>();
        Stack<String> answer = new Stack<>();

        boolean pos = true;

		for(int i = 0; i < n; i++){
            int number = Integer.parseInt(br.readLine());

            while(now <= number){
                answer.add("+");
                stack.add(now);
                now ++;
            }

            if(stack.peek() == number){
                answer.add("-");
                stack.pop();
            }
            else{
                pos = false;
            }
            
        }

        if(pos){
            for (String value : answer) {
                System.out.println(value);
            }
        }
        else{
            System.out.println("NO");
        }

	}

}
