import java.util.ArrayList;

public class Account extends Customer {

    private String accountType;
    private ArrayList<String> transactionLogs;
    private int balance;

    /**
     * Constructor
     * @param accountType - type of account (checking/credit)
     * @param initialBalance - initial balance of this account
     */
    public Account (String accountType, int initialBalance) {
        super();
        this.accountType = accountType;
        this.balance = initialBalance;
        transactionLogs = new ArrayList<>();
        transactionLogs.add("Started with $" + initialBalance);
    }

    /**
     * gets account type (checking/credit)
     * @return type of account
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * gets balance of account
     * @return current balance
     */
    public int getBalance() {
        return this.balance;
    }

    /**
     * deposit money into balance
     * @param deposit - amount to deposit
     */
    public void deposit(int deposit) {
        this.balance += deposit;
        transactionLogs.add("Deposited $" + deposit +
                " -> Balance: $" + getBalance());
    }

    /**
     * withdraw money from balance
     * @param withdraw - amount to withdraw
     */
    public void withdraw(int withdraw) {
        this.balance -= withdraw;
        transactionLogs.add("Withdrew $" + withdraw +
                " -> Balance: $" + getBalance());
    }

    /**
     * Prints transaction history
     */
    public void printTransaction () {
        for (String transactionLog : transactionLogs) {
            System.out.println(transactionLog.toString());
        }
    }
}
