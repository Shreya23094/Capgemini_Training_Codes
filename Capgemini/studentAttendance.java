/* 
-----student attendance system-----

registrations
login
study materials - pdf is being opened or not
show marks
*/

import java.util.*;

public class studentAttendance {
    public static void main(String[] args) {
        boolean loggedIn = false;
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        Set<String> studentEmailID = new HashSet<>();
        Map<String, Map<String, Integer>> studentMarks = new HashMap<>(); // Email_id -> {subject -> marks}
        ArrayList<String> studyMaterials = new ArrayList<>(Arrays.asList("Math.pdf", "Science.pdf", "History.pdf"));
        String loggedInEmail = "";
        while (flag) {
            String email;
            System.out.println("\nWelcome to the Student Attendance System");
            System.out.println("1. Register");
            System.out.println("2. Login");
            if(loggedIn) {
                System.out.println("3. Study Materials");
                System.out.println("4. Show Marks");
                System.out.println("5. Add marks for student");
                System.out.println("6. Logout");
            }
            else{
                System.out.println("3. Exit");
            }
            int choice = sc.nextInt();
            sc.nextLine(); 
            switch (choice) {
                case 1:
                    System.out.println("\nRegistering new student...");
                    System.out.println("\nEnter your email: ");
                    email = sc.nextLine();
                    if(studentEmailID.contains(email)){
                        System.out.println("This email already exists, you can login using this mail.");
                    }
                    else{
                        studentEmailID.add(email);
                        System.out.println("\nRegistration successful. Your ID is: " + email);
                        System.out.println("\nNow you can login using your ID.");
                    }
                    break;
                case 2:
                        System.out.println("\nLogging in...");
                        System.out.println("\nEnter your Email ID: ");
                        email = sc.nextLine();
                        if (studentEmailID.contains(email)) {
                            System.out.println("\nWelcome, " + email + "!");
                            loggedIn = true;
                            studentMarks.putIfAbsent(email, new HashMap<>());
                            loggedInEmail = email;
                        } else {
                            System.out.println("\nInvalid ID. Please register first.");
                        }
                        break;
                case 3:
                    if (loggedIn) {
                        System.out.println("\nOpening study materials...");
                        for (String material : studyMaterials) {
                            System.out.println("Opening: " + material);
                        }
                    } else {
                        flag = false;
                    }
                    break;
                case 4:
                    if (loggedIn) {
                        System.out.println("\nYour marks:");
                        Map<String, Integer> marks = studentMarks.get(loggedInEmail);
                        if (marks.isEmpty()) {
                            System.out.println("\nNo marks available.");
                        } else {
                            for (Map.Entry<String, Integer> entry : marks.entrySet()) {
                                System.out.println(entry.getKey() + ": " + entry.getValue());
                            }
                        }
                    } else {
                        System.out.println("\nPlease login first.");
                    }
                    break;
                case 5 :
                    if (loggedIn) {
                        System.out.println("\nEnter student Email ID to add marks: ");
                        String studentId = sc.nextLine();
                        if (studentEmailID.contains(studentId)) {
                            boolean addingMarks = true;
                            while(addingMarks){
                                System.out.println("\nEnter subject: ");
                                String subject = sc.nextLine();
                                System.out.println("\nEnter marks: ");
                                int marks = sc.nextInt();
                                sc.nextLine(); 
                                studentMarks.putIfAbsent(studentId, new HashMap<>());
                                studentMarks.get(studentId).put(subject, marks);
                                System.out.println("\nMarks added successfully. Do you want to add more marks?\nType 1 for yes\nType 2 for no");
                                int choose = sc.nextInt();
                                sc.nextLine(); 
                                if(choose==2){
                                    addingMarks = false;
                                }
                            }
                        } else {
                            System.out.println("\nInvalid student ID.");
                        }
                    } else {
                        System.out.println("\nPlease login first.");
                    }
                    break;
                case 6:
                    if (loggedIn) {
                        System.out.println("\nLogging out...");
                        loggedIn = false;
                    } else {
                        System.out.println("\nYou are not logged in.");
                    }
                    break;
                default:
                    break;
            }
        }
        sc.close();
    }
}