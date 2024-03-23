package baseball.controller;

import baseball.domain.Baseball;
import baseball.domain.Computer;
import baseball.domain.Result;
import baseball.service.JudgeService;
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
           printResult();
           break;
       }
   }

   private void printResult() {
       JudgeService judgeService = new JudgeService();
       Result result = judgeService.judge(computerNumbers, userNumbers);
       Output.printMessage(result.getResultMessage());
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
