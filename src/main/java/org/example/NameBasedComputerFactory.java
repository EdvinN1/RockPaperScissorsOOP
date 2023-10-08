package org.example;

public class NameBasedComputerFactory implements PlayerFactory {
    @Override
    public Player createPlayer() {
        return new NameBasedComputer();
    }
}