package ru.geekbrains.spring.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Controller {
    private Scanner scanner = new Scanner(System.in);

    @Autowired
    private Cart cart;

    public void formLogic() {
        while (true) {
            System.out.println("Введите команду add, для добавления товара в корзину.");
            System.out.println("Введите команду delete, для удаления товара из корзины.");
            System.out.println("Введите команду show, для добавления товара в корзину.");
            System.out.println("Введите команду exit, для завершения работы с корзиной.");

            String cmd = scanner.nextLine();

            if (cmd.equals("add")) {
                System.out.println("Введите идентификатор товара для добавления в корзину");
                String productId = scanner.nextLine();
                cart.addProduct((long) Integer.parseInt(productId));
                System.out.println("В вашей корзине следующие товары:" + "\n" + cart.getProductsInCart() + "\n");
            }
            if (cmd.equals("delete")) {
                System.out.println("Введите идентификатор товара для удаления из корзины");
                String productId = scanner.nextLine();
                cart.removeProduct((long) Integer.parseInt(productId));
                System.out.println("В вашей корзине следующие товары:" + "\n" + cart.getProductsInCart() + "\n");
            }
            if (cmd.equals("show")) {
                System.out.println("В вашей корзине следующие товары:" + "\n" + cart.getProductsInCart() + "\n");
            }
            if (cmd.equals("exit")) {
                scanner.close();
                return;
            }
        }
    }
}
