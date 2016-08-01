package com.example;

import java.util.Random;

public final class JokeTeller {

    private static final String[] JOKES = {"A recent worldwide survey showed that out of 2,146,703,436 people, 94% were too lazy to actually read that number.",
            "Whoever invented knock knock jokes should get a no bell prize.", "How come oysters never donate to charity? Because they are shellfish."};

    public static String getRandomJoke() {
        Random rand = new Random();
        return JOKES[rand.nextInt(JOKES.length)];
    }
}
