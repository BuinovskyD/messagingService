package ru.buinovsky;

import ru.buinovsky.publisher.Publisher;
import java.net.URI;

public class Main {

    public static void main(String[] args) {

        URI uri = URI.create("http://localhost:8080/subscriber/");

        for (int i = 0; i < 5; i++) {
            try {
                Publisher.sendRequest(uri);
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
