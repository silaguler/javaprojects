import java.time.LocalDate;

public class COD extends BankAccount {
    private LocalDate expiryDate;
    public COD(String accountNum, int balance, LocalDate expiryDate){
        super(accountNum, balance);
        this.expiryDate = expiryDate;
    }

}
