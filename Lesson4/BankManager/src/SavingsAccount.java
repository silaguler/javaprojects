import java.util.Date;

public class SavingsAccount extends BankAccount {
    private double transfers;

    public SavingsAccount(String accountNum, int balance, double transfers){
        super(accountNum, balance);
        this.transfers = transfers;
    }
}
