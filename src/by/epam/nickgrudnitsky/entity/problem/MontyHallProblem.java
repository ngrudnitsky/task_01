package by.epam.nickgrudnitsky.entity.problem;

import by.epam.nickgrudnitsky.entity.output.Printer;
import by.epam.nickgrudnitsky.util.Validator;

import java.util.Random;

import static by.epam.nickgrudnitsky.util.DataInput.readNumber;
import static by.epam.nickgrudnitsky.util.Validator.validateNumberOfChecks;

public class MontyHallProblem extends Problem {
    private boolean chosenDoor;
    private int numberOfChecks;
    private int numberOfWinningsWhenChangeChoice = 0;
    private int numberOfWinningsWhenDoNotChangeChoice = 0;
    private static Random random = new Random();
    private final static int DOORS = 3;

    public void checkAlgorithm(Printer printer) {
        printer.print(gerIntroductionMessage());

        numberOfChecks = readNumber();

        if (validateNumberOfChecks(numberOfChecks)) {
            runCheck();
        } else {
            printer.print(getValidationFailureMessage());
            checkAlgorithm(printer);
            return;
        }

        printer.print(getResultsMessage());

        numberOfWinningsWhenChangeChoice = 0;
        numberOfWinningsWhenDoNotChangeChoice = 0;
    }

    public MontyHallProblem() {
        setName("Monty Hall problem.");
    }

    private void runCheck() {
        for (int i = 0; i < numberOfChecks; i++) {

            chooseDoor();

            if (chosenDoor) {
                numberOfWinningsWhenDoNotChangeChoice++;
            } else {
                numberOfWinningsWhenChangeChoice++;
            }
        }
    }

    private void chooseDoor() {
        chosenDoor = random.nextInt(DOORS) + 1 == 1;
    }

    private String gerIntroductionMessage() {
        return "Enter the number of checks.\n";
    }

    private String getValidationFailureMessage() {
        return String.format("The number of checks must be between %d and %d.\n",
                Validator.MIN_NUMBER_OF_CHECKS, Validator.MAX_NUMBER_OF_CHECKS);
    }

    private String getResultsMessage() {
        return String.format("Wins out of %d:\n   when changing choices - %d.\n   when do not changing choices - %d.\n",
                numberOfChecks, numberOfWinningsWhenChangeChoice, numberOfWinningsWhenDoNotChangeChoice);
    }
}
