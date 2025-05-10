package atypon.deck;

import atypon.behaviour.*;
import atypon.card.Card;
import atypon.card.CardColor;
import atypon.card.CardValue;


public class DeckFactory {

    private Deck deck;
    public DeckFactory(Deck deck) {
        this.deck = deck;;
    }

    public void setup() {
        createNumberedCards();
        createActionCards();
        createWildCards();
    }

    private void createNumberedCards() {
        CardValue[] cardValue = CardValue.values();
        CardColor[] cardColor = CardColor.values();
        for(int i=0;i<4;i++) {
            deck.getPileStock().add(new Card(cardColor[i], cardValue[0], new NumberedBehaviour()));
            for(int j=1;j<=9;j++) {
                deck.getPileStock().add(new Card(cardColor[i], cardValue[j], new NumberedBehaviour()));
                deck.getPileStock().add(new Card(cardColor[i], cardValue[j], new NumberedBehaviour()));
            }
        }
    }

    private void createActionCards() {
        CardColor[] cardColor = CardColor.values();
        for(int i=0;i<4;i++) {
            for (int j = 1; j <= 2; j++) {
                deck.getPileStock().add(new Card(cardColor[i], CardValue.SKIP, new SkipBehaviour()));
                deck.getPileStock().add(new Card(cardColor[i], CardValue.REVERSE, new ReverseBehaviour()));
                deck.getPileStock().add(new Card(cardColor[i], CardValue.DRAW_TWO, new DrawTwoBehaviour()));
            }
        }
    }

    private void createWildCards() {
        for(int i=1;i<=4;i++) {
            deck.getPileStock().add(new Card(CardColor.WILD, CardValue.WILD, new WildBehaviour()));
            deck.getPileStock().add(new Card(CardColor.WILD, CardValue.WILD_DRAW_FOUR, new WildDrawFourBehaviour()));
        }
    }
}
