DROP TABLE IF EXISTS subscriptions;
DROP TABLE IF EXISTS purchases;
DROP SEQUENCE IF EXISTS purchase_id;
DROP SEQUENCE IF EXISTS subscription_id;

CREATE SEQUENCE purchase_id START 100;

CREATE TABLE purchases
(
    id INTEGER PRIMARY KEY DEFAULT nextval('purchase_id'),
    msisdn INTEGER NOT NULL,
    timestamp VARCHAR NOT NULL
);

CREATE SEQUENCE subscription_id START 100;

CREATE TABLE subscriptions
(
    id INTEGER PRIMARY KEY DEFAULT nextval('subscription_id'),
    msisdn INTEGER NOT NULL,
    timestamp VARCHAR NOT NULL
);