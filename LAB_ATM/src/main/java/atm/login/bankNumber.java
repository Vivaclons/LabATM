package atm.login;

import atm.ATM;
import atm.cardDataBase;

import java.util.ArrayList;
import java.util.Scanner;

public class bankNumber extends ChainOfResponsibility{
    Scanner in = new Scanner(System.in);
    private ArrayList<cardDataBase> cardDataBases = new ArrayList<>();
    ATM atm = new ATM();


    @Override
    public void write(String num, String pass) {
        System.out.println(atm.getCardDataBases().size());
        password password = new password();

        for (int i = 0; i < cardDataBases.size(); i++){
            System.out.println(cardDataBases.get(i).getCardNum());
            if(cardDataBases.get(i).getCardNum().equals(num)){
                System.out.println("Right number");
            }
        }

    }
}
