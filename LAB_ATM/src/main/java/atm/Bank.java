package atm;

import java.util.ArrayList;

public class Bank implements BankService{
    private String bankName;
    private ArrayList<cardDataBase> cardDataBases = new ArrayList<>();

    public Bank() {
    }

    public Bank(String bankName, ArrayList<cardDataBase> cardDataBases) {
        this.bankName = bankName;
        this.cardDataBases = cardDataBases;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public ArrayList<cardDataBase> getCardDataBases() {
        return cardDataBases;
    }

    public void setCardDataBases(ArrayList<cardDataBase> cardDataBases) {
        this.cardDataBases = cardDataBases;
    }

    public void addCardBank(cardDataBase cardDataBase){
        cardDataBases.add(cardDataBase);
    }

    @Override
    public void createUser() {

    }
}
