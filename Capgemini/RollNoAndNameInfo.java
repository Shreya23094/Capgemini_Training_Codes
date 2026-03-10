import java.util.*;

public class RollNoAndNameInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your roll number: ");
        int rollno = sc.nextInt();
        System.out.println("Enter your name: ");
        String name = sc.next();
        System.out.println("your roll number is: " + rollno);
        System.out.println("your name is: " + name);
        sc.close();
    }
}
