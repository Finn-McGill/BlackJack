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
        
        Scanner input = new Scanner(System.in);
        System.out.println("How many players do you want?");
        int numPlayers = input.nextInt();
        input.nextLine();

        for(int i = 0; i <= numPlayers; i++)
        {
            System.out.println("What is player" + (i + 1) + "'s name?");
            String name = input.nextLine();

            Player player = new Player(name);
            totPlayers.add(player);
        }
        
        for(Player p : totPlayers)
        {
            System.out.println("Here are all the players" + p.getName());
        }

        deck.shuffle();
        
    }
}
