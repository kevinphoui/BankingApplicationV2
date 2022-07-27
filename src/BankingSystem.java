import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class BankingSystem {

    public static void main(String[] args) {
        ArrayList<Customer> customerList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input = "";

        System.out.println("Welcome to the Banking System Application");
        System.out.println("----------------------------");

        while (!input.toLowerCase().equals("4")) {
            System.out.println("\nWhat will you like to do?");
            System.out.println("----------------------------");
            System.out.println("1) Create a new Customer Account");
            System.out.println("2) Create a new Checking or Credit Account");
            System.out.println("3) Access a Checking or Credit account to deposit/withdraw/view transaction");
            System.out.println("4) Exit Application");

            int accountNumber;
            int customerID;
            int initialDeposit;
            input = scanner.next();
            switch (input) {
                // create customer account
                case "1" -> {
                    System.out.println("What is your name?");
                    String name = scanner.next();
                    customerList.add(new Customer(name, customerList.size()));
                    int newCustomerID = customerList.size() - 1;
                    System.out.println("Welcome " + customerList.get(newCustomerID).getName()
                            + ". Your ID is: " + newCustomerID);
                }

                // create checking or credit account
                case "2" -> {
                    // if tries to create a checking account with no existing customer account
                    if (customerList.size() == 0) {
                        System.out.println("Error: No Customer Accounts Exist");
                        break;
                    }

                    // access customer account
                    customerID = -1;
                    System.out.println("Which customer to access?");
                    for (int i = 0; i < customerList.size(); i++) {
                        System.out.println(i + ") " + customerList.get(i).getName() + " id: " + customerList.get(i).getId());
                    }
                    customerID = scanner.nextInt();
                    // check if valid input
                    while (customerID >= customerList.size() || customerID < 0) {
                        System.out.println("Customer does not exist, please try again");
                        customerID = scanner.nextInt();
                    }
                    System.out.println("Customer Account found. Welcome " + customerList.get(customerID).getName());

                    // ask if want to create a checking or credit account
                    System.out.println("Choose an account type to create \n1) Checking\n2) Credit");
                    int accountTypeCheck = -1;
                    accountTypeCheck = scanner.nextInt();
                    // check if valid input
                    while (accountTypeCheck > 2 || accountTypeCheck < 1) {
                        System.out.println("Wrong input, please try again");
                        accountTypeCheck = scanner.nextInt();
                    }
                    // assign account type - checking or credit
                    String accountType;
                    if (accountTypeCheck == 1) {
                        accountType = "Checking";
                    } else {
                        accountType = "Credit";
                    }

                    // ask how much to deposit
                    System.out.println("How much will you like to initially deposit");
                    initialDeposit = scanner.nextInt();

                    // if deposit is not a positive number
                    while (initialDeposit < 0) {
                        System.out.println("Invalid deposit amount");
                        initialDeposit = scanner.nextInt();
                        break;
                    }

                    // create new checking account and add it
                    customerList.get(customerID).accounts.add(new Account(accountType, initialDeposit));
                }

                // Access checking/credit account to withdraw, deposit, or view transactions history
                case "3" -> {
                    // if no customers
                    if (customerList.size() == 0) {
                        System.out.println("Error: No Customer Accounts Exist");
                        break;
                    }

                    // access customer account
                    customerID = -1;
                    System.out.println("Which Customer to access?");
                    for (int i = 0; i < customerList.size(); i++) {
                        System.out.println(i + ") " + customerList.get(i).getName() + " id: " + customerList.get(i).getId());
                    }
                    customerID = scanner.nextInt();
                    // check if valid input
                    while (customerID > customerList.size() || customerID < 0) {
                        System.out.println("Customer does not exist, please try again");
                        customerID = scanner.nextInt();
                    }
                    System.out.println("Customer Account found. Welcome " + customerList.get(customerID).getName());

                    // access account type
                    System.out.println("Which account do you want to access?");
                    ArrayList<Account> userAccounts = customerList.get(customerID).accounts;
                    if (userAccounts.size() == 0) {
                        System.out.println("No accounts exist for this customer.");
                        break;
                    }
                    for (int i = 0; i < userAccounts.size(); i++) {
                        System.out.println(i + ") " + userAccounts.get(i).getAccountType() + " with $" + userAccounts.get(i).getBalance());
                    }
                    accountNumber = scanner.nextInt();
                    while (accountNumber >= userAccounts.size() || accountNumber < 0) {
                        System.out.println("Account does not exist, please try again");
                        accountNumber = scanner.nextInt();
                    }
                    Account currentAccount = userAccounts.get(accountNumber);
                    System.out.println(currentAccount.getAccountType() + " chosen.");

                    int accountAction = -1;
                    System.out.println("""
                            What will you like to do?
                            1) Deposit
                            2) Withdraw
                            3) View Transaction History""");
                    accountAction = scanner.nextInt();
                    while (accountAction > 3 || accountAction < 1) {
                        System.out.println("Error: Invalid input. Please try again.");
                        accountAction = scanner.nextInt();
                    }

                    switch (accountAction) {
                        // Deposit
                        case 1 -> {
                            System.out.println("How much would you like to deposit?");
                            int deposit = scanner.nextInt();
                            while (deposit <= 0){
                                System.out.println("Error: Invalid input. Try again");
                                deposit = scanner.nextInt();
                            }
                            System.out.println("Withdrawing $" + deposit);
                            currentAccount.deposit(deposit);
                            System.out.println("New balance: $" + currentAccount.getBalance());
                        }
                        // Withdraw
                        case 2 -> {
                            System.out.println("How much would you like to withdraw");
                            int withdraw = scanner.nextInt();
                            while (withdraw <= 0){
                                System.out.println("Error: Invalid input. Try again");
                                withdraw = scanner.nextInt();
                            }
                            System.out.println("Withdrawing $" + withdraw);
                            currentAccount.withdraw(withdraw);
                            System.out.println("New balance: $" + currentAccount.getBalance());
                        }
                        // Transaction History
                        case 3 -> {
                            System.out.println("Viewing Transaction History");
                            currentAccount.printTransaction();
                        }
                    }


                }

                // deposit money into checking/credit account
                case "4" -> System.out.println("Ending Application. Thank you.");
                default -> System.out.println("Error: Invalid Input!");
            }
        }
    }
}
