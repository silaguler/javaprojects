import java.time.LocalDate;

public class BankManager {

    public static void main(String[] Args){
        CheckingAccount ca = new CheckingAccount("123", 10, 1000);
        SavingsAccount sa = new SavingsAccount("124", 10, 500.5);
        COD cod = new COD("125", 10, LocalDate.of(2018, 12, 10));
    }

}
