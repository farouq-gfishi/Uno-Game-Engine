package atypon.card;

import atypon.behaviour.CardBehaviour;

public class Card {
    final private CardColor cardColor;
    final private CardValue cardValue;
    final private CardBehaviour cardBehaviour;

    public Card(CardColor cardColor, CardValue cardValue, CardBehaviour cardBehaviour) {
        this.cardColor = cardColor;
        this.cardValue = cardValue;
        this.cardBehaviour = cardBehaviour;
    }

    public CardColor getCardColor() {
        return cardColor;
    }

    public CardValue getCardValue() {
        return cardValue;
    }

    public CardBehaviour getCardBehaviour() {
        return cardBehaviour;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardColor=" + cardColor +
                ", cardValue=" + cardValue +
                '}';
    }

}
