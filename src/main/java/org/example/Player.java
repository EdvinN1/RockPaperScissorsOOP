package org.example;

public abstract class Player {

    private Choice choice;
    private int points = 0;

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Player() {}

    public Choice getChoice() {
        return choice;
    }

    public void setChoice(Choice newChoice) {
        this.choice = newChoice;
    }
    public abstract void ChooseOption();
}
