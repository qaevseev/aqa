package com.example.utils;

import com.github.javafaker.Faker;

public class FakerUtils {
    private static final Faker faker = new Faker();

    public static String randomName() {
        return faker.name().firstName();
    }

    public static String randomJob() {
        return faker.job().title();
    }
}
