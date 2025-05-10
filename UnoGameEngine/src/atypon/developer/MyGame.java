package atypon.developer;

import atypon.card.Card;
import atypon.card.CardColor;
import atypon.card.CardValue;
import atypon.game.Game;
import atypon.player.Player;


import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MyGame extends Game {
    public MyGame(List<Player> players, int numberOfCardInHand) {
        super(players, numberOfCardInHand);
    }

    @Override
    public void play() {
        Scanner in = new Scanner(System.in);
        addDanceCard(10);
        while(!gameIsOver()) {
            Card previousTopCard = getTopCardFromDeck();
            Card topCardInTheDeck = getTopCardFromDeck();
            getTurnInformation();
            for(int i=1;i<=3;i++) {
                int choice = in.nextInt();
                if(choice==-1) {
                    if(i<=2) {
                        drawCardToCurrentPlayer();
                        getTurnInformation();
                    }
                    if(i==3) {
                        setNextPlayer();
                    }
                }
                else {
                    topCardInTheDeck = setNewTopCard(choice);
                    handleBehaviour(topCardInTheDeck, previousTopCard);
                    break;
                }
            }
            System.out.println("\nThe top card is " + topCardInTheDeck);
        }
    }

    @Override
    protected void getTurnInformation() {
        // What will display to the end user
        System.out.println("Its " + getNameOfCurrentPlayer() + " turn");
        System.out.println("The color you can play is: " + getValidColor());
        System.out.println("Enter The number of card you want to play");
        for(int i=0;i<getCardsOfCurrentPlayer().size();i++) {
            System.out.println(i + " - " + getCardsOfCurrentPlayer().get(i));
        }
        System.out.println("Or enter -1 to draw a card or skip your turn if you already draw a card");
    }

    @Override
    protected void handleBehaviour(Card topCard, Card previousTopCard) {
        if(validCardToPlay(topCard, previousTopCard)) {
            topCard.getCardBehaviour().performBehaviour(this);
        }
        else {
            throw new IllegalArgumentException();
        }
        if(topCard.getCardColor() != CardColor.WILD) {
            setValidColor(topCard.getCardColor());
        }
    }

    private boolean validCardToPlay(Card topCard, Card previousTopCard) {
        return  topCard.getCardColor() == CardColor.WILD ||
                topCard.getCardColor() == CardColor.SPECIAL ||
                topCard.getCardColor() == previousTopCard.getCardColor() ||
                topCard.getCardValue() == previousTopCard.getCardValue() ||
                topCard.getCardColor() == getValidColor() ||
                previousTopCard.getCardColor() == CardColor.SPECIAL;
    }

    private void addDanceCard(int size) {
        for(int i=1;i<=size;i++) {
           addSpecialCard(new Card(CardColor.SPECIAL, CardValue.SPECIAL, new DanceBehaviour()));
        }
        Collections.shuffle(getPileStock());
    }

}
