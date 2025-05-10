package atypon.deck;

import atypon.behaviour.*;
import atypon.card.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck  {

    protected static Deck deckInstance;
    private List<Card> discardCard;
    private List<Card> pileStock;
    private DeckFactory deckFactory;
    private Card topCard;

    private Deck() {
        discardCard = new ArrayList<>();
        pileStock = new ArrayList<>();
        deckFactory = new DeckFactory(this);
        deckFactory.setup();
        Collections.shuffle(pileStock);
        topCard = pileStock.remove(0);
        System.out.println("\nThe top card is " + getTopCard());
    }

    public static Deck getInstance() {
        if(deckInstance==null) {
            deckInstance = new Deck();
        }
        return deckInstance;
    }

    public Card drawCardFromPileStock() {
        if(pileStock.size()==0) {
            resetPileStock();
        }
        Card card = pileStock.get(0);
        pileStock.remove(0);
        discardCard.add(card);
        return card;
    }

    public List<Card> drawCardsFromPileStock(int numberOfCardToDraw) {
        if(numberOfCardToDraw<=0) {
            throw new IllegalArgumentException();
        }
        if(pileStock.size()<numberOfCardToDraw) {
            resetPileStock();
        }
        List<Card>cards = new ArrayList<>();
        for(int i=1;i<=numberOfCardToDraw;i++) {
            Card card = pileStock.get(0);
            pileStock.remove(0);
            cards.add(card);
        }
        pileStock.removeAll(cards);
        discardCard.addAll(cards);
        return cards;
    }

    public void addSpecialCardToGame(Card card) {
        pileStock.add(card);
    }

    public Card getTopCard() {
        return topCard;
    }

    public void setTopCard(Card topCard) {
        this.topCard = topCard;
    }

    public List<Card> getPileStock() {
        return pileStock;
    }

    private void resetPileStock() {
        discardCard.addAll(pileStock);
        pileStock.clear();
        pileStock.addAll(discardCard);
        discardCard.clear();
        discardCard.add(topCard);
        pileStock.remove(topCard);
        Collections.shuffle(pileStock);
    }

}
