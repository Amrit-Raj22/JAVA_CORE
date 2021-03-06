import java.util.Scanner;

class BankAccount {
    protected int accountNo;
    protected String name = "hi";
    protected double accountBalance;

    BankAccount() {
        accountNo = 9590;
        name = "Amrit";
        accountBalance = 100;
    }

    BankAccount(int accountNo, String name, double accountBalance) {
        this.accountNo = accountNo;
        this.name = name;
        this.accountBalance = accountBalance;
    }

    void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    void setName(String name) {
        this.name = name;
    }

    void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    String getName() {
        return this.name;
    }

    double getAccountBalance() {
        return accountBalance;
    }

    int getAccountNo() {
        return accountNo;
    }

    public String toString() {
        System.out.println("Name:" + name + " " + "AccN1:" + accountNo + " "
                + "AccBalance:" + accountBalance);
        return "BankAccount";
    }

    void getYearlyTax() {
        //////////
    }

    void getYearlyInHandSalary() {
        //////////////
    }

    public void copy(BankAccount account) {
        BankAccount newAccount = new BankAccount(account.getAccountNo(), account.getName(),
                account.getAccountBalance());
        System.out.println(name);
    }

}

class SavingAccount extends BankAccount {
    double rateOfInterest = 4.0;

    SavingAccount() {
        super();

    }

    SavingAccount(int accountNo, String name, double accountBalance) {
        super(accountNo, name, accountBalance);
        // this.rateOfInterest = rateOfInterest;

    }

    void setRateOfInterest(double rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    double getYearlyInterest() {
        return (accountBalance * rateOfInterest) / 100;
    }

    double getComputedInterest(int year) {
        return (accountBalance * rateOfInterest * year) / 100;
    }

    @Override
    public String toString() {
        super.toString();
        System.out.println("rate of interest:" + rateOfInterest);
        return "Saving";
    }

}

class CurrentAccount extends BankAccount {
    double avgDailyTransactions = 100.0;

    CurrentAccount() {
        super();
    }

    CurrentAccount(int accountNo, String name, double accountBalance) {
        super(accountNo, name, accountBalance);
        // this.avgDailyTransactions = avgDailyTransactions;

    }

    double getYearlyTransactions() {
        return this.avgDailyTransactions * 365;
    }

    double getTotalTransactionAmount(int days) {
        return avgDailyTransactions * days;
    }

    void setAvgDailyTransaction(double avgDailyTransactions) {
        this.avgDailyTransactions = avgDailyTransactions;
    }

    @Override
    public String toString() {
        super.toString();
        System.out.println("avgDailyTransactions:" + avgDailyTransactions);
        return "Current";
    }

}

public class Accounts {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        SavingAccount saveAccount = new SavingAccount();
        CurrentAccount curr1 = new CurrentAccount();
        CurrentAccount curr2 = new CurrentAccount(100, "Raj", 15.00);
        BankAccount exception = new copy(account);

        // System.out.println(saveAccount.getYearlyInterest());
        // System.out.println(curr1.getYearlyTransactions());
        // System.out.println(curr2.getYearlyTransactions());
        // System.out.println(curr1.getAccountNo() + "\told");
        // curr2.setAccountNo(00);
        // System.out.println(curr2.getAccountNo());
        // System.out.println(curr1.toString());
        // System.out.println(curr2.toString());
        // System.out.println(saveAccount.toString());

        BankAccount salaryAccount = new BankAccount() {
            double salaryMonthly = 10000.0;
            double pfDeduction = 250.0;
            double incomeTaxRate = 4.5;

            @Override
            void getYearlyTax() {
                System.out.println("Tax:" + salaryMonthly * 12 * incomeTaxRate / 100);
            }

            @Override
            void getYearlyInHandSalary() {
                System.out.println("InHand:"
                        + ((salaryMonthly * 12) - (pfDeduction * 12) - (salaryMonthly * 12 * incomeTaxRate / 100)));
            }

        };
        // salaryAccount.getYearlyInHandSalary();
        // salaryAccount.getYearlyTax();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter N:");
        int n = scanner.nextInt();
        BankAccount[] bankArr = new BankAccount[n * 2];
        for (int i = 0; i < 2 * n; i += 2) {
            bankArr[i] = new SavingAccount(i, "new bank" + (i), 1000);
            bankArr[i + 1] = new CurrentAccount(i + 1, "new current" + (i), 1000);
            // bankArr[i+2]= new salaryAccount(i+2,"Salary"+(i+2),1000);
        }
        scanner.close();
        System.out.println(bankArr[3].getName());

    }

}
