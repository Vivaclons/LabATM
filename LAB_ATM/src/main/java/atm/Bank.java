package atm;

import java.util.ArrayList;

public class Bank implements BankService{
    private ArrayList<cardDataBase> cardDataBases = new ArrayList<>();

    public Bank() {
    }

    public Bank(ArrayList<cardDataBase> cardDataBases) {
        this.cardDataBases = cardDataBases;
    }

    public ArrayList<cardDataBase> getCardDataBases() {
        return cardDataBases;
    }

    public void setCardDataBases(ArrayList<cardDataBase> cardDataBases) {
        this.cardDataBases = cardDataBases;
    }

    public cardDataBase cardInfo(String cardNum){
        for(cardDataBase cardDataBase: cardDataBases){
            if(cardNum.equals(cardDataBase.getCardNum())){
                return cardDataBase;
            }
        }
        return null;
    }

    @Override
    public void info(String cardNumber) {
        cardDataBase cardDataBase = cardInfo(cardNumber);
        System.out.println("Card number: " + cardDataBase.getCardNum());
        System.out.println("Balance: " + cardDataBase.getBalance());
    }

    @Override
    public void withdraw(int sum, String cardNumber) {
        cardDataBase cardDataBase = cardInfo(cardNumber);
        if(cardDataBase.getBalance() == 0 || cardDataBase.getBalance() < 0){
            System.out.println("ERROR!");
        }
        cardDataBase.setBalance(cardDataBase.getBalance() - sum);
        System.out.println("Success!");
    }

    @Override
    public void topUp(int sum, String cardNumber) {
        cardDataBase cardDataBase = cardInfo(cardNumber);
        cardDataBase.setBalance(cardDataBase.getBalance() - sum);
        System.out.println("Success!");
    }

    @Override
    public boolean check(String username, String pinCode) {
        for (cardDataBase cardDataBase : cardDataBases) {
            if (username.equals(cardDataBase.getCardNum()) && pinCode.equals(cardDataBase.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
