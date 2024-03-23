package baseball.controller;

import baseball.domain.Baseball;
import baseball.domain.Computer;
import baseball.domain.Result;
import baseball.service.JudgeService;
import baseball.ui.Input;
import baseball.ui.Output;

public class GameController {
    private JudgeService judgeService = new JudgeService();
    private Input input = new Input();
    private Computer computer = new Computer();
    private Baseball computerNumbers;
    private Result result;

   public void start() {
       do {
           computerNumbers = computer.generateRandomNumbers();
           run();
       } while (playAgain() == 1);
   }

   private void run() {
       do {
           Baseball userNumbers = generateUserNumbers();
           result = judgeService.judge(computerNumbers, userNumbers);
       } while (!result.isOver);

       Output.printMessage(Output.GAME_ASK_MESSAGE);
   }

    private int playAgain() {
        int userInput = 0;
        try {
            userInput = Integer.parseInt(input.getInput());
            if (userInput != 1 && userInput != 2) {
                throw new IllegalArgumentException(Output.PLAY_AGAIN_WRONG_INPUT_MESSAGE);
            }
            return userInput;
        } catch (IllegalArgumentException e) {
            Output.printExceptionMessage(Output.PLAY_AGAIN_WRONG_INPUT_MESSAGE);
            return playAgain();
        }
    }

   private Baseball generateUserNumbers() {
       try {
           String userInput = input.getUserInput();
           return new Baseball(userInput);
       } catch (IllegalArgumentException e) {
           Output.printExceptionMessage(e.getMessage());
           return generateUserNumbers();
       }
   }

}
