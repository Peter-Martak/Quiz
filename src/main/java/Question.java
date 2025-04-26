public class Question {
    private String question;

    private Answer[] options;

    private Answer corretAnswer;


    public Question(String question, Answer[] options, Answer correctAnswer) {
        this.question = question;
        this.options = options;
        this.corretAnswer = correctAnswer;
    }

    public Answer getCorretAnswer() {
        return corretAnswer;
    }

    public String getQuestion(){
        return this.question;
    }

    public Answer[] getOptions() {
        return options;
    }

    public void displayQuestion() {
        System.out.println(this.question);
        for(Answer option : this.options){
            System.out.println(option);
        }
        int optionSize = this.options.length-1;
        char endChar = (char)((char)97 + (char)optionSize);
        String end = Character.toString(endChar);
        System.out.println("Enter the correct Answer (a -" + end + ")");
    }
}
