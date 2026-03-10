import java.util.Scanner;

class ATM {
    private int balance = 0;
    private int PIN;
    Scanner sc = new Scanner(System.in);

    ATM(int pin) {
        this.PIN = pin;
    }

    public void checkBalance(int pinCheck) {
        if (PIN == pinCheck) {
            System.out.println("Balance: " + balance);
        } else {
            System.out.println("Invalid PIN");
        }
    }

    public void deposit(int pinCheck, int amount) {
        if (PIN == pinCheck) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposited. Balance: " + balance);
            } else {
                System.out.println("Invalid amount");
            }
        } else {
            System.out.println("Invalid PIN");
        }
    }

    public void withdrawal(int pinCheck, int amount) {
        if (PIN == pinCheck) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawal successful. Balance: " + balance);
            } else {
                System.out.println("Insufficient balance");
            }
        } else {
            System.out.println("Invalid PIN");
        }
    }

    public void changePin(int pinCheck) {
        if (PIN == pinCheck) {
            System.out.print("Enter new PIN: ");
            PIN = sc.nextInt();
            System.out.println("PIN changed successfully");
        } else {
            System.out.println("Invalid PIN");
        }
    }

    public void quickWithdrawal(int pinCheck) {
        if (PIN == pinCheck) {
            System.out.println(
                "1. 100\n2. 500\n3. 1000\n4. 5000"
            );
            int select = sc.nextInt();
            int amount = 0;

            switch (select) {
                case 1: amount = 100; break;
                case 2: amount = 500; break;
                case 3: amount = 1000; break;
                case 4: amount = 5000; break;
                default:
                    System.out.println("Invalid option");
                    return;
            }

            if (amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawal successful. Balance: " + balance);
            } else {
                System.out.println("Insufficient balance");
            }
        } else {
            System.out.println("Invalid PIN");
        }
    }
}

public class ATMMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Set your PIN: ");
        int pin = sc.nextInt();
        ATM account = new ATM(pin);

        boolean flag = true;

        while (flag) {
            System.out.println(
                "\n1. Withdraw\n2. Deposit\n3. Check Balance\n4. Change PIN\n5. Quick Withdraw\n6. Exit"
            );
            int choice = sc.nextInt();

            if (choice == 6) {
                System.out.println("Thank you for using our services.");
                flag = false;
                break;
            }

            System.out.print("Enter PIN: ");
            int pinCheck = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount: ");
                    account.withdrawal(pinCheck, sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter amount: ");
                    account.deposit(pinCheck, sc.nextInt());
                    break;
                case 3:
                    account.checkBalance(pinCheck);
                    break;
                case 4:
                    account.changePin(pinCheck);
                    break;
                case 5:
                    account.quickWithdrawal(pinCheck);
                    break;
                
                default:
                    System.out.println("Invalid choice");
            }
        }

        sc.close();
    }
}
