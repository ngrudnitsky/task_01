package by.epam.nickgrudnitsky.entity.problem;

import by.epam.nickgrudnitsky.entity.output.Printer;
import by.epam.nickgrudnitsky.util.Validator;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static by.epam.nickgrudnitsky.util.DataInput.readNumber;
import static by.epam.nickgrudnitsky.util.Validator.validateNumberOfChecks;
import static by.epam.nickgrudnitsky.util.Validator.validateNumberOfPeople;

public class BirthdayProblem extends Problem {
    private int numberOfPeople;
    private int numberOfChecks;
    private int numberOfCoincidences;
    private Set<Integer> birthdays = new HashSet<>();
    private static Random random = new Random();
    private final static int DAYS_IN_A_YEAR = 365;

    public BirthdayProblem() {
        setName("Birthday problem.");
    }

    public void checkAlgorithm(Printer printer) {
        printer.print(getIntroductionMessage());

        numberOfPeople = readNumber();
        numberOfChecks = readNumber();

        if (validateNumberOfPeople(numberOfPeople) && validateNumberOfChecks(numberOfChecks)) {
            runCheck();
        } else {
            printer.print(getValidationFailureMessage());
            checkAlgorithm(printer);
            return;
        }

        printer.print(getResultsMessage());

        numberOfCoincidences = 0;
    }

    private void runCheck() {
        for (int i = 0; i < numberOfChecks; i++) {
            fillBirthdays();

            if (birthdays.size() < numberOfPeople) {
                numberOfCoincidences++;
            }

            birthdays.clear();
        }
    }

    private void fillBirthdays() {
        for (int i = 0; i < numberOfPeople; i++) {
            birthdays.add(random.nextInt(DAYS_IN_A_YEAR) + 1);
        }
    }

    private String getIntroductionMessage() {
        return "Enter the number of people and then number of checks.\n";
    }

    private String getResultsMessage() {
        return String.format("Birthdays coincided %d times with the number of people equal to %d and " +
                "the number of iterations %d.\n", numberOfCoincidences, numberOfPeople, numberOfChecks);
    }

    private String getValidationFailureMessage() {
        return String.format("The number of people must be between %d and %d.\n" +
                        "The number of checks must be between %d and %d.\n",
                Validator.MIN_NUMBER_OF_PEOPLE, Validator.MAX_NUMBER_OF_PEOPLE,
                Validator.MIN_NUMBER_OF_CHECKS, Validator.MAX_NUMBER_OF_CHECKS);
    }
}
