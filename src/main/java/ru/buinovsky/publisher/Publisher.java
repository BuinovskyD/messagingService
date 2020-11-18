package ru.buinovsky.publisher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.buinovsky.subscriber.web.MassageController;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

public class Publisher {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final Logger LOGGER = LoggerFactory.getLogger(Publisher.class);

    public static void sendRequest(URI uri) throws Exception {

        if (uri == null) {
            throw new Exception("Required not null URI");
        }

        String json = getJson();

        LOGGER.info("send request to URI {}", uri.toString());

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
        System.out.println(response.headers());
    }

    private static String getJson() throws JsonProcessingException {

        LOGGER.info("create JSON for request");

        Map<String, String> jsonMap = new HashMap<>();

        jsonMap.put("msisdn", getRandomMsisdn());
        jsonMap.put("action", getRandomActionName());
        jsonMap.put("timestamp", getCurrentTimestamp());

        return objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(jsonMap);
    }

    private static String getRandomMsisdn() {
        Random random = new Random();
        return String.valueOf(random.nextInt(Integer.MAX_VALUE));
    }

    private static String getRandomActionName() {
        return Action.getRandomAction().name();
    }

    private static String getCurrentTimestamp() {
        LocalDateTime dateTime = LocalDateTime.now();
        ZoneId zoneId = ZoneId.systemDefault();
        long timestamp = dateTime.atZone(zoneId).toEpochSecond();
        return String.valueOf(timestamp);
    }
}

