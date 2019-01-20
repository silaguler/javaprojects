public class BankAccount {
    private String accountNum;
    private int balance;
    BankAccount(String accountNum, int balance){
        this.accountNum = accountNum;
        this.balance = balance;
    }
    public String getAccountNum(){
        return this.accountNum;
    }
    public void setAccountNum(String accountNum){
        this.accountNum = accountNum;
    }
    public int getBalance(){
        return this.balance;
    }
    public void setBalance(int balance){
        this.balance = balance;
    }
}
