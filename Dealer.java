public class Dealer extends Player
{
    public Dealer()
    {
        super("Robert");
    }

    public void action()
    {
        int dealerHand = player.getHandValue();
        boolean hard18 = false;

        player.getCard(deck);

        while(dealerHand < 18)
        {
            this.hit(deck);
        }

        if(dealerHand >= 18 && hand != "A")
        {
            System.out.println("The dealer has a hand value of: " + dealerHand);
            hard18 = true;
            return dealerHand;
        }
        else if(dealerHand >= 18 && numAces > 0)
        {
            dealerHand -= 10;
            numAces--;
            
            return dealerHand;

            player.playTurn();
        }

        

    }

}