import java.util.HashSet;
import java.util.Scanner;

public class TicketSystem {

    static Scanner sc = new Scanner(System.in);
    static HashSet<Ticket> allTickets = new HashSet<>();
    static long counter = 1;

    static class Ticket {
        long tktId;
        String name;
        String description;
        String assignedTo = "Not Assigned";
        int priority = 0;
        String status = "Ticket Created";
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nLogin as:");
            System.out.println("1. User");
            System.out.println("2. Admin");
            System.out.println("3. Exit");
            System.out.print("Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> userMenu();
                case 2 -> adminMenu();
                case 3 -> {
                    System.out.println("System exited.");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void userMenu() {
        while (true) {
            System.out.println("\n User Menu : ");
            System.out.println("1. Raise New Ticket");
            System.out.println("2. Check Ticket Status");
            System.out.println("3. Back");
            System.out.print("Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> createTicket();
                case 2 -> checkTicketStatus();
                case 3 -> { return; }
                default -> System.out.println("Invalid option!");
            }
        }
    }

    static void createTicket() {
        Ticket t = new Ticket();

        System.out.print("Enter name: ");
        t.name = sc.nextLine();

        System.out.print("Enter description: ");
        t.description = sc.nextLine();

        t.tktId = counter++;
        allTickets.add(t);

        System.out.println("Ticket created successfully!");
        System.out.println("Ticket ID: " + t.tktId);
    }

    static void checkTicketStatus() {
        System.out.print("Enter Ticket ID: ");
        long id = sc.nextLong();

        for (Ticket t : allTickets) {
            if (t.tktId == id) {
                System.out.println("Status     : " + t.status);
                System.out.println("Assigned To: " + t.assignedTo);
                System.out.println("Priority   : " + t.priority);
                return;
            }
        }
        System.out.println("Ticket not found!");
    }

    static void adminMenu() {
        while (true) {
            System.out.println("\nAdmin Menu : ");
            System.out.println("1. View All Tickets");
            System.out.println("2. Assign Agent & Set Priority");
            System.out.println("3. Back");
            System.out.print("Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> viewAllTickets();
                case 2 -> assignTicket();
                case 3 -> { return; }
                default -> System.out.println("Invalid option!");
            }
        }
    }

    static void viewAllTickets() {
        if (allTickets.isEmpty()) {
            System.out.println("No tickets available.");
            return;
        }

        System.out.println("\nID   Name   Status   Assigned To   Priority");
        for (Ticket t : allTickets) {
            System.out.println(
                t.tktId + "   " +
                t.name + "   " +
                t.status + "   " +
                t.assignedTo + "   " +
                t.priority
            );
        }
    }

    static void assignTicket() {
        System.out.print("Enter Ticket ID: ");
        long id = sc.nextLong();
        sc.nextLine();

        for (Ticket t : allTickets) {
            if (t.tktId == id) {
                System.out.print("Enter agent name: ");
                t.assignedTo = sc.nextLine();

                System.out.print("Enter priority: ");
                t.priority = sc.nextInt();
                sc.nextLine();

                t.status = "Agent Assigned";
                System.out.println("Ticket updated successfully!");
                return;
            }
        }
        System.out.println("Ticket not found!");
    }
}
