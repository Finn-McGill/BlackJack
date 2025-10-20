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

        dealer.action();

        player.win();
        
    }
}
