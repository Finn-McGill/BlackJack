import java.util.ArrayList;

public class Dealer extends Player
{
    private int numAces = 0;
    ArrayList<Card> hand = getHand();

    public Dealer()
    {
        super("Robert");
    }

    public int dealerHandValue()
    {
        int dealerHandValue = 0;
        int numAces = 0;
        for(Card card : this.hand)
        {
            dealerHandValue += card.getValue();
            if(card.getFace().equals("A"))
            {
                numAces++;
                return numAces;
            }
        }
        return dealerHandValue;
    }
    public int action(Deck deck)
    {
        int dealerHand = dealerHandValue();
        boolean hard17 = false;

        while(dealerHand < 17)
        {
            hit(deck);
            dealerHand = dealerHandValue();
        }

        if(dealerHand >= 17 && numAces == 0)
        {
            System.out.println("The dealer has a hand value of: " + dealerHand);
            hard17 = true;
            return dealerHand;
        }
        
        while(dealerHand > 21 && numAces > 0)
        {
            dealerHand -= 10;
            numAces--;
    
            hit(deck);

            while(dealerHand < 17)
            {
                hit(deck);
            }
        }

        return dealerHand;
    }

}