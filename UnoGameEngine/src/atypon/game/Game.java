package atypon.game;

import atypon.behaviour.NumberedBehaviour;
import atypon.card.Card;
import atypon.card.CardColor;
import atypon.deck.Deck;
import atypon.player.Player;

import java.util.List;

public abstract class Game {
    final private List<Player> players;
    final private Deck deck;
    private Player currentPlayer;
    private CardColor validColor;

    public Game(List<Player>players,  int numberOfCardInHand) {
        this.deck = Deck.getInstance();
        this.players = players;
        this.currentPlayer = players.get(0);
        this.validColor = getTopCardFromDeck().getCardColor();
        setup(numberOfCardInHand);
    }

    public abstract void play();

    protected abstract void getTurnInformation();

    protected abstract void handleBehaviour(Card topCard, Card previousTopCard);

    protected void addSpecialCard(Card card) {
        getDeck().addSpecialCardToGame(card);
    }
    
    protected boolean gameIsOver() {
        for(Player player:players) {
            if(player.getHandCards().size()==0) {
                System.out.println("Winner is " + player.getName());
                return true;
            }
        }
        return false;
    }

    protected void removeCardFromCurrentPlayer(Card card) {
        currentPlayer.getHandCards().remove(card);
    }

    protected void sayUno(Player player) {
        if(player.getHandCards().size()==1) {
            System.out.println(player.getName() + " says UNO!");
        }
    }

    protected Card drawCardToCurrentPlayer() {
        Card card = deck.drawCardFromPileStock();
        currentPlayer.getHandCards().add(card);
        return card;
    }

    protected void setTopCardInDeck(Card card) {
        deck.setTopCard(card);
        notifyPlayer();
    }

    protected void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    protected Card setNewTopCard(int index) {
        Card topCard = getCardsOfCurrentPlayer().get(index);
        setTopCardInDeck(topCard);
        removeCardFromCurrentPlayer(topCard);
        sayUno(getCurrentPlayer());
        return topCard;
    }

    protected CardColor getValidColor() {
        return validColor;
    }

    protected Deck getDeck() {
        return deck;
    }

    protected Card getTopCardFromDeck() {
        return deck.getTopCard();
    }

    protected String getNameOfCurrentPlayer() {
        return currentPlayer.getName();
    }

    protected List<Card> getCardsOfCurrentPlayer() {
        return currentPlayer.getHandCards();
    }

    protected List<Card> getPileStock() {
        return deck.getPileStock();
    }

    public void setValidColor(CardColor validColor) {
        this.validColor = validColor;
    }

    public void setNextPlayer() {
        int index = getPlayers().indexOf(getCurrentPlayer());
        if( index == getPlayers().size()-1) {
            setCurrentPlayer(getPlayers().get(0));
        }
        else {
            setCurrentPlayer(getPlayers().get(index+1));
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void drawCardToCurrentPlayer(int numberOfCardToDraw) {
        for(int i=1;i<=numberOfCardToDraw;i++) {
            currentPlayer.getHandCards().add(deck.drawCardFromPileStock());
        }
    }

    private void setup(int numberOfCardInHand) {
        checkForExceptions();
        notifyPlayer();
        System.out.println("The order of players in the game is: " + players.toString() + '\n');
        setPlayerCard(numberOfCardInHand);
        if(getColorOfTopCard()==CardColor.WILD) {
            getTurnInformation(); // what developer implement will display here
        }
        if(!(deck.getTopCard().getCardBehaviour() instanceof NumberedBehaviour)) {
            deck.getTopCard().getCardBehaviour().performBehaviour(this);
        }
    }

    private void setPlayerCard(int numberOfCards) {
        for(Player player:players) {
            player.setHandCard(deck.drawCardsFromPileStock(numberOfCards));
        }
    }

    private CardColor getColorOfTopCard() {
        return getDeck().getTopCard().getCardColor();
    }

    private void checkForExceptions() {
        if(players.size()<2 || players.size()>10) {
            throw  new IllegalArgumentException("Number of players must be between [2,10]");
        }
        if(getCardsOfCurrentPlayer().size() * players.size() > 108) {
            throw new IllegalArgumentException("Total number of card must be no more than 108");
        }
    }

    private void notifyPlayer() {
        for(Player player : players) {
            System.out.println("Message for " +  player + " the top card is " + getTopCardFromDeck() );
        }
    }


}
