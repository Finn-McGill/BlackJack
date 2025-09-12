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
        
        Scanner Players = new Scanner(System.in);
        System.out.println("How many players do you want?");
        int numPlayers = Players.nextInt();

        for(int i = 0; i <= numPlayers; i++);
        {
            System.out.println("What is player" + (int)i + "'s name?");
            String name = Players.nextLine();

            Player player = new Player(name);
            totPlayers.add(player);
        }
        
        Scanner myPlayer = new Scanner(System.in);
        System.out.println("Enter player name:");
        String userName = myPlayer.nextLine();
        Player Me = new Player(userName);
        
        System.out.println(totPlayers);

        for(int i = 0; i < numPlayers, i++)
        {

        }

        
    }
}
