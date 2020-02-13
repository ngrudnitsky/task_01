package by.epam.nickgrudnitsky.util;

import by.epam.nickgrudnitsky.data.Menu;

public class Validator {
    public static final int MIN_MENU_NUMBER = 0;
    public static final int MIN_NUMBER_OF_CHECKS = 1;
    public static final int MAX_NUMBER_OF_CHECKS = 1_000_000;
    public static final int MIN_NUMBER_OF_PEOPLE = 23;
    public static final int MAX_NUMBER_OF_PEOPLE = 366;
    public static final int MIN_NUMBER_OF_FIANCES = 10;
    public static final int MAX_NUMBER_OF_FIANCES = 1000;

    private Validator() {
    }

    public static boolean validateMenuItem(int number) {
        return number >= MIN_MENU_NUMBER && number < Menu.values().length;
    }

    public static boolean validateNumberOfChecks(int number) {
        return number >= MIN_NUMBER_OF_CHECKS && number <= MAX_NUMBER_OF_CHECKS;
    }

    public static boolean validateNumberOfPeople(int number) {
        return number >= MIN_NUMBER_OF_PEOPLE && number <= MAX_NUMBER_OF_PEOPLE;
    }

    public static boolean validateNumberOfFiance(int number) {
        return number >= MIN_NUMBER_OF_FIANCES && number <= MAX_NUMBER_OF_FIANCES;
    }
}
