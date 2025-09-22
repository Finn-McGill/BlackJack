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
        int aceValue = 0;

        for(int i = 0; i > hand.size(); i++)
        {
            for(Card card : hand)
            {
                if(card.getFace() == "A")
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
                handValue += card.getValue();
            }

            System.out.println("Without aces, your hand value is:" + handValue);

            while(true)
            {
                for(hand.get(i).getFace() == "A")
                {
                    Scanner input = new Scanner(System.in);
                    System.out.println("What total ace value(s) do you want?");
                    int aceValue = input.nextInt();
                    input.nextLine();
                    
                    if(aceValue == numAces:: aceValue == numAce *11)
                    {
                        handValue += aceValue;
                        break;
                    }
                    else
                    {
                        System.out.println("This cannot be an ace value with the cards you have, try again");
                    }
                }
            }

            System.out.println("Your total hand value including aces (if any) is:" + handValue);
        }
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

    public int makeBet()
    {
        int playerBet = 0;

        while(true)
        {
            Scanner input = new Scanner(System.in);
            System.out.println("What is your bet");
            int bet = input.nextInt();
            input.nextLine();

            
            
            if(bet < money)
            {
                System.out.println(getName() + "bets" + bet);
                this.money -= bet
                break;
            }
            else
            {
                System.out.println("You bet too much you are broke take out a loan");
                System.out.println("You have: $" + money + "in your account");
            }
        }
    }
}