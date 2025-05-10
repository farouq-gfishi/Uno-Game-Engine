package atypon.behaviour;

import atypon.card.CardColor;
import atypon.game.Game;

import java.util.Scanner;

public class WildDrawFourBehaviour implements CardBehaviour {
    @Override
    public void performBehaviour(Game game) {
        new WildBehaviour().performBehaviour(game);
        System.out.println(game.getCurrentPlayer().getName() + " draw four cards");
        game.drawCardToCurrentPlayer(4);
        game.setNextPlayer();
    }
}
