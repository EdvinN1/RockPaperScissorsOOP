package org.example;

import java.util.Scanner;

public class User extends Player {

    private Scanner userInput;
    private String name;


    public User() {
        userInput = new Scanner(System.in);
    }

    @Override
    public void ChooseOption() {
        System.out.println("Choose: Rock, Paper or Scissors");
        setChoice(Choice.valueOf(userInput.nextLine().toUpperCase()));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
