package ru.buinovsky.publisher;

import java.util.List;
import java.util.Random;

public enum Action {
    PURCHASE,
    SUBSCRIPTION;

    private static final List<Action> ACTIONS = List.of(Action.values());

    public static Action getRandomAction() {
        Random random = new Random();
        return ACTIONS.get(random.nextInt(ACTIONS.size()));
    }
}
