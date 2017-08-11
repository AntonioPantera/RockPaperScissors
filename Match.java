import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Match
{
	/**
	 * By default 3 playable rounds
	 */
	private static final int DEFAULT_ROUNDS = 3;
	
	private static final Map<Character, Item> ITEMS = new HashMap<>();
	
	static
	{
		ITEMS.put('R', new Rock());
		ITEMS.put('P', new Paper());
		ITEMS.put('S', new Scissors());
	}
	
	/**
	 * 
	 */
	private final int rounds;
	
	private int playerScore;
	private int pcScore;
	
	/**
	 * Current round of this match.
	 */
	private int currentRound;
	
	private final Random random = new Random();
	
	public Match(int rounds)
	{
		this.rounds = rounds;
	}
	
	public Match()
	{
		this(DEFAULT_ROUNDS);
	}
	
	public void start()
	{
		System.out.println("Type R for Rock, P for Paper, S for scissors ");
		try (Scanner scanner = new Scanner(System.in))
		{
			do
			{
				System.out.println("Your turn.");
				char input;
				
				do 
				{
					final String next = scanner.next();
					input = Character.toUpperCase(next.charAt(0));
				} while (!ITEMS.containsKey(input));
				
				final Item playerSelected = ITEMS.get(input);
				if (playerSelected != null)
				{
					System.out.println("You have selected: " + playerSelected);
				}
				
				System.out.println("Computer's turn.");
				final Item pcSelected = selectRandom();
				System.out.println("Computer selected: " + pcSelected);
				
				// Check if there's a winner or the players tied.
				if (playerSelected.beats(pcSelected))
				{
					playerScore++;
					System.out.println("You won the round!");
					currentRound++;
				}
				else if (pcSelected.beats(playerSelected))
				{
					pcScore++;
					System.out.println("Computer won this round.");
					currentRound++;
				}
				else
				{
					// Tie, this round should be replayed.
					System.out.println("It's a tie!");
				}
				
				// Print out the score after each round
				System.out.println("Your score: " + playerScore + 
						", Computer's score: " + pcScore);
				
			} while (currentRound < rounds);
		}
	}
	
	/**
	 * Selects a random item <br>
	 * Not the most efficient solution but it works.
	 * @return a random character out of the key set.
	 */
	private Item selectRandom()
	{
		final List<Character> keys = new ArrayList<>(ITEMS.keySet());
		char rndChar = keys.get(random.nextInt(keys.size()));
		return ITEMS.get(rndChar);
	}
}
