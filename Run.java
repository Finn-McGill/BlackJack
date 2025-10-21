import java.util.Scanner;
import java.util.ArrayList;

public class Run {
    public static void main(String[] args) {
        Deck deck = new Deck();

        for(Card card : deck.getCards())
        {
            System.out.println(card);
        }

        ArrayList<Player> totPlayers = new ArrayList<>();
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many players do you want?");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();

        for(int i = 0; i < numPlayers; i++)
        {
            System.out.println("What is player" + (i + 1) + "'s name?");
            String name = scanner.nextLine();

            Player player = new Player(name);
            totPlayers.add(player);
        }
        Dealer dealer = new Dealer();

        deck.shuffle();

        for(Player player : totPlayers)
        {
            player.makeBet();
        }

        for(Player player : totPlayers)
        {
            player.getCard(deck);
            player.getHandValue();
            System.out.println(player.getName() + " has a hand value of " + player.getHandValue());
            player.playTurn(deck);
        }

            dealer.getCard(deck);
            dealer.action(deck);

        for(Player player : totPlayers)
        {
            if((dealer.getHandValue() > player.getHandValue()) && (dealer.getHandValue() < 22))
            {
                System.out.println(player.getName() + ", you lost to the dealer you lose all the money you bet");
                player.setMoney(player.getMoney() - player.getBet());
            }
            else if((dealer.getHandValue() < player.getHandValue()) && (player.getHandValue() < 22))
            {
                System.out.println(player.getName() + ", you beat the dealer you win! You get double your bet back!");
                player.setMoney(player.getMoney() + player.getBet()*2);
            }
            else if((dealer.getHandValue() == player.getHandValue()) && (player.getHandValue() < 22))
            {
                System.out.println(player.getName() + ", you tied the dealer. You get your money back");
                player.setMoney(player.getMoney() + player.getBet());
            }
            else
            {
                System.out.println(player.getName() + ", you beat the dealer you win! You get double your bet back!");
                player.setMoney(player.getMoney() + player.getBet()*2);
            }
        }
    }
}
