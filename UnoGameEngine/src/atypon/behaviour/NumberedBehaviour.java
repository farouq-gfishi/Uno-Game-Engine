package atypon.behaviour;

import atypon.game.Game;

public class NumberedBehaviour extends DrawTwoBehaviour implements CardBehaviour {
    @Override
    public void performBehaviour(Game game) {
        game.setNextPlayer();
    }
}
