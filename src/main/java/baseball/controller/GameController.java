package baseball.controller;

import baseball.domain.Baseball;
import baseball.domain.Computer;
import baseball.ui.Input;
import baseball.ui.Output;

public class GameController {
    private Baseball computerNumbers;
    private Baseball userNumbers;

   public void start() {
       Computer computer = new Computer();
       computerNumbers = computer.generateRandomNumbers();
       run();
   }

   private void run() {
       while (true) {
           userNumbers = generateUserNumbers();
           break;
       }
   }

   private Baseball generateUserNumbers() {
       Input input = new Input();
       try {
           String userInput = input.getInput();
           return new Baseball(userInput);
       } catch (IllegalArgumentException e) {
           Output.printExceptionMessage(e.getMessage());
           return generateUserNumbers();
       }
   }

}
