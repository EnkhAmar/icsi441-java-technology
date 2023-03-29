package assignment5;

// @student: G.Enkh-Amar
/*
Сонгуульд n нэр дэвшигч оролцоно. Та өөрийн дэмждэг  нэр  дэвшигчээ (бусад  нэр дэвшигчдээс илүү олон санал авч) ялалт байгуулахыг хүсч байгаа. Нэг сонгогчийн саналыг s төгрөгөөр өөрчилж болно. Энэ сонгуулийн компанит ажлыг амжилтад хүргэхэд ямар хэмжээний мөнгө шаардлагатай вэ?
 */

import java.util.HashMap;
import java.util.Random;

public class Election {
    int numOfCandidates;
    int numOfVoters;
    double costPerVote;
    int minVotesToWin;
    HashMap<String, Integer> currentVotes;

    public Election(String[] candidates, int numOfVoters, double costPerVote) {
        this.numOfCandidates = candidates.length;
        this.numOfCandidates = numOfCandidates;
        this.numOfVoters = numOfVoters;
        this.costPerVote = costPerVote;
        this.minVotesToWin = numOfVoters / 2 + 1;
        this.currentVotes = new HashMap<>();
        for (String candidate : candidates) {
            currentVotes.put(candidate, 0);
        }
    }

    public void vote(String candidate) {
        int votes = currentVotes.get(candidate) + 1;
        this.currentVotes.put(candidate, votes);
    }

    public double calculateCostToWin(String candidate) {
        int swingVoters = minVotesToWin - currentVotes.get(candidate);
        return swingVoters * costPerVote;
    }

    public static void main(String[] args) {
        String[] candidates = {"CandidateA", "CandidateB", "CandidateC"};
        Election election = new Election(candidates, 100, 500);

        Random random = new Random();
        for (int i = 0; i < election.numOfVoters; i++) {
            election.vote(candidates[random.nextInt(candidates.length)]);
        }
        System.out.println(election.calculateCostToWin(candidates[1]) + " is needed to make win " + candidates[1]);
    }
}
