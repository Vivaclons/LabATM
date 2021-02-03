package atm;

public class cardDataBase {
    private String cardNum;
    private String password;
    private int balance;

    public cardDataBase(){

    }

    public cardDataBase(String cardNum, String password, int balance) {
        this.cardNum = cardNum;
        this.password = password;
        this.balance = balance;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
