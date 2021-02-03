package atm;

import atm.login.ChainOfResponsibility;

import java.util.Scanner;

public class SystemFacade extends ChainOfResponsibility {

    ATM atm = new ATM();

    public void menu(String num){

        Scanner in = new Scanner(System.in);

        while(true){
            System.out.println("1 - Information about credit card");
            System.out.println("2 - Withdraw");
            System.out.println("3 - Top up");
            System.out.println("0-exit");

            String choice = in.next();

            if(choice.equals("1")){
                System.out.println("Information about credit card: ");
                atm.showInf(num);
            } else if(choice.equals("2")){
                System.out.println("Withdraw: ");
                atm.withDraw(num);
            } else if(choice.equals("3")){
                System.out.println("Top up: ");
                atm.topUp(num);
            } else{
                System.exit(0);
            }
        }
    }

    @Override
    public void write(String num, String pass) {
    }
}
