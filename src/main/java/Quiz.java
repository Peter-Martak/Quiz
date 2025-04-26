import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Quiz {
    private ArrayList<Question> questions;
    private int countAnswer;
    private Scanner scanner;

    public Quiz(){
    }

    public void startQuiz(){
        this.questions = addQuestion();
        this.scanner = new Scanner(System.in);

        System.out.println("Welcome to quiz");
        System.out.println("This quiz has 3 question");

        for (int i = 0; i < this.questions.size(); i++) {
            Question question = this.questions.get(i);
            question.displayQuestion();
            char[] tempArray;
            String userAnswer;
            Answer correctAnswer;

            userAnswer = this.scanner.nextLine().toLowerCase();

            //check input from user
            userAnswer = checkInput(userAnswer, question);

            //sort string
            tempArray = userAnswer.toCharArray();
            Arrays.sort(tempArray);

            userAnswer = new String(tempArray);
            correctAnswer = question.getCorretAnswer();

            if (correctAnswer.isCorrect(userAnswer)) {
                this.countAnswer++;
            }
        }
        System.out.println("Number of correct answer " + this.countAnswer);
    }

    private String checkInput(String enterAnswer, Question question) {
        int optionSize = question.getOptions().length-1;
        char endChar = (char)((char)97 + (char)optionSize);
        String end = Character.toString(endChar);

        String regex = "[a -" + end + "]*";
        while (!enterAnswer.matches(regex)){
            System.out.println("Enter the correct Answer (a -" + end + ")");
            enterAnswer = this.scanner.nextLine().toLowerCase();
        }
        return enterAnswer;
    }


    private ArrayList<Question> addQuestion() {
        ArrayList<Question> question = new ArrayList<>();
        question.add(new Question("What is 2 + 2?   (Question with single answer)",new Answer[]{new Answer("a: 4"), new Answer("b: 5"),new Answer("c: 6")},new Answer("a")));
        question.add(new Question("What is 2 + 5    (Question with single answer)", new Answer[]{new Answer("a: 10"),new Answer("b: 7"),new Answer("c: 25"),new Answer("d: 9")}, new Answer("b")));
        question.add(new Question("4 = ?    (Question with multiple answers)", new Answer[] {new Answer("a: 2+2"),new Answer("b: 2^2"), new Answer("c: 2*3"), new Answer("d: 8/2")}, new Answer("abd")));
        return question;
    }
}
