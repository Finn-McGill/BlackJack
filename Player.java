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
        
        while(stay = false)
        {
            System.out.println(getName() + "'s hand value is" + getHandValue());

            if(getHandValue() <= 21)
            {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Would you like to hit or stay?");
                String action = scanner.nextLine();

                if(action == "hit")
                {
                    hit(deck);
                    System.out.println("Your new hand value is:" + getHandValue());
                }
                else
                {
                    stay = true;
                }
            }

            else if(getHandValue() > 21)
            {
                System.out.println("Your hand value is more than 21 you lose!");
                stay = true;
            }

            break;
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
        int aceValue = 0;

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

        for(Card card : hand)
        {
            if(!card.getFace(card).equals( "A"))
            {
                handValue += card.getValue(card);
                System.out.println("Without aces, your hand value is:" + handValue);
            }

            else if(card.getFace(card).equals("A"))
            {
                for(int i; i <= numAces; i++)
                {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("For Ace # " + i + ", what total ace value do you want?");
                    int aceValue = scanner.nextInt();
                    scanner.nextLine();

                    if(aceValue == numAces || aceValue == numAces *11)
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

    public void makeBet()
    {
        int playerBet = 0;

        while(true)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What is your bet");
            double makeBet = scanner.nextDouble();
            scanner.nextLine();
            
            if(makeBet <= money && makeBet > 0)
            {
                System.out.println(getName() + "bets" + makeBet);
                this.money -= makeBet;
                break;
            }
            else
            {
                System.out.println("You bet too much/little money you are broke take out a loan");
                System.out.println("You have: $" + money + "in your account");
            }
        }
    }
}