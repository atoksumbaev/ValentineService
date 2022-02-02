package kg.megacom.service.impl;

import kg.megacom.models.Subscriber;
import kg.megacom.service.SubscriberService;

public class SubscriberServiceImpl implements SubscriberService {

    private Subscriber[] subscribers = new Subscriber[50];

    @Override
    public Subscriber findOrCreateSubscriber(String phone) {

         /*
                Если ячейка пуста
                    Создаю и записываю абона
                Не пуста
                    Сравнить то что была там, с тем что пришло на вход
                        return;
            * */
        for (int i = 0; i < subscribers.length; i++){
            if (subscribers[i] == null){
                Subscriber subscriber = new Subscriber(phone);
                subscribers[i] = subscriber;
                return subscriber;
            }else {
                if (subscribers[i].getPhone().equals(phone)){
                    return subscribers[i];
                }else {
                    continue;
                }
            }
        }
        throw new RuntimeException("Массив переполнен");
    }

    private Subscriber findSubcriber(String phone){
        /*
        * Проверка на null -> если ячейка не пустая -> сравнить его номера
            return subscribers[i];
        * */
        return null;
    }

    @Override
    public void blockSubcriber(String phone) {


        /*

            Subcriber subs = findSubcriber(phone);
                subs -> isActibe = true;
                Записать его в массив

            findSubcriber(phone); -> null -> Сделать ошибку

        * */

    }

}
