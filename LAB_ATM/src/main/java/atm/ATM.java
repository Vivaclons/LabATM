package atm;

import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
    private ArrayList<cardDataBase> cardDataBases = new ArrayList<>();
    Scanner in = new Scanner(System.in);

    public ArrayList<cardDataBase> getCardDataBases() {
        return cardDataBases;
    }

    public void setCardDataBases(ArrayList<cardDataBase> cardDataBases) {
        this.cardDataBases = cardDataBases;
    }

    public void add(){
        cardDataBase cardDataBase1 = new cardDataBase("1234", "1234", 100000);
        cardDataBase cardDataBase2 = new cardDataBase("5678", "1234", 100000);
        cardDataBase cardDataBase3 = new cardDataBase("9012", "1234", 100000);

        cardDataBases.add(cardDataBase1);
        cardDataBases.add(cardDataBase2);
        cardDataBases.add(cardDataBase3);
    }

    public void withDraw(String num){

        System.out.println("Enter sum: ");
        int m = in.nextInt();

        for(int i = 0; i < cardDataBases.size(); i++){
            if(cardDataBases.get(i).getCardNum().equals(num)){
                cardDataBases.get(i).setBalance(cardDataBases.get(i).getBalance() - m);
                System.out.println("Success: ");
                System.out.println("Now you have: " + cardDataBases.get(i).getBalance());
            }
        }
    }

    public void topUp(String num){

        System.out.println("Enter sum: ");
        int m = in.nextInt();

        for(int i = 0; i < cardDataBases.size(); i++){
            if(cardDataBases.get(i).getCardNum().equals(num)){
                cardDataBases.get(i).setBalance(cardDataBases.get(i).getBalance() + m);
                System.out.println("Success: ");
                System.out.println("Now you have: " + cardDataBases.get(i).getBalance());
            }
        }
    }

    public void showInf(String num){
        for(int i = 0; i < cardDataBases.size(); i++){
            if(cardDataBases.get(i).getCardNum().equals(num)){
                System.out.println("Credit card number: " + cardDataBases.get(i).getCardNum());
                System.out.println("Balance: " + cardDataBases.get(i).getBalance());
            }
        }
//        for (int i = 0; i < banks.size(); i++){
//            System.out.print(i + 1 + ")");
//            System.out.println("User Name: " + banks.get(i).getBankName());
//            System.out.println("User Balance: " + banks.get(i).getCardDataBases());
//        }
    }
}
