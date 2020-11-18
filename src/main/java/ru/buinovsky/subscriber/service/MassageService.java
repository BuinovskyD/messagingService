package ru.buinovsky.subscriber.service;

import org.springframework.stereotype.Service;
import ru.buinovsky.publisher.Action;
import ru.buinovsky.subscriber.model.MessageTo;
import ru.buinovsky.subscriber.model.Purchase;
import ru.buinovsky.subscriber.model.Subscription;
import ru.buinovsky.subscriber.repository.PurchaseRepository;
import ru.buinovsky.subscriber.repository.SubscriptionRepository;

@Service
public class MassageService {

    private final PurchaseRepository purchaseRepository;
    private final SubscriptionRepository subscriptionRepository;

    public MassageService(PurchaseRepository purchaseRepository,
                          SubscriptionRepository subscriptionRepository) {
        this.purchaseRepository = purchaseRepository;
        this.subscriptionRepository = subscriptionRepository;
    }

    public void create(MessageTo massage) {

        String action = massage.getAction().toLowerCase();

        if (action.equals("purchase")) {
            Purchase purchase = new Purchase(massage);
            purchaseRepository.save(purchase);

        } else if (action.equals("subscription")) {
            Subscription subscription = new Subscription(massage);
            subscriptionRepository.save(subscription);
        }
    }

    // for testing
    public MessageTo getByMsisdnAndAction(int msisdn, String action) {

        MessageTo messageTo = null;

        if (action.toLowerCase().equals("purchase")) {
            Purchase purchase = purchaseRepository.getByMsisdn(msisdn);
            messageTo = new MessageTo(purchase.getMsisdn(), Action.PURCHASE.name(), purchase.getTimestamp());
        } else if (action.toLowerCase().equals("subscription")) {
            Subscription subscription = subscriptionRepository.getByMsisdn(msisdn);
            messageTo = new MessageTo(subscription.getMsisdn(), Action.PURCHASE.name(), subscription.getTimestamp());
        }

        return messageTo;
    }
}
