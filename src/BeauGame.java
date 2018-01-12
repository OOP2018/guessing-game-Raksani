import java.util.Random;// for generating random numbers 
/*
 *  Game of guessing a secret number.
 *  @Beau
*/

public class BeauGame extends NumberGame{
	//max value for the secret number.
	private int upperBound;
	//solution.
    private int secret;

	public BeauGame(int upperBound){
		// set the upperbound for the secret number.
		this.upperBound = upperBound;
		//create a secret number
		Random rand = new Random();
		this.secret = rand.nextInt(upperBound) + 1;
		String Upperbound = upperBound+"";
		//super.setMessage("I'm thinking of a number between 1 and "+Upperbound);
	}
	
	@Override
	public boolean guess(int number){
		if (number == secret) {
    		setMessage("Correct! the answer is"+secret);
    		return true;
    	}
    	if (number < secret) {
    		setMessage("Your answer is too small.");
    	}
    	else if(number > upperBound){
    		setMessage("Your answer is excessive!!");
    	}
    	else {
    		setMessage("Your answer is too large.");
    	}
    	return false;
	}
	
	public int getUpperBound(){
		return upperBound;
	}
	
	@Override
    public String toString() {
    	return "Guess a secret number between 1 and "+upperBound;
    }
	
}
