import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Voting {
    private int type;
    private String question;
    private HashMap<String, HashSet<Vote>> choices;
    private boolean isAnonymous;
    private ArrayList<Person> voters;

    public Voting(int type, String question, boolean isAnonymous) {
        this.type = type;
        this.question = question;
        this.isAnonymous = isAnonymous;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public HashMap<String, HashSet<Vote>> getChoices() {
        return choices;
    }
}
