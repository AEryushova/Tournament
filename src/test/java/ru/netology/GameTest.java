package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GameTest {

    Player player1 = new Player(12, "Masha", 70);
    Player player2 = new Player(78, "Katya", 35);
    Player player3 = new Player(44, "Dima", 90);
    Player player4 = new Player(95, "Gena", 90);
    Player player5 = new Player(95, "Dasha", 30);

    Game game = new Game();

    @Test
    public void roundWhenTheFirstPlayerIsStronger() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        int expected = 1;
        int actual = game.round("Masha", "Katya");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundWhenTheSecondPlayerIsStronger() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        int expected = 2;
        int actual = game.round("Katya", "Dima");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundWhenTheStrengthsOfThePlayersAreEqual() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
        int expected = 0;
        int actual = game.round("Dima", "Gena");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void roundWhenTheFirstPlayerIsNotRegistreted() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Dasha", "Katya");
        });
    }

    @Test
    public void roundWhenTheSecondPlayerIsNotRegistreted() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Gena", "Dasha");
        });
    }

    @Test
    public void roundWhenTheBothPlayersIsNotRegistreted() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Katya", "Dasha");
        });
    }
}
