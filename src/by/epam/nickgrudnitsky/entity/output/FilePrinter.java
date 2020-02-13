package by.epam.nickgrudnitsky.entity.output;

import java.io.*;

public class FilePrinter implements Printer {
    private File file;


    public FilePrinter(String fileName) {
        this.file = new File(fileName);
    }

    @Override
    public void print(String message)  {
        try {
            if (!file.exists()){
                file.createNewFile();
            }
            PrintWriter writer = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter(file, true)));
            writer.print(message);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
