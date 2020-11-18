package ru.buinovsky.subscriber.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.buinovsky.subscriber.model.Purchase;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

    Purchase getByMsisdn(int msisdn);
}
