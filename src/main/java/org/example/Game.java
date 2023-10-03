package org.example;

import java.util.Scanner;

public class Game {
    private Player user;
    private Player computer;


private boolean isRunning = false;
private Scanner scanner;

    public Game(PlayerFactory userFactory, PlayerFactory computerFactory) {
        user = userFactory.createPlayer();
        computer = computerFactory.createPlayer();
        scanner = new Scanner(System.in);
        start();
    }
    public void start(){
        isRunning = true;
        System.out.println("Enter your name: ");
        String userName = scanner.nextLine();

        if (userName == null || userName.trim().isEmpty()) {
            System.out.println("Please enter a valid name to start the game.");
            return;  // Exit the method if the user hasn't entered a name
        }

        user.setName(userName);

        System.out.println("Enter the number of rounds to play: ");
        int roundsToWin = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        while(isRunning){

        displayPoints();
        user.ChooseOption();
        computer.ChooseOption();
        displayWinner(determineWinner());
        updatePoints(determineWinner());
            if (user.getPoints() != roundsToWin || computer.getPoints() != roundsToWin) {
                isRunning = false;
                displayFinalScore();
                break;
            }

        }
    }
    private int determineWinner(){
        if(
                user.getChoice() == Choice.ROCK && computer.getChoice() == Choice.SCISSORS ||
                        user.getChoice() == Choice.PAPER && computer.getChoice() == Choice.ROCK ||
                        user.getChoice() == Choice.SCISSORS && computer.getChoice() == Choice.PAPER
        ){
            return 1;

        } else if (
                user.getChoice() == computer.getChoice()
    ){
        return 2;
        }else {
            return 3;
        }
}

/*private void displaypoints(){
    //System.out.println(user.getName());
    System.out.println(user.getPoints());
    //System.out.println(computer.getName());
    System.out.println(computer.getPoints());
}*/
private void displayPoints() {
    System.out.println(user.getPoints() + " - " + computer.getPoints());
}
    private void displayFinalScore() {
        System.out.println("Final Score: " + user.getPoints() + " - " + computer.getPoints());
        if (user.getPoints() > computer.getPoints()) {
            System.out.println(user.getName() + " won the game!");
        } else if (user.getPoints() < computer.getPoints()) {
            System.out.println("Computer won the game!");
        }
    }
private void displayWinner(int winner){
        switch(winner) {
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
private void updatePoints (int winner) {
        if(winner == 1) {
            user.setPoints(user.getPoints() + 1);
        }else if (winner == 2) {
            System.out.println("TIE");
        } else {
            computer.setPoints(computer.getPoints() + 1);
        }
}

}
