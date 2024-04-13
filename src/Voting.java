import java.util.*;

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
        this.choices = new LinkedHashMap<>();
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
    public void createChoice(String choice){
        this.choices.put(choice, null);
    }
    public void vote(Person voter,ArrayList<String> voter_choices){
        if (isAnonymous){
            return;
        }
        Vote newVote = new Vote(voter,null);
        //iteration over field "choices" keyset
        for (String i: choices.keySet()){
            //iteration over voter's choices
            for (String j:voter_choices){
                //checking if the choices we have in the field equals to the voters choice and adding a new vote to the values of the hashmap(it was set to null in the beginning)
                if (i.equals(j)){
                    choices.get(i).add(newVote);
                }
            }
        }
        //adding the person to the field "voters" if he wasn't already in the arraylist
        if (!voters.contains(voter)){
            voters.add(voter);
        }
    }
    public void vote(Person person){
        if (!isAnonymous){
            return;
        }
        Vote newVote = new Vote(person,null);
        Random random = new Random();
        // a random number for random voting
        int randomNum = random.nextInt(choices.size());
        int counter = 0;
        for(String i : choices.keySet()){
            // adding the person to the hashmap based on the random number
            counter++;
            if (counter<randomNum){
                continue;
            }
            else {
                choices.get(i).add(newVote);
                break;
            }
        }
        if (!voters.contains(person)){
            voters.add(person);
        }
    }
    public void printResults(){
        for (String i: choices.keySet()){
            System.out.println("Choice:" + i + "\tNumber of votes:" + choices.get(i).size());
        }
    }
    public void printVoters(){
        if (isAnonymous){
            return;
        }
        for (String i : choices.keySet()){
            System.out.printf("Choice: %s\tVoters: ",i);
            for (Vote j : choices.get(i)){
                System.out.println(j.getVoter().getFirstName() + " " + j.getVoter().getLastName());
            }
        }
    }
}
