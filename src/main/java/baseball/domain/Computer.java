package baseball.domain;

import java.util.ArrayList;
import java.util.Random;

public class Computer {
    private static ArrayList<Integer> computerNumbers;
    public Computer() {
        computerNumbers = generateRandomNumbers();
    }
    public ArrayList<Integer> generateRandomNumbers() {
        Random random = new Random();
        ArrayList<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < 3) {
            int randomNumber = random.nextInt(9) + 1;
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }

        return randomNumbers;
    }

    public static ArrayList<Integer> getComputerNumbers() {
        return computerNumbers;
    }
}
