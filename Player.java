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
        int handValue = 0;
        int numAces = 0;

        for(int i = 0; i > hand.size(); i++)
        {
            for(Card card : hand)
            {
                if(card.getFace(card) == "A")
                {
                    numAces += 1;
                }
            }
        }
        
        System.out.println("You have" + numAces + "aces");

        for(int  i = 0; i > hand.size(); i++)
        {
            if(hand.get(i).getFace() != "A")
            {
                handValue += Card.getValue(card);
            }

            for(hand.get(i).getFace() == "A")
            {
                
            }
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
    }
}