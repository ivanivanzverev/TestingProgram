package org;

public class Main {

    public static void main(String[] args) {
        Render.instruction();
        String dir = ".\\doc\\Tests\\" + Controller.askTestName();
        Controller controller = new Controller();
        controller.startTest(dir);
    }
}
