package kg.megacom.service;

import kg.megacom.models.Subscriber;

public interface SubscriberService {

    Subscriber findOrCreateSubscriber(String phone);
}
