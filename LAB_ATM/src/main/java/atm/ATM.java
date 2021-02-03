package atm;

import java.util.ArrayList;
import java.util.Scanner;

public class ATM {
    private ArrayList<cardDataBase> cardDataBases = new ArrayList<>();
    Scanner in = new Scanner(System.in);

    public void addCardDataBase(cardDataBase cardDataBase){
        cardDataBases.add(cardDataBase);
    }

//    public void addBank(Bank bank){
//        banks.add(bank);
//    }
//
//    public void addBankCard(Bank bank, cardDataBase cardDataBase){
//        for(Bank bank1 : banks){
//            if(bank.getBankName().equals(bank1.getBankName())){
//                bank.addCardBank(cardDataBase);
//            }
//        }
//    }

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
