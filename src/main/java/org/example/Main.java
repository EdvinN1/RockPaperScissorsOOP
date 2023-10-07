package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PlayerFactory userFactory = new UserFactory();
        PlayerFactory computerFactory = new ComputerFactory();
        PlayerFactory nameBasedComputerFactory = new NameBasedComputerFactory();
        PlayerFactory timeBasedComputerFactory = new TimeBasedComputerFactory();

        Game game = new Game(userFactory, computerFactory);
        DisplayMenu displayMenu = new DisplayMenu();
        displayMenu.setGame(game);


        displayMenu.addOpponentFactory(nameBasedComputerFactory);
        displayMenu.addOpponentFactory(timeBasedComputerFactory);

        displayMenu.handleUserInput();
    }
}
