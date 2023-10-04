package org.example;

import java.util.ArrayList;
import java.util.List;

public class MatchHistory {
    private List<List<SaveRound>> allMatches;

    public MatchHistory() {
        allMatches = new ArrayList<>();
    }

    public void newGameHistory() {
        allMatches.add(new ArrayList<>());
    }

    public void addRounds(SaveRound round) {
        if (!allMatches.isEmpty()) {
            List<SaveRound> currentMatch = allMatches.get(allMatches.size() - 1);
            currentMatch.add(round);
        }
    }

    public void printAllGames() {
        for (int i = 0; i < allMatches.size(); i++) {
            System.out.println("Game " + (i + 1) + ":");

            List<SaveRound> currentGame = allMatches.get(i);
            for (SaveRound round : currentGame) {
                System.out.println(round);
            }

            System.out.println("End of Game " + (i + 1) + "\n");
        }
    }

    public List<List<SaveRound>> getAllMatches() {
        return allMatches;
    }

}
