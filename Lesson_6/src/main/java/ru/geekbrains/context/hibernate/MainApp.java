package ru.geekbrains.context.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.context.hibernate.app.Test;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Test test = context.getBean("test", Test.class);
        test.findProducts();
        test.findBuyers();

        context.close();
    }

}
