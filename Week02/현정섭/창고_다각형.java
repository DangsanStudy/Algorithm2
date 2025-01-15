package Week02.현정섭;
import java.io.*;
import java.util.*;

public class 창고_다각형 {

	public static void main(String[] args) throws Exception {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(bf.readLine());

        int[] array = new int[1001];

        int maxHeight = 0;

        int maxIndex = 0;

        int start = 0;

        int end = 0;

        int answer = 0;

        for(int i = 0; i < n; i++){

            String[] input = bf.readLine().split(" ");

            int index = Integer.parseInt(input[0]);
            
            int height = Integer.parseInt(input[1]);
            
            array[index] = height;

            if(height > maxHeight){
                maxIndex = index;
                maxHeight = height;
            }

            //System.out.println(maxHeight);

            end = Math.max(index, maxIndex);
        }

        
        //System.out.println(Arrays.toString(array));

        //System.out.println(maxHeight);

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < maxIndex - 1; i++){
            if(stack.isEmpty()){
                stack.add(array[i]);
            }
            else{
                if(stack.peek() > array[i]){
                    stack.add(stack.peek());
                }
                else{
                    stack.add(array[i]);
                }
            }
        }

        Stack<Integer> stack2 = new Stack<>();

        for(int i = end; i < maxIndex; i--){
            if(stack2.isEmpty()){
                stack2.add(array[i]);
            }
            else{
                if(stack2.peek() > array[i]){
                    stack2.add(stack2.peek());
                }
                else{
                    stack2.add(array[i]);
                }
            }
        }

        while(!stack.isEmpty()){
            System.out.println(stack.peek());
            answer += stack.pop();
        }

        while(!stack2.isEmpty()){
            System.out.println(stack2.peek());
            answer += stack2.pop();
        }

        System.out.println(answer);
    }
}

