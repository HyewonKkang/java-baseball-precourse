package baseball.controller;

import baseball.domain.Baseball;
import baseball.domain.Computer;
import baseball.domain.Result;
import baseball.service.JudgeService;
import baseball.ui.Input;
import baseball.ui.Output;

public class GameController {
    private JudgeService judgeService = new JudgeService();
    private Baseball computerNumbers;
    private Result result;

   public void start() {
       Computer computer = new Computer();
       computerNumbers = computer.generateRandomNumbers();
       run();
   }

   private void run() {
       do {
           Baseball userNumbers = generateUserNumbers();
           result = judgeService.judge(computerNumbers, userNumbers);
       } while (!result.isOver);
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
