public class Question {
    private String question;

    private String[] listOfOption;


    public Question(String question, String[] listOfOption) {
        this.question = question;
        this.listOfOption = listOfOption;
    }

    public String getQuestion(){
        return this.question;
    }

    public String[] getListOfOption() {
        return listOfOption;
    }

    public void displayQuestion() {
        System.out.println(this.question);
        for(String option : this.listOfOption){
            System.out.println(option);
        }
        int optionSize = this.listOfOption.length-1;
        char endChar = (char)((char)97 + (char)optionSize);
        String end = Character.toString(endChar);
        System.out.println("Enter the correct Answer (a -" + end + ")");
    }
}
