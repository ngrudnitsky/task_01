package by.epam.nickgrudnitsky.service;


import by.epam.nickgrudnitsky.entity.output.Printer;
import by.epam.nickgrudnitsky.entity.problem.BirthdayProblem;
import by.epam.nickgrudnitsky.entity.problem.MarriageProblem;
import by.epam.nickgrudnitsky.entity.problem.MontyHallProblem;
import by.epam.nickgrudnitsky.entity.problem.Problem;

import java.util.HashMap;
import java.util.Map;

import static by.epam.nickgrudnitsky.util.DataInput.readNumber;
import static by.epam.nickgrudnitsky.util.Validator.validateMenuItem;

public class AlgorithmService {
    private Map<Integer, Problem> startupMenu = new HashMap<>();
    private Printer printer;

    public AlgorithmService() {
        startupMenu.put(1, new MontyHallProblem());
        startupMenu.put(2, new BirthdayProblem());
        startupMenu.put(3, new MarriageProblem());
    }

    public void runProgram(Printer printer) {
        int menuItem;
        this.printer = printer;

        outputMenuToConsole(startupMenu);

        menuItem = readNumber();

        if (validateMenuItem(menuItem)) {
            process(menuItem);
        } else {
            printer.print(getMenuValidationFailureMessage());
            runProgram(printer);
        }
    }

    private void process(int menuItem) {
        if (menuItem == 0) {
            return;
        }
        startupMenu.get(menuItem).checkAlgorithm(printer);
        runProgram(printer);
    }

    private void outputMenuToConsole(Map<Integer, Problem> startupMenu) {
        printer.print("Enter a number to continue:\n");

        for (Map.Entry<Integer, Problem> problem : startupMenu.entrySet()) {
            printer.print(problem.getKey() + " - " + problem.getValue().getName() + "\n");
        }

        printer.print("0 - Exit.\n");
    }

    private String getMenuValidationFailureMessage() {
        return "Choose from the given numbers.\n";
    }
}
