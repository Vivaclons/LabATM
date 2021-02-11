package atm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class AtmApplication {

    public static void main(String[]args) {
        SpringApplication.run(AtmApplication.class, args);
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "spring.xml"
        );
        SystemFacade systemFacade = context.getBean("systemFacade", SystemFacade.class);
        systemFacade.menu();
        context.close();
    }
}
