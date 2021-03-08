package ru.geekbrains.context.hibernate.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.context.hibernate.entity.Buyer;

@Component
public class BuyerRepository {
    SessionFactory factory;

    @Autowired
    public BuyerRepository(SessionFactory factory) {
        this.factory = factory;
    }

    public Buyer getBuyer(Long buyerId) {
        Session session = factory.getCurrentSession();
        Buyer buyer = session.get(Buyer.class, buyerId);
        session.getTransaction().commit();
        System.out.println(buyer.toString());
        return buyer;
    }
}
