package atm.login;

import atm.ATM;
import atm.SystemFacade;
import atm.cardDataBase;

import java.util.ArrayList;
import java.util.Scanner;

public class password extends ChainOfResponsibility {

    SystemFacade systemFacade = new SystemFacade();
    private ArrayList<cardDataBase> cardDataBases = new ArrayList<>();
    Scanner in = new Scanner(System.in);

    ATM atm = new ATM();

    @Override
    public void write(String num, String pass) {
        for(int i = 0; i < cardDataBases.size(); i++){
            if(cardDataBases.get(i).getCardNum().equals(num)){
                if(cardDataBases.get(i).getPassword().equals(pass)){
                    systemFacade.menu(num);
                    System.out.println("Right password");
                } else{
                    System.out.println("ERROR!");
                }
            }
        }
    }
}
