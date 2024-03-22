package baseball.domain;

import java.util.Random;

public class Computer {
    public Baseball generateRandomNumbers() {
        Random random = new Random();
        String randomNumbers = "";

        while (randomNumbers.length() < 3) {
            int randomNumber = random.nextInt(9) + 1;
            if (!randomNumbers.contains(Integer.toString(randomNumber))) {
                randomNumbers += randomNumber;
            }
        }

        return new Baseball(randomNumbers);
    }

}
