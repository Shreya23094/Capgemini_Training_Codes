/*
Stack task:

(())
((()))
()()
()))
*/

import java.util.*;

public class paranthesisStack {
    public static boolean isValidParentheses(String s){
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char c : chars){
            if(c == '('){
                stack.push(c);
            }
            else if(c == ')'){
                if(stack.isEmpty() || stack.pop() != '('){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string with parentheses: ");
        String input = sc.nextLine();
        if (isValidParentheses(input)) {
            System.out.println("The parentheses are valid.");
        } else {
            System.out.println("The parentheses are not valid.");
        }
        sc.close();
    }
}
