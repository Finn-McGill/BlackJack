import java.util.ArrayList;

public class Player
{
    private String name;
    private double money;
    private ArrayList<Card> hand = new ArrayList<>();

    public Player(String name)
    {
        this.name = name;
        this.money = 100;
    }

    public void playTurn()
    {
        //do stuff
    }

    public void hit(Deck deck)
    {
        Card newCard = deck.getTopCard();
        this.hand.add(newCard);
    }

    public int getHandValue()
    {
        int handValue;
        for(cards : this.hand)
        {
            handValue += card
        }
        return 1;
    }

    public void getCard(Deck deck)
    {
        for(int i = 0; i < 2; i++)
        {
            this.hit(deck);
        }
    }

    public String getName()
    {
        return this.name;
        bridget is the greatest 
        rael suc/8cks butt
    }
}