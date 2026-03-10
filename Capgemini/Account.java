class Bank {
    double balance;
    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
        System.out.println("Current Balance: " + balance);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient Balance");
        }
        System.out.println("Current Balance: " + balance);
    }
}

public class Account {
    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.deposit(5000);
        bank.withdraw(2000);
    }
}
