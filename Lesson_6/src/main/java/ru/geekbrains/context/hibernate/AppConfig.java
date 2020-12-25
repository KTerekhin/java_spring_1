package ru.geekbrains.context.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"ru.geekbrains.context.hibernate"})
public class AppConfig {

    @Bean
    public SessionFactory factory() {
        return new org.hibernate.cfg.Configuration()
                .configure("config/hibernate.cfg.xml")
                .buildSessionFactory();
    }
}
