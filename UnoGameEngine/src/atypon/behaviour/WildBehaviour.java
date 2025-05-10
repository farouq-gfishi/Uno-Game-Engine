package atypon.behaviour;

import atypon.card.CardColor;
import atypon.game.Game;

import java.util.Scanner;


public class WildBehaviour implements CardBehaviour {
    @Override
    public void performBehaviour(Game game) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the color you want:");
        System.out.println("1 - RED");
        System.out.println("2 - GREEN");
        System.out.println("3 - BLUE");
        System.out.println("4 - YELLOW");
        int choice = in.nextInt();
        if(choice==1) {
            game.setValidColor(CardColor.RED);
        }
        else if(choice==2) {
            game.setValidColor(CardColor.GREEN);
        }
        else if(choice==3) {
            game.setValidColor(CardColor.BLUE);
        }
        else if(choice==4) {
            game.setValidColor(CardColor.YELLOW);
        }
        else {
            throw new IllegalArgumentException();
        }
        game.setNextPlayer();
    }
}
