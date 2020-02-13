package by.epam.nickgrudnitsky.entity.problem;

import by.epam.nickgrudnitsky.entity.output.Printer;
import by.epam.nickgrudnitsky.util.Validator;

import java.util.*;

import static by.epam.nickgrudnitsky.util.DataInput.readNumber;
import static by.epam.nickgrudnitsky.util.Validator.*;

public class MarriageProblem extends Problem {
    private int numberOfFiances;
    private int numberOfChecks;
    private int numberOfCorrectChoices;
    private List<Integer> fiances = new ArrayList<>();

    public MarriageProblem() {
        setName("Marriage problem.");
    }

    public void checkAlgorithm(Printer printer) {
        printer.print(getIntroductionMessage());
        numberOfFiances = readNumber();
        numberOfChecks = readNumber();
        if (validateNumberOfFiance(numberOfFiances) && validateNumberOfChecks(numberOfChecks)) {
            runCheck();
        } else {
            printer.print(getValidationFailureMessage());
            checkAlgorithm(printer);
            return;
        }
        printer.print(getResultsMessage());
        numberOfCorrectChoices = 0;
    }

    private void runCheck() {
        int currentFianceQuality = 0;
        int bestFianceQuality = 0;
        double step = Math.round(numberOfFiances / Math.exp(1));

        fillFiances();
        for (int i = 0; i < numberOfChecks; i++) {

            Collections.shuffle(fiances);

            for (int attempt = 0; attempt < numberOfFiances; attempt++) {
                int fiance = fiances.get(attempt);

                if (bestFianceQuality < fiance) {
                    if (attempt >= step) {
                        currentFianceQuality = fiance;
                        break;
                    }
                    bestFianceQuality = fiance;
                }
            }

            if (currentFianceQuality == numberOfFiances) {
                numberOfCorrectChoices++;
            }

            bestFianceQuality = 0;
            currentFianceQuality = 0;
        }
    }

    private void fillFiances() {
        for (int i = 1; i <= numberOfFiances; i++) {
            fiances.add(i);
        }
    }

    private String getIntroductionMessage() {
        return "Enter the number of fiances and then number of checks.\n";
    }

    private String getResultsMessage() {
        return String.format("The best fiance out of %d was selected %d times in %d attempts in increments of 1/e.\n",
                numberOfFiances, numberOfCorrectChoices, numberOfChecks);
    }

    private String getValidationFailureMessage() {
        return String.format("The number of fiances must be between %d and %d.\n" +
                        "The number of checks must be between %d and %d.\n",
                MIN_NUMBER_OF_FIANCES, MAX_NUMBER_OF_FIANCES, Validator.MIN_NUMBER_OF_CHECKS,
                Validator.MAX_NUMBER_OF_CHECKS);
    }
}
