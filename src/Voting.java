import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

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
    public ArrayList<String> getChoices() {
        ArrayList<String> availableChoices = new ArrayList<>();
        for (String s : choices.keySet())
            availableChoices.add(s);
        return availableChoices;
    }
    private void creatChoice(String choice){
        this.choices.put(choice, null);
    }

}
