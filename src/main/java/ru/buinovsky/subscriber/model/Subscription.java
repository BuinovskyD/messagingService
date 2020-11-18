package ru.buinovsky.subscriber.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Access(AccessType.FIELD)
@Table(name = "subscriptions")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subscription_id")
    @SequenceGenerator(name = "subscription_id", sequenceName = "subscription_id", allocationSize = 1, initialValue = 100)
    private int id;

    @Column(name = "msisdn", nullable = false)
    private int msisdn;

    @Column(name = "timestamp", nullable = false)
    private Timestamp timestamp;

    public Subscription() {
    }

    public Subscription(MessageTo massage) {
        this.msisdn = massage.getMsisdn();
        this.timestamp = massage.getTimestamp();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(int msisdn) {
        this.msisdn = msisdn;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
