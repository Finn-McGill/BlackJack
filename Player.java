import java.util.ArrayList;
import java.util.Scanner;

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

    public void playTurn(Deck deck)
    {
        boolean stay = false;
        
        while(!stay)
        {
            if(getHandValue() <= 21)
            {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Would you like to hit or stay?");
                String action = scanner.nextLine();

                if(action.equals("hit"))
                {
                    hit(deck);
                    System.out.println("Your new hand value is " + getHandValue());
                }
                else
                {
                    stay = true;
                    break;
                }
            }

            else if(getHandValue() > 21)
            {
                System.out.println("Your hand value is more than 21 you lose!");
                stay = true;
                break;
            }
        }
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
        for(Card card : this.hand)
        {
            handValue += card.getValue();
            if(card.getFace().equals("A"))
            {
                numAces++;
            }
        }

        while(handValue > 21 && numAces > 0)
        {
            handValue -= 10;
            numAces--;
        }
        return handValue;
        
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

    public void makeBet()
    {
        int playerBet = 0;

        while(true)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What is " + getName() + "'s bet");
            double makeBet = scanner.nextDouble();
            scanner.nextLine();
            
            if(makeBet <= money && makeBet > 0)
            {
                System.out.println(getName() + " bets " + makeBet);
                this.money -= makeBet;
                break;
            }
            else
            {
                System.out.println("You bet too much/little money you are broke take out a loan");
                System.out.println("You have: $" + money + " in your account");
            }
        }
    }

    public String win(int dealerHand)
    {
        if(dealerHand > playerHand)
        {
            System.out.println("You lost to the dealer you lose all the money you bet");
        }
        else if(dealerHand < playerHand)
        {
            System.out.println("You beat the dealer you win! You get double your bet back!");
            money += (playerBet)*2;
        }
        else
        {
            System.out.println("You tied the dealer. You get your money back")
            money += playerBet;
        }
    }
}