package atm;

import atm.login.ChainOfResponsibility;
import atm.login.bankNumber;
import atm.login.password;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "spring.xml"
        );

        cardDataBase cardDataBase = context.getBean("cardDataBase", cardDataBase.class);

        System.out.println(cardDataBase.getCardNum());
        System.out.println(cardDataBase.getPassword());
        System.out.println(cardDataBase.getBalance());


        ATM atm = new ATM();

        ChainOfResponsibility login = new bankNumber();
        ChainOfResponsibility password = new password();
        ChainOfResponsibility server = new SystemFacade();

        cardDataBase cardDataBase1 = new cardDataBase(cardDataBase.getCardNum(), cardDataBase.getPassword(), cardDataBase.getBalance());
        atm.addCardDataBase(cardDataBase1);

        System.out.println("Welcome ATM");
        System.out.println();
        System.out.println("<--------------------------------------->");
        System.out.println("Please authorise:");
        System.out.println();
        login.setChainOfResponsibility(password);
        password.setChainOfResponsibility(server);

        login.write(cardDataBase.getCardNum(), cardDataBase.getPassword());
        password.write(cardDataBase.getCardNum(), cardDataBase.getPassword());
        System.out.println("<--------------------------------------->");

        context.close();
    }
}
