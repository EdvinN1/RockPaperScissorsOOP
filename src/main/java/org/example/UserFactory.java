package org.example;

public class UserFactory implements PlayerFactory {
    @Override
    public Player createPlayer() {
        return new User();
    }
}
