package kg.megacom.service;

import kg.megacom.models.Subscriber;
import kg.megacom.service.impl.SubscriberServiceImpl;

import java.sql.Struct;

public interface SubscriberService {

    SubscriberService INSTANCE = new SubscriberServiceImpl();

    Subscriber findOrCreateSubscriber(String phone);

    void blockSubcriber(String phone);
}
