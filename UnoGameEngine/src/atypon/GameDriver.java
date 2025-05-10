package atypon;

import atypon.game.Game;
import atypon.developer.MyGame;
import atypon.player.Player;

import java.util.ArrayList;

public class GameDriver {
    public static void main(String[]args) {
        Game game = new MyGame(new ArrayList<Player>() {
            {
                add(new Player("Farooq"));
                add(new Player("Omar"));
                add(new Player("Jad"));
            }
         }, 7);
        game.play();
    }

}
