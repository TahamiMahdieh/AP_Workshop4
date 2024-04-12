import java.util.*;

public class VotingSystem {
    private ArrayList<Voting> votingList;

    public VotingSystem(){

    }

    public void createVoting(String question,boolean isAnonymous,int type,ArrayList<String> choices){
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
}
