package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Player user;
    private Player computer;
    private String PvsC;
    private MatchHistory matchHistory;
    private boolean isRunning = false;
    private List<SaveRound> roundResults; // Use SaveRound for detailed round results
    private int currentGameNumber;
    private Scanner scanner;

    public MatchHistory getMatchHistory() {
        return matchHistory;
    }
    public Game(PlayerFactory userFactory, PlayerFactory computerFactory) {
        user = userFactory.createPlayer();
        computer = computerFactory.createPlayer();
        scanner = new Scanner(System.in);
        matchHistory = new MatchHistory();
        roundResults = new ArrayList<>();
    }

    public void start() {
        isRunning = true;
        System.out.println("Enter your name: ");
        String userName = scanner.nextLine();

        if (userName == null || userName.trim().isEmpty()) {
            System.out.println("Please enter a valid name to start the game.");
            return;
        }

        user.setName(userName);

        System.out.println("Enter the number of rounds to play: ");
        int roundsToWin = scanner.nextInt();
        scanner.nextLine();

        List<SaveRound> roundResults = new ArrayList<>();

        while (isRunning) {
            user.ChooseOption();
            computer.ChooseOption();
            int winner = determineWinner();
            updatePoints(winner);
            displayPoints();
            SaveRound roundResult = new SaveRound(
                    user.getName(),
                    computer.getName(),
                    user.getChoice().toString(),
                    computer.getChoice().toString(),
                    PvsC,
                    "HEj"
            );
            roundResults.add(roundResult);

            if (user.getPoints() == roundsToWin || computer.getPoints() == roundsToWin) {
                isRunning = false;
                displayFinalScore();
                matchHistory.newGameHistory(new ArrayList<>(roundResults));
                displayAllRoundResults();

                user.setPoints(0);
                computer.setPoints(0);

                currentGameNumber++;

            }
            
        }


    }
    public void displayAllRoundResults() {
        int gameNumber = currentGameNumber;
        System.out.println("Detailed Round Results for Game " + gameNumber + ":");

        List<SaveRound> roundResults = this.roundResults;
        for (int i = 0; i < roundResults.size(); i++) {
            System.out.println("Round " + (i + 1) + ":");
            System.out.println(roundResults.get(i));
            matchHistory.addRounds(gameNumber, roundResults.get(i));
        }

        System.out.println("End of Game " + gameNumber + ".\n");
    }

    private int determineWinner() {
        if (
                user.getChoice() == Choice.ROCK && computer.getChoice() == Choice.SCISSORS ||
                        user.getChoice() == Choice.PAPER && computer.getChoice() == Choice.ROCK ||
                        user.getChoice() == Choice.SCISSORS && computer.getChoice() == Choice.PAPER
        ) {
            return 1;

        } else if (
                user.getChoice() == computer.getChoice()
        ) {
            return 2;
        } else {
            return 3;
        }
    }

    private void displayPoints() {
        PvsC = user.getPoints() + " - " + computer.getPoints();
        System.out.println(PvsC);
    }

    private void displayFinalScore() {
        System.out.println("Final Score: " + user.getPoints() + " - " + computer.getPoints());
        if (user.getPoints() > computer.getPoints()) {
            System.out.println(user.getName() + " won the game!");
        } else if (user.getPoints() < computer.getPoints()) {
            System.out.println("Computer won the game!");
        }
    }

    private void displayWinner(int winner) {
        switch (winner) {
            case 1:
                System.out.println("User won!");
                break;
            case 2:
                System.out.println("It's a tie!");
                break;
            case 3:
                System.out.println("Computer won!");

        }
    }

    private void updatePoints(int winner) {
        if (winner == 1) {
            user.setPoints(user.getPoints() + 1);
        } else if (winner == 2) {
            System.out.println("TIE");
        } else {
            computer.setPoints(computer.getPoints() + 1);
        }
    }

    public void setOpponentFactory(PlayerFactory opponentFactory) {
    }
}
