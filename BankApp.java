class BankAccount {
    String accHolderName;
    double balance;
    static final double minimumBalance = 500;
    double annualInterest;

    public BankAccount() {
        accHolderName = null;
        balance = 0;
        annualInterest = 0;
    }

    public BankAccount(String name, double newBalance) {
        accHolderName = name;
        balance = newBalance;
        annualInterest = 0;
    }

    public void checkDeposit(double initialDeposit) {
        if (initialDeposit < minimumBalance) {
            System.out.println("Minimum balance requirement: " + minimumBalance);
        }
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public double withdraw(double amount) {
        if (balance < amount + minimumBalance) {
            System.out.println("Insufficient balance.");
            return 0;
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            return amount;
        }
    }

    public void checkBalance() {
        System.out.println("Holder Name: " + accHolderName);
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(String name, double newBalance) {
        super(name, newBalance);
    }

   
    public void checkBalance() {
        System.out.println("This is a savings account.");
        super.checkBalance();
    }
}

public class BankApp {
    public static void main(String[] args) {
        SavingsAccount acc1 = new SavingsAccount("Smith", 100);
        SavingsAccount acc2 = new SavingsAccount("John", 2000);

     
        acc1.deposit(2000);
        System.out.println("Acc 1:");
        acc1.checkBalance();

       
        double withdrawnAmount = acc2.withdraw(400);
        if (withdrawnAmount > 0) {
            System.out.println("Withdrawn  acc 2: " + withdrawnAmount);
        }
        System.out.println("Acc 2:");
        acc2.checkBalance();
    }
}
