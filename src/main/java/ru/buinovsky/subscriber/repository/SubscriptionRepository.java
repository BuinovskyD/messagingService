package ru.buinovsky.subscriber.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.buinovsky.subscriber.model.Subscription;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {

    Subscription getByMsisdn(int msisdn);
}
