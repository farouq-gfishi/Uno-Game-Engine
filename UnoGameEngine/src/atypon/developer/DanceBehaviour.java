package atypon.developer;

import atypon.behaviour.CardBehaviour;
import atypon.game.Game;

public class DanceBehaviour implements CardBehaviour {
    @Override
    public void performBehaviour(Game game) {
        game.setNextPlayer();
        System.out.println(game.getCurrentPlayer() + " dance now");
        game.setNextPlayer();
    }
}
