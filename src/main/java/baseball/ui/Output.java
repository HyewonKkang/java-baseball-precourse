package baseball.ui;

public class Output {
    private static final String REQUEST_NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

    public static void printRequestNumberMessage() {
        System.out.print(REQUEST_NUMBER_INPUT_MESSAGE);
    }
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printExceptionMessage(String exceptionMessage) {
        System.out.println("[ERROR] " + exceptionMessage);
    }
}
