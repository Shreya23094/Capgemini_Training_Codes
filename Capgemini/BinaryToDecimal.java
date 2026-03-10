import java.util.Scanner;
import java.util.Stack;

public class BinaryToDecimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a decimal number: ");
        int decimalValue = sc.nextInt();
        String binaryValue = decimalToBinary(decimalValue);
        System.out.println("Decimal: " + decimalValue + " -> Binary: " + binaryValue);
        sc.close();
    }
    public static String decimalToBinary(int decimalValue){
        if (decimalValue == 0) return "0";
        StringBuilder binaryValue = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        while(decimalValue > 0){
            int remainder = decimalValue % 2;
            stack.push(remainder);
            decimalValue = decimalValue / 2;
        }
        while(!stack.isEmpty()){
            binaryValue.append(stack.pop());
        }
        return binaryValue.toString();
    }
}
