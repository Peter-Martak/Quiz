import java.util.ArrayList;

public class Answer {

    private String answer;

    public Answer (String answer){
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return answer;
    }
}
