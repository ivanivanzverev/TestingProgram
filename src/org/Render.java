package org;

public class Render {

    public static void askQuestion(Question question) {
        System.out.println("Вопрос номер " + question.getNumber());
        System.out.println(question.getQuestion());
        System.out.println("Варианты ответа:");
        System.out.println(question.getVar());
    }

    public static void instruction() {
        String instruction = "\nДля прохождения теста укажите название файла с тестом.\n" +
                            "Тесты хранятся в директории doc/Tests/\n" +
                            "В процессе прохождения теста необходимо вводить число, слово или последовательность вариантов ответа\n" +
                            //"Варианты ответов вводятся через ; без пробелов" +
                            "Gосле завершения теста вы увидите результат прохождения теста.";
        System.out.println(instruction);
        System.out.println();
    }
}
