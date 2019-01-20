public class CheckingAccount extends BankAccount {
    private int limit;

    public CheckingAccount(String accountNum, int balance, int limit){
        super(accountNum, balance);
        this.limit = limit;
    }
}
