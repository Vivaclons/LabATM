package atm;

public interface BankService {
    cardDataBase info(String cardNumber);
    cardDataBase withdraw(int sum, String cardNumber);
    cardDataBase topUp(int sum, String cardNumber);
    boolean check(String username, String pinCode);
}
