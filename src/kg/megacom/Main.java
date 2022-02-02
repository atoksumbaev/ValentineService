package kg.megacom;

import kg.megacom.models.Subscriber;
import kg.megacom.models.Wish;
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
                    "3. Выход" +
                    "4. Блокировать");

            System.out.println("Ваш выбор: ");
            int data = scanner.nextInt();

            switch (data){
                case 1:
                    System.out.println("Введите номер получателя ");
                    String receiptPhone = scanner.next();
                    System.out.println("Введите номер отправителя ");
                    String senderPhone = scanner.next();
                    System.out.println("Введите текст который хотите отправить");
                    String text = scanner.next();
                    wishService.createWish(text, senderPhone, receiptPhone);
                    break;
                case 2:
                    System.out.println("Введите номер телефона");
                    String receiptPhone2 = scanner.next();
                    Wish[] wishes =  wishService.receiptWishes(receiptPhone2);
                    System.out.println("--------------------------------");
                    System.out.println("Ваши сообщения: ");
                    int counter = 1;
                    for (Wish w : wishes) {
                        System.out.println(counter + "." + w.getText() + ". Отправитель: " + w.getSender().getPhone());
                        counter++;
                    }
                    System.out.println("--------------------------------");
                    break;
                case 3:
                    System.out.println("До свидания!");
                    break;
                case 4:
                    System.out.println("Введите ваш номер ");
                    String phone = scanner.next();


            }

        }
    }
}
