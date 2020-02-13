package by.epam.nickgrudnitsky.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataInput {
    private DataInput() {
    }

    public static int readNumber() {
        Scanner scanner = new Scanner(System.in);
        int number = -1;

        try {
            number = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input data.");
        }

        return number;
    }
}
