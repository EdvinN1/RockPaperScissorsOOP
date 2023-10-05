package org.example;

import java.util.List;
import java.util.Scanner;

public class DisplayMenu {
    Scanner scanner = new Scanner(System.in);
    private Game game;

    public void setGame(Game game) {
        this.game = game;
    }

    public void handleUserInput() {
    while (true) {
        showMenu();
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                game.start();
                break;
            case 2:
                displayGameHistory();
                break;
            case 3:

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
    private void showMenu(){
        System.out.println("Choose an option: ");
        System.out.println("1. Start a game");
        System.out.println("2. View history");
        System.out.println("3. View statistics");
        System.out.println("4. Exit program");
    }
    private void displayGameHistory() {
        MatchHistory matchHistory = game.getMatchHistory();
        List<List<SaveRound>> allMatches = matchHistory.getAllMatches();

        for (int i = 0; i < allMatches.size(); i++) {
            System.out.println("Game " + (i + 1) + ":");

            List<SaveRound> currentGame = allMatches.get(i);
            for (SaveRound round : currentGame) {
                System.out.println(round);
            }

            System.out.println("End of Game " + (i + 1) + "\n");
        }
    }

}
