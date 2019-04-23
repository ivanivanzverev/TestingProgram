import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

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
        Collections.shuffle(questions);
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public boolean checkAnswer(Question question, String answer) {
        boolean check = true;
        switch (question.getType()) {
            case 1:
                check = question.getAnswer().equals(answer);
                break;
            case 2:
                check = true;
                String[] rightVars = question.getAnswer().split(" ");
                String[] vars = answer.split(" ");
                for (int i = 0; i < rightVars.length; i++) {
                    for (int j = 0; j < vars.length; i++) {
                        if (rightVars[i].equals(vars[j]) && rightVars != null) {
                            rightVars[i] = null;
                            vars[j] = null;
                        }
                    }
                }
                for (String el: rightVars) {
                    if (el != null) check = false;
                }
                for (String el: vars) {
                    if (el != null) check = false;
                }
                break;
        }
        return check;
    }


}
