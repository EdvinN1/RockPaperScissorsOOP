package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PlayerFactory userFactory = new UserFactory();
        PlayerFactory computerFactory = new ComputerFactory();

        Game game = new Game(userFactory, computerFactory);
        game.start();

    }
}