package org.example;

import java.util.Random;

public class NameBasedComputer extends Player {
    @Override
    public void ChooseOption() {

        String userName = getName().toLowerCase();

        if (userName.contains("a")) {
            System.out.println("Choosing ROCK");
            setChoice(Choice.ROCK);
        } else if (userName.contains("e")) {
            System.out.println("Choosing PAPER");
            setChoice(Choice.PAPER);
        } else if (userName.contains("o")) {
            System.out.println("Choosing SCISSORS");
            setChoice(Choice.SCISSORS);
        } else {
            Random random = new Random();
            int randomIndex = random.nextInt(Choice.values().length);
            System.out.println("Choosing random choice: " + Choice.values()[randomIndex]);
            setChoice(Choice.values()[randomIndex]);
        }

    }
}



