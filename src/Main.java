/**
 * A main class for the GuessingGame.
 * It is responsible for creating objects, 
 * connecting objects, and running the game UI.
 */
public class Main {
	public static void main(String[] args) {
		// upper limit for secret number in guessing game
		int upperBound = 100;
		NumberGame game = new BeauGame(upperBound);
		GameSolver ui = new GameSolver( );
		int solution = ui.play( game );
		//display the answer returned by play
		System.out.println("play() returned "+solution);
		//display how many guesses the user made
		System.out.println("Tried : "+game.getCount()+" time(s)");
	}
}
