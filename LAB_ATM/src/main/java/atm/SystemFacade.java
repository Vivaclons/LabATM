package atm;

import java.util.Scanner;

public class SystemFacade {

    private cardDataBase card;
    private BankService bankService;


    public SystemFacade(BankService bankService) {
        this.bankService = bankService;
    }

    public void menu(){
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome:");
        while(true){
            System.out.println("Enter login:");
            String username = in.next();
            System.out.println("Enter password:");
            String pass = in.next();
            if(bankService.check(username, pass)){
                card = ((Bank) bankService).cardInfo(username);
                break;
            }
        }

        while(true){
            System.out.println("1 - Information about credit card");
            System.out.println("2 - Withdraw");
            System.out.println("3 - Top up");
            System.out.println("0-exit");
            Bank bank = new Bank();
            String choice = in.next();

            if(choice.equals("1")){
                System.out.println("Information about credit card: ");
                bank.info(card.getCardNum());
            } else if(choice.equals("2")){
                System.out.println("Withdraw: ");
                System.out.println("Sum: ");
                int sum = in.nextInt();
                bank.withdraw(sum, card.getCardNum());
            } else if(choice.equals("3")){
                System.out.println("Top up: ");
                System.out.println("Sum: ");
                int sum = in.nextInt();
                bank.topUp(sum, card.getCardNum());
            } else{
                System.exit(0);
            }

        }
    }

//    public void menu(String num){
//
//        Scanner in = new Scanner(System.in);
//
//        while(true){
//            System.out.println("1 - Information about credit card");
//            System.out.println("2 - Withdraw");
//            System.out.println("3 - Top up");
//            System.out.println("0-exit");
//
//            String choice = in.next();
//
//            if(choice.equals("1")){
//                System.out.println("Information about credit card: ");
//                atm.showInf(num);
//            } else if(choice.equals("2")){
//                System.out.println("Withdraw: ");
//                atm.withDraw(num);
//            } else if(choice.equals("3")){
//                System.out.println("Top up: ");
//                atm.topUp(num);
//            } else{
//                System.exit(0);
//            }
//        }
//    }
//
//    @Override
//    public void write(String num, String pass) {
//    }
}
