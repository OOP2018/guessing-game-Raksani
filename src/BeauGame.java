import java.util.Random;// for generating random numbers 
/**
 *  Game of guessing a secret number.
 *  
 *  @author Raksani Khunamas
**/

public class BeauGame extends NumberGame {
	/**
	 * upperBound is max value for the secret number. secret is secret number
	 * which users guess. getGuess uses for counting tries.
	 **/
	private int upperBound;
	private int secret;
	private int getGuess;

	/**
	 * Constructor for a NumberGame with value of upperBound and random
	 * number(secret number)
	 * @param upperBound (max value of secret number)
	 **/
	public BeauGame(int upperBound) {
		/*
		 * set the upperbound for the secret number.
		 **/
		this.upperBound = upperBound;
		/*
		 * create a secret number
		 **/
		Random rand = new Random();
		this.secret = rand.nextInt(upperBound) + 1;
		//String Upperbound = upperBound + "";
		// super.setMessage("I'm thinking of a number between 1 and
		// "+Upperbound);
	}

	/**
	 * informing user on console and giving hint. and return true in case of it
	 * comform the followings. if inputed number is less than secret number then
	 * show "Your answer is too small." if more, show
	 * "Your answer is too large." if user guess right number, it shows
	 * "Correct! the answer is (secret number)" if it is not as above it will
	 * return false.
	 **/

	@Override
	public boolean guess(int number) {
		/**
		 * Everytime user call guess().getGuess will increase 1 at a time;
		 **/
		getGuess += 1;
		if (number == secret) {
			setMessage("Correct! the answer is" + secret);
			return true;
		}
		if (number < secret) {
			setMessage("Your answer is too small.");
		} else if (number > upperBound) {
			setMessage("Your answer is excessive!!");
		} else {
			setMessage("Your answer is too large.");
		}
		return false;
	}

	/**
	 * @return value of upperBound.
	 **/
	public int getUpperBound() {
		return upperBound;
	}

	/**
	 * @return "Guess a secret number between 0 and value of upperBound."
	 **/

	@Override
	public String toString() {
		return "Guess a secret number between 0 and " + upperBound;
	}

	/**
	 * @return amount of user's try.
	 **/
	@Override
	public int getCount() {
		return getGuess;
	}

}
