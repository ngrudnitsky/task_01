package by.epam.nickgrudnitsky.entity.output;

public class ConsolePrinter implements Printer {

    @Override
    public void print(String message) {
        System.out.print(message);
    }
}
