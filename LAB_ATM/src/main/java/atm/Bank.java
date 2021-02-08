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
    public cardDataBase info(String cardNumber) {
        for(cardDataBase cardDataBase: cardDataBases){
            if(cardNumber.equals(cardDataBase.getCardNum())){
                System.out.println("Card number: " + cardDataBase.getCardNum());
                System.out.println("Card balance: " + cardDataBase.getBalance());
                return cardDataBase;
            }
        }
        return null;
    }

    @Override
    public cardDataBase withdraw(int sum, String cardNumber) {
        for(cardDataBase cardDataBase: cardDataBases){
            if(cardNumber.equals(cardDataBase.getCardNum())){
                if(cardDataBase.getBalance() == 0 || cardDataBase.getBalance() < 0){
                    System.out.println("ERROR!");
                }
                cardDataBase.setBalance(cardDataBase.getBalance() - sum);
                System.out.println("Success!");
                return cardDataBase;
            }
        }
        return null;
    }

    @Override
    public cardDataBase topUp(int sum, String cardNumber) {
        for(cardDataBase cardDataBase: cardDataBases){
            if(cardNumber.equals(cardDataBase.getCardNum())){
                cardDataBase.setBalance(cardDataBase.getBalance() + sum);
                System.out.println("Success!");
                return cardDataBase;
            }
        }
        return null;
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
