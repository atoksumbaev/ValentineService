package kg.megacom.service;

import kg.megacom.models.Subscriber;
import kg.megacom.service.impl.SubscriberServiceImpl;

public interface SubscriberService {

    Subscriber findOrCreateSubscriber(String phone);

    void blockSubcriber(String phone);
}
