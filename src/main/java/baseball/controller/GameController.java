package baseball.controller;

import baseball.domain.Computer;
import baseball.ui.Input;
import baseball.ui.Output;

import java.util.ArrayList;

public class GameController {
   public void start() {
       run();

   }

   private void run() {
       Computer computer = new Computer();
       ArrayList<Integer> computerNumbers = computer.generateRandomNumbers();
       ArrayList<Integer> userNumbers = generateUserNumbers();
   }

   private ArrayList<Integer> generateUserNumbers() {
       Input input = new Input();

       try {
           String userInput = input.getInput();
           System.out.println(userInput);
           return convertStrToNumArray(userInput);
       } catch (Exception e) {
           Output.printExceptionMessage(e.getMessage());
           return generateUserNumbers();
       }
   }

   private ArrayList<Integer> convertStrToNumArray(String userInput) {
       ArrayList<Integer> baseball = new ArrayList<>();
         for (int i = 0; i < 3; i++) {
              baseball.add(Integer.parseInt(String.valueOf(userInput.charAt(i))));
         }
         return baseball;
   }
}
