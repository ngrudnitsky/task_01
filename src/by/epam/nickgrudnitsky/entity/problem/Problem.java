package by.epam.nickgrudnitsky.entity.problem;

import by.epam.nickgrudnitsky.entity.output.Printer;

public abstract class Problem {
    private String name;

    public abstract void checkAlgorithm(Printer printer);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
