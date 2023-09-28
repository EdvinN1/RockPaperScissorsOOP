package org.example;

import java.util.Random;

public class Computer extends Player{

    private String name = "Computer";

    @Override
    public void ChooseOption() {
        Random random = new Random();

        int randomNumber = random.nextInt(3) + 1;
        switch (randomNumber){
            case 1:
                setChoice(Choice.ROCK);
                break;
            case 2:
                setChoice(Choice.PAPER);
                break;
            case 3:
                setChoice(Choice.SCISSORS);
                break;
        }
    }
}
