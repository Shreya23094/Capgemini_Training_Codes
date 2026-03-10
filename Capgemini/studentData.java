import java.util.ArrayList;
import java.util.Scanner;

public class studentData {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter your student names :");
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            names.add(name);
        }
        System.out.println("Student Names: " + names);

        System.out.print("Enter name to search: ");
        String searchName = sc.next();
        if (names.contains(searchName)) {
            System.out.println(searchName + " is found in the list.");
        } else {
            System.out.println(searchName + " is not found in the list.");
        }
        names.remove("Bob");
        
        System.out.println("Updated Student Names: " + names);
            System.out.print("Enter name to add: ");
            String addName = sc.next();
            names.add(addName);
            System.out.println("Names after addition: " + names);

            System.out.print("Enter index to update: ");
            int updateIndex = sc.nextInt();
            if (updateIndex >= 0 && updateIndex < names.size()) {
                System.out.print("Enter new name: ");
                String newName = sc.next();
                names.set(updateIndex, newName);
                System.out.println("Names after update: " + names);
            } else {
                System.out.println("Invalid index.");
            }

            System.out.print("Enter name to remove: ");
            String removeName = sc.next();
            if (names.remove(removeName)) {
                System.out.println(removeName + " removed. Names now: " + names);
            } else {
                System.out.println(removeName + " not found in the list.");
            }
            sc.close();
    }
}
