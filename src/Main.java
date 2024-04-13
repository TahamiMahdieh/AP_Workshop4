import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Voting v1 = new Voting(0,"Canceling class" , true);
        Voting v2 = new Voting(0, "Pizza for dinner?", false);
        Voting v3 = new Voting(0, "time of exam?", false);
        v1.createChoice("yes");
        v1.createChoice("no");
        v2.createChoice("yes");
        v2.createChoice("no");
        v3.createChoice("12:00 - 14:00");
        v3.createChoice("15:00 - 17:00");
        v3.createChoice("08:00 - 10:00");

        ArrayList<Voting> votings = new ArrayList<>();
        votings.add(v1);
        votings.add(v2);
        votings.add(v3);
        VotingSystem newPoll = new VotingSystem(votings);

        Person voter1 = new Person("Hasan", "Alavi");
        Person voter2 = new Person("Omid", "Mohammadi");
        Person voter3 = new Person("Reza", "Kiani");

        ArrayList<String> voter1Choices = new ArrayList<>();
        ArrayList<String> voter2Choices = new ArrayList<>();
        ArrayList<String> voter3Choices = new ArrayList<>();
        voter1Choices.add("no");
        voter2Choices.add("yes");
        voter3Choices.add("08:00 - 10:00");
        voter3Choices.add("15:00 - 17:00");

        newPoll.getVoting(0).vote(voter1);
        newPoll.getVoting(0).vote(voter3);
        newPoll.getVoting(1).vote(voter2, voter2Choices);
        newPoll.getVoting(1).vote(voter1, voter1Choices);
        newPoll.getVoting(2).vote(voter2, voter3Choices);

        for (Voting v : newPoll.getVotingList()){
            v.printVoters();
            v.printResults();
        }

    }

}