package by.epam.nickgrudnitsky;

import by.epam.nickgrudnitsky.entity.output.ConsolePrinter;
import by.epam.nickgrudnitsky.entity.output.FilePrinter;
import by.epam.nickgrudnitsky.service.AlgorithmService;

public class Main {
    public static void main(String[] args) {
        AlgorithmService service = new AlgorithmService();
        service.runProgram(new ConsolePrinter());
        //service.runProgram(new FilePrinter("resources/log.txt"));
    }
}
