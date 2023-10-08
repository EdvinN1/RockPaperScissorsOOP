package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DisplayMenu {
    Scanner scanner = new Scanner(System.in);
    private Game game;

    public void setGame(Game game) {
        this.game = game;
    }

    private List<PlayerFactory> opponentFactories = new ArrayList<>();

    public void addOpponentFactory(PlayerFactory opponentFactory) {
        opponentFactories.add(opponentFactory);
    }

    public void handleUserInput() {
        while (true) {
            showMainMenu();
            int mainChoice = scanner.nextInt();
            scanner.nextLine();

            switch (mainChoice) {
                case 1:
                    handleNewGameSubMenu();
                    break;
                case 2:
                    displayGameHistory();
                    break;
                case 3:
                    // Option 3 logic
                    break;
                case 4:
                    System.out.println("Exiting the program");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private void showMainMenu() {
        System.out.println("Choose an option: ");
        System.out.println("1. Start a game");
        System.out.println("2. View history");
        System.out.println("3. View statistics");
        System.out.println("4. Exit program");
    }

    private void handleNewGameSubMenu() {
        System.out.println("Choose an opponent: ");
        System.out.println("1. Slumpis");
        System.out.println("2. Namnis");
        System.out.println("3. Klockis");

        int opponentChoice = scanner.nextInt();
        scanner.nextLine();

        PlayerFactory opponentFactory;

        switch (opponentChoice) {
            case 1:
                opponentFactory = new ComputerFactory();
                break;
            case 2:
                opponentFactory = new NameBasedComputerFactory();
                break;
            case 3:
                opponentFactory = new TimeBasedComputerFactory();
                break;
            default:
                System.out.println("Invalid choice. Using Random Opponent by default.");
                opponentFactory = new ComputerFactory();
                break;
        }


        game.setOpponentFactory(opponentFactory);
        game.start();
    }

    private void displayGameHistory() {
        MatchHistory matchHistory = game.getMatchHistory();
        List<List<SaveRound>> allMatches = matchHistory.getAllMatches();

        if (allMatches.isEmpty()) {
            System.out.println("No game history available.");
            return;
        }

        for (int i = 0; i < allMatches.size(); i++) {
            System.out.println("Game " + (i + 1) + ":");

            List<SaveRound> currentGame = allMatches.get(i);
            currentGame.stream()
                    .forEach(System.out::println);

            System.out.println("End of Game " + (i + 1) + "\n");
        }
    }
}
