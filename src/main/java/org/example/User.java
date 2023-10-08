package org.example;

import java.util.Scanner;

public class User extends Player {

    private final Scanner userInput;
    private String name;

    public User() {
        userInput = new Scanner(System.in);
    }

    @Override
    public void ChooseOption() {
        while (true) {
            System.out.println("Choose: Rock, Paper, or Scissors");
            String input = userInput.nextLine().toUpperCase();

            try {
                Choice choice = Choice.valueOf(input);
                setChoice(choice);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("That is not a valid option. Please try again.");
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
