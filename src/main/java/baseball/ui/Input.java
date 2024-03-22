package baseball.ui;

import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public String getInput() {
        Output.printRequestNumberMessage();
        return scanner.nextLine();
    }

    public void close() {
        scanner.close();
    }
}
