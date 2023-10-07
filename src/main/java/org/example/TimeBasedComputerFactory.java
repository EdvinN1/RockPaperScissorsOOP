package org.example;

public class TimeBasedComputerFactory implements PlayerFactory{
    @Override
    public Player createPlayer() {
        return new TimeBasedComputer();
    }
}
