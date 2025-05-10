package atypon.behaviour;

import atypon.game.Game;

public class DrawTwoBehaviour implements CardBehaviour {
    @Override
    public void performBehaviour(Game game) {
        game.setNextPlayer();
        System.out.println(game.getCurrentPlayer().getName() + " draw two cards");
        game.drawCardToCurrentPlayer(2);
        game.setNextPlayer();
    }
}
