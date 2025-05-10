package atypon.behaviour;

import atypon.game.Game;

import java.util.Collections;

public class ReverseBehaviour implements CardBehaviour {
    @Override
    public void performBehaviour(Game game) {
        System.out.println("The game is reversed");
        System.out.println("The order of players before reversed: " + game.getPlayers());
        Collections.reverse(game.getPlayers());
        System.out.println("The order of players after reversed: " + game.getPlayers());
        game.setNextPlayer();
    }
}
