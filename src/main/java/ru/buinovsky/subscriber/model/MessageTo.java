package ru.buinovsky.subscriber.model;

import java.sql.Timestamp;

public class MessageTo {

    private int msisdn;

    private String action;

    private Timestamp timestamp;

    public MessageTo() {
    }

    public MessageTo(int msisdn, String action, Timestamp dateTime) {
        this.msisdn = msisdn;
        this.action = action;
        this.timestamp = dateTime;
    }

    public int getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(int msisdn) {
        this.msisdn = msisdn;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
