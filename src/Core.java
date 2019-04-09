import java.io.*;
import java.util.ArrayList;

public class Core {

    private ArrayList<Question> questions;

    public void readFile(String dir) throws IOException {
        File file = new File(dir);
        BufferedReader br = new BufferedReader(new FileReader(file));
        int i = 0;
        while (file.canExecute()) {
            //questions.set(i++, new Question(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), br.readLine(), br.readLine(), br.readLine()));
            questions.get(i).setNumber(Integer.parseInt(br.readLine()));
            questions.get(i).setType(Integer.parseInt(br.readLine()));
            questions.get(i).setQuestion(br.readLine());
            questions.get(i).setVar(br.readLine());
            questions.get(i).setAnswer(br.readLine());
            i++;
        }
    }

    public void shuffle() {

    }


}
