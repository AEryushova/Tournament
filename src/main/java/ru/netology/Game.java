package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> registeredPlayers = new ArrayList<Player>();


    public void register(Player player) {
        registeredPlayers.add(player);
    }


    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;
        for (Player name : registeredPlayers) {
            if (name.getName().equals(playerName1)) {
                player1 = name;
            }
            if (name.getName().equals(playerName2)) {
                player2 = name;
            }
        }
        if (player1 == null) {
            throw new NotRegisteredException(" Player: " + playerName2 + " not registered ");
        }
        if (player2 == null) {
            throw new NotRegisteredException(" Player: " + playerName2 + " not registered ");
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        return 0;
    }
}