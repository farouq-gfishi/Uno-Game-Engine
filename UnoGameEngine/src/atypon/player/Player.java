package atypon.player;


import atypon.card.Card;

import java.util.ArrayList;
import java.util.List;

public class Player {
    final private String name;
    private List<Card> handCards;

    public Player(String name) {
        this.name = name;
        handCards = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Card> getHandCards() {
        return handCards;
    }

    public void setHandCard(List<Card>cards) {
        this.handCards = cards;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }
}
