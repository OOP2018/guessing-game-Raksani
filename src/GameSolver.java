
/**
 *  for generating random numbers 
 **/
import java.util.Random;

/**
 * Automatically find the secret to any NumberGame.
 * 
 * @author Raksani Khunamas
 **/
public class GameSolver {
	/**
	 * Play a NumberGame and return the solution. The NumberGame object must
	 * provide messages (getMessage) containing the phrase "too small" if a
	 * guess is too small and "too large" if a guess is too large, for efficient
	 * solution.
	 * 
	 * @param game
	 *            is the NumberGame to solve guess is ui's guess.
	 * @return guess(secret number)
	 **/
	public int play(NumberGame game) {
		/*
		 * use a loop to print a message from the game and ask the user to input
		 * an answer.
		 */
		int guess;
		Random rand = new Random();
		int upperLimit = game.getUpperBound();
		int lowerLimit = 0;
		/*
		 * using bisection search. If we set upperBound = 100 ,Then "Tried" is
		 * less or equal 7 because 2^7 = 128 > 100 So, it can guess number
		 * between 0-100 in 7 tries or less.
		 **/
		while (true) {
			guess = (lowerLimit + upperLimit) / 2;
			boolean correct = game.guess(guess);
			if (correct) {
				break;
			}
			else {
				if (game.getMessage().contains("too small")) {
					lowerLimit = guess + 1;
					continue;
				}
				if (game.getMessage().contains("too large")) {
					upperLimit = guess - 1;
					continue;
				}
			}
		}
		return guess;
	}
}
