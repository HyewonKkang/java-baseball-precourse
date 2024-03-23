package baseball.service;

import baseball.domain.Baseball;
import baseball.domain.Result;
import baseball.ui.Output;

import static baseball.domain.Baseball.VALID_BASEBALL_LENGTH;

public class JudgeService {
    public static final String STRIKE = "스트라이크";
    public static final String BALL = "볼";
    public static final String NOTHING = "낫싱";

    public Result judge(Baseball computerNumbers, Baseball userNumbers) {
        int strike = getStrikeCount(computerNumbers, userNumbers);
        int ball = getBallCount(computerNumbers, userNumbers);
        String resultMessage = "";

        if (strike == 0 && ball == 0) {
            resultMessage = NOTHING;
        } else if (strike > 0 && ball > 0) {
            resultMessage = strike + STRIKE + " " + ball + BALL;
        } else if (strike > 0) {
            resultMessage = strike + STRIKE;
        } else {
            resultMessage = ball + BALL;
        }
        Result result = new Result(strike, ball, resultMessage);
        printResult(result);
        return result;
    }

    private void printResult(Result result) {
        Output.printMessage(result.getResultMessage());
        if (result.isOver) {
            Output.printGameEndMessage();
        }
    }

    private int getStrikeCount(Baseball computerNumbers, Baseball userNumbers) {
        int strike = 0;
        for (int i = 0; i < VALID_BASEBALL_LENGTH; i++) {
            if (computerNumbers.getNumber(i) == userNumbers.getNumber(i)) {
                strike++;
            }
        }
        return strike;
    }

    private int getBallCount(Baseball computerNumbers, Baseball userNumbers) {
        int ball = 0;
        for (int i = 0; i < VALID_BASEBALL_LENGTH; i++) {
            for (int j = 0; j < VALID_BASEBALL_LENGTH; j++) {
                if (i != j && computerNumbers.getNumber(i) == userNumbers.getNumber(j)) {
                    ball++;
                }
            }
        }
        return ball;
    }
}
