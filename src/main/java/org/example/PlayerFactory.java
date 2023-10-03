package org.example;

public interface PlayerFactory {
    Player createPlayer();
}


/* To introduce the Factory Pattern in your code, you can create a PlayerFactory that encapsulates the creation of User and Computer instances.
This way, your Game class or any other client code can create players without needing to know the details of their creation.

With this setup, you can easily extend your system by creating new player types and corresponding factories without modifying the Game class.
The Game class remains agnostic about the specific types of players.

This approach adheres to the Factory Pattern, as the creation of objects is delegated to a factory interface (PlayerFactory),
and you have concrete factories (UserFactory and ComputerFactory) for creating instances of concrete products (User and Computer).
 */