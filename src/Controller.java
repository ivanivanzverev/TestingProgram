import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {

    private Core core;
    private List<Boolean> results;

    public Controller() {
        this.core = new Core();
        this.results = new ArrayList<>();
    }

    public void answerQuestion(Question question) {
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        results.add(core.checkAnswer(question, answer));
    }

    public static String askTestName() {
        System.out.println("Введите название теста: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void startTest(String dir) {
        try {
            core.readFile(dir);
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла");
            System.exit(1);
        }
        core.shuffle();
        for (int i = 0; i < core.getQuestions().size(); i++) {
            Render.askQuestion(core.getQuestions().get(i));
            answerQuestion(core.getQuestions().get(i));
        }

        int sum = 0;
        for (Boolean results: results) {
            if (results == true) sum++;
        }
        System.out.println("Количество правильных ответов: " + sum);
    }
}
