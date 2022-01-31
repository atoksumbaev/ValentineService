package kg.megacom.service.impl;

import kg.megacom.exceptions.MaxCountSubsWishes;
import kg.megacom.models.Subscriber;
import kg.megacom.models.Wish;
import kg.megacom.service.SubscriberService;
import kg.megacom.service.WishService;

public class WishServiceImpl implements WishService {

    private Wish[] wishes = new Wish[10];
    private SubscriberService service = new SubscriberServiceImpl();


    @Override
    public void createWish(String text, String phoneSender, String phoneReceipt) {

        Subscriber sender =  service.findOrCreateSubscriber(phoneSender);
        Subscriber receipt = service.findOrCreateSubscriber(phoneReceipt);

        // Проверить, отправлял ли сообщения sender k receipt
        if (checkSendSms(sender, receipt)){
            throw new RuntimeException("Вы уже отправляли смс данному абоненту");
        }
        System.out.println(sender.getId());
        sender.incrementSubsWish();
        // Создать Wish -> положить его в массив

        for (int i = 0; i < wishes.length; i++){
            if (wishes[i] == null){
                Wish wish = new Wish(text, sender, receipt);
                wishes[i] = wish;
                System.out.println("Смс успешно отправлен!");
                break;
            }
        }
        // Сообщение успешно отправлено
    }

    private boolean checkSendSms(Subscriber sender, Subscriber receipt){
        for (int i = 0; i < wishes.length; i++){
            if (wishes[i] == null){
                continue;
            }else {
                if (wishes[i].getSender().getId() == sender.getId()
                        && wishes[i].getReceipt().getId() == receipt.getId()){
                    return true;
                }else {
                    return false;
                }
            }
        }
        return false;
    }
}
