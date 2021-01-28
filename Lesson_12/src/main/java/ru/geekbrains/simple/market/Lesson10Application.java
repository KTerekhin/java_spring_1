package ru.geekbrains.simple.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lesson10Application {
	// Домашнее задание:
	// 1. Доработайте корзину
	// 2. доп: Мысли по поводу того, как заказы должны храниться в БД
	// (например, как организовать сохранение цен товаров на момент покупки)
	public static void main(String[] args) {
		SpringApplication.run(Lesson10Application.class, args);
	}
}
