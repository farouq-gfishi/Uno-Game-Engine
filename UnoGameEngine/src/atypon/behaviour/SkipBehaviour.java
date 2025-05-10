package atypon.behaviour;

import atypon.game.Game;

public class SkipBehaviour implements CardBehaviour {
    @Override
    public void performBehaviour(Game game) {
        game.setNextPlayer();
        System.out.println(game.getCurrentPlayer() + " is skipped");
        game.setNextPlayer();
    }
}
