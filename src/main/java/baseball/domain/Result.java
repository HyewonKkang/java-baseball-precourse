package baseball.domain;

public class Result {
    private int strike;
    private int ball;
    private String resultMessage;
    public boolean isOver;

    public Result(int strike, int ball, String resultMessage) {
        this.strike = strike;
        this.ball = ball;
        this.resultMessage = resultMessage;
        this.isOver = strike == Baseball.VALID_BASEBALL_LENGTH;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public String getResultMessage() {
        return resultMessage;
    }
}