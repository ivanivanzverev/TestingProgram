import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Render.instruction();
        String dir = "D:\\Tests\\" + Controller.askTestName();
        Controller controller = new Controller();
        controller.startTest(dir);
    }
}
