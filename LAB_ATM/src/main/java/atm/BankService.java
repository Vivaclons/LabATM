package atm;

public interface BankService {
    void info(String cardNumber);
    void withdraw(int sum, String cardNumber);
    void topUp(int sum, String cardNumber);
    boolean check(String username, String pinCode);
}
