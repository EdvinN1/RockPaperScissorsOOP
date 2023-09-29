package org.example;

import java.util.Scanner;

public class Game {


private User user;
private Computer computer;
private int playerPoints;
private int computerPoints;

private boolean isRunning = false;
private Scanner scanner;

    public Game() {
        user = new User();
        computer = new Computer();
        scanner = new Scanner(System.in);
        start();
    }
    private void start(){
        isRunning = true;
        System.out.println("Enter your name: ");
        user.setName(scanner.nextLine());

        while(isRunning){
        displaypoints();
        user.ChooseOption();
        computer.ChooseOption();
        displayWinner(determineWinner());
        updatePoints(determineWinner());
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

private void displaypoints(){
    System.out.println(user.getName());
    System.out.println(user.getPoints());
    System.out.println(computer.getName());
    System.out.println(computer.getPoints());
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
            user.setPoints(+1);
        }else if (winner == 2) {
            System.out.println("TIE");
        } else {
            computer.setPoints(+1);
        }
}

}
