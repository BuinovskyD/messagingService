package ru.buinovsky.subscriber.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.buinovsky.publisher.Action;
import ru.buinovsky.subscriber.model.MessageTo;
import java.sql.Timestamp;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml",
        "classpath:spring/spring-web.xml"
})
@ExtendWith(SpringExtension.class)
class MassageServiceTest {

    @Autowired
    private MassageService service;

    @Test
    void create() {
        int msisdn = 123456789;
        Timestamp timestamp = new Timestamp(1589464122);
        String action = Action.PURCHASE.name();

        MessageTo expected = new MessageTo(msisdn, action, timestamp);
        service.create(expected);
        MessageTo actual = service.getByMsisdnAndAction(msisdn, Action.PURCHASE.name());

        Assertions.assertEquals(expected.getMsisdn(), actual.getMsisdn());
        Assertions.assertEquals(expected.getAction(), actual.getAction());
        Assertions.assertEquals(expected.getTimestamp(), actual.getTimestamp());
    }
}