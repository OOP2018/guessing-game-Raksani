import java.util.Random;// for generating random numbers 

/**
 * Automatically find the secret to any NumberGame.
 */
public class GameSolver {
	/**
	 * Play a NumberGame and return the solution. The NumberGame object must
	 * provide messages (getMessage) containing the phrase "too small" if a
	 * guess is too small and "too large" if a guess is too large, for efficient
	 * solution.
	 * 
	 * @param game
	 *            is the NumberGame to solve guess is ui's guess.
	 * @return //TODO what does it return?
	 */
	public int play(NumberGame game) {
		// describtion of the game.
		System.out.println(game.toString());
		/*
		 * use a loop to print a message from the game and ask the user to input
		 * answer.
		 */
		int guess;
		int round=1;
		System.out.println(game.getMessage());
		Random rand = new Random();
		int UpperLimit = game.getUpperBound();
		int LowerLimit = 1;
		//guess = rand.nextInt(UpperLimit - LowerLimit + 1) + LowerLimit;
		guess=UpperLimit/2;
		while (true) {
			if(round==1){
				guess = UpperLimit/2;
			}
			else if(round>1){
				guess = rand.nextInt(UpperLimit - LowerLimit + 1) + LowerLimit;
			}
			
			System.out.print("Your answer? ");
			System.out.println(guess);
			boolean correct = game.guess(guess);
			if (correct) {
				System.out.println("You got it!!");
				break;
			}
			System.out.println(game.getMessage());
			if (!correct) {
				if (game.getMessage().contains("too small")) {
					LowerLimit = guess + 1;
					round++;
					continue;
				}
				if (game.getMessage().contains("too large")) {
					UpperLimit = guess - 1;
					round++;
					continue;
				}
			}
		}
		return guess;
	}
}