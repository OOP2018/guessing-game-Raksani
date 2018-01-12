import java.util.Scanner;

/** 
 *  Play guessing game on the console.
 */
public class GameConsole {

	/** play the game. */
	public int play(NumberGame game) {
		Scanner console = new Scanner(System.in);
		int count=1;
		int guess;
		// describe the game.
		System.out.println( game.toString() );
		/*use a loop to print a message from the game and ask the user to input answer.
		 */
		System.out.println( game.getMessage() );
		while(true){
		System.out.print("Your answer? ");
		guess = console.nextInt();
		boolean correct = game.guess(guess);
		if(correct){
			System.out.println("You got it!!");
			System.out.println("Tried : " +count);
			break;
		}
		System.out.println( game.getMessage() );
		if(!correct) 
			{
			count = count+1;	
			continue;
			}
		}
		return guess;
	}
	
}
