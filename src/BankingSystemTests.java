public class BankingSystemTests {

    public static void main(String[] args) {
        Customer customerTest1 = new Customer("kevin", 0);
        Customer customerTest2 = new Customer("kev", 1);
        Customer customerTest3 = new Customer("dawg", 2);
        Customer customerTest4 = new Customer("jenny", 3);
        Customer customerTest5 = new Customer("thomas", 4);

        Account accountTest1 = new Account("Credit", 2);
        Account accountTest2 = new Account("Checking", 0);
        Account accountTest3 = new Account("Credit", 50000);
        Account accountTest4 = new Account("Checking", 0);
        Account accountTest5 = new Account("Credit", 1000000000);

        customerTest1.accounts.add(accountTest1);
        customerTest1.accounts.add(accountTest2);
        customerTest1.accounts.add(accountTest3);
        customerTest4.accounts.add(accountTest4);
        customerTest5.accounts.add(accountTest5);

        BankingSystem test = new BankingSystem();
    }
}
