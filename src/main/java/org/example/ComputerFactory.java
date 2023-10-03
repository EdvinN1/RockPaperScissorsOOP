package org.example;

public class ComputerFactory implements PlayerFactory {
    @Override
    public Player createPlayer() {
        return new Computer();
    }
}
