package baseball.controller;

import baseball.domain.Computer;
import java.util.ArrayList;

public class GameController {
    private static Computer computer;


   public void start() {
       ArrayList<Integer> computerNumbers = computer.generateRandomNumbers();
       System.out.println(computerNumbers);
   }




}
