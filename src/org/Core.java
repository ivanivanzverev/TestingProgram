package org;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.nio.*;
import java.util.List;

public class Core {

    private List<Question> questions;

    public Core() {
        this.questions = new ArrayList<>();
    }

    public void readFile(String dir) throws IOException {
        Path filePath = Paths.get(dir);
        List<String> lines = new ArrayList<>();
        lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
        for (int i = 0; i < lines.size(); i += 5) {
            questions.add(new Question(Integer.parseInt(lines.get(i)), Integer.parseInt(lines.get(i + 1)), lines.get(i + 2), lines.get(i + 3), lines.get(i + 4)));
        }
    }

    public void shuffle() {
        Collections.shuffle(questions);
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public boolean checkAnswer(Question question, String answer) {
        boolean check = true;
        switch (question.getType()) {
            case 1:
                check = question.getAnswer().equals(answer);
                break;
            case 2:
                String[] rightVars = question.getAnswer().split(";");
                String[] vars = answer.split(";");
                if (rightVars.length == vars.length) {
                    List<String> ansList = new ArrayList<>();
                    for (String ans: vars) {
                        ansList.add(ans);
                    }
                    for (String rightVar: rightVars) {
                        if (ansList.contains(rightVar)) ansList.remove(rightVar);
                    }
                    if (!ansList.isEmpty()) {
                        check = false;
                        break;
                    }
                } else {
                    check = false;
                    break;
                }

        }
        return check;
    }


}
