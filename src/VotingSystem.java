import java.util.*;

public class VotingSystem {
    private ArrayList<Voting> votingList;

    public VotingSystem(ArrayList<Voting> votingList) {
        this.votingList = votingList;
    }

    public void createVoting(String question, boolean isAnonymous, int type, ArrayList<String> choices){
        Voting newVoting = new Voting(type, question, isAnonymous);
        for (String i: choices){
            newVoting.createChoice(i);
        }
        votingList.add(newVoting);
    }
    public Voting getVoting(int index){
        return votingList.get(index);
    }
    public ArrayList<Voting> getVotingList() {
        return votingList;
    }
    public void printResults (int index){
        getVoting(index).printResults();
    }
    public void printVoters(int index){
        getVoting(index).printVoters();
    }
    public void printVoting(int index){
        String question = votingList.get(index).getQuestion();
        ArrayList<String> choices = votingList.get(index).getChoices();
        int choiceCounter = 1;
        System.out.println("Question : " + question);
        for (String s : choices){
            System.out.printf("%d-%s  ", choiceCounter, s );
        }
        System.out.println();
    }
    public void vote (int index, Person voter){ // random voting
        Random random = new Random();
        int choiceCount= random.nextInt(getVoting(index).getChoices().size()); // random choices' count
        ArrayList<String> votingChoices = getVoting(index).getChoices();
        ArrayList<String> voterRandomChoices = new ArrayList<>();
        for (int i = 0; i < choiceCount; i ++){
            int choiceIndex = random.nextInt(votingChoices.size()); // choose a random choice
            voterRandomChoices.add(votingChoices.get(choiceIndex));
            votingChoices.remove(choiceIndex); // to prevent duplicated choices, if a choice has been chosen remove it from all choices
        }
        getVoting(index).vote(voter, voterRandomChoices);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VotingSystem that = (VotingSystem) o;
        return Objects.equals(votingList, that.votingList);
    }
    @Override
    public int hashCode() {
        return Objects.hash(votingList);
    }

}
