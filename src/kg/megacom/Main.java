package kg.megacom;

import kg.megacom.models.Subscriber;
import kg.megacom.service.WishService;
import kg.megacom.service.impl.WishServiceImpl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        WishService wishService = new WishServiceImpl();
        while (true){
            System.out.println("Выберите действие:");
            System.out.println(" "+
                    "1. Отправить сообщение\n " +
                    "2. Просмотреть доступные сообщения\n " +
                    "3. Выход");

            System.out.println("Ваш выбор: ");
            int data = scanner.nextInt();

            switch (data){
                case 1:
                    System.out.println(" Введите номер получателя ");
                    String receiptPhone = scanner.next();
                    System.out.println(" Введите номер отправителя ");
                    String senderPhone = scanner.next();
                    System.out.println(" Введите текст который хотите отправить");
                    String text = scanner.next();
                    wishService.createWish(text, senderPhone, receiptPhone);
                    break;
                case 3:
                    System.out.println("До свидания!");
                    break;
            }

        }
    }
}
