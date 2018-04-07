import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

/**
 * A main class for the GuessingGame. It is responsible for creating objects,
 * connecting objects, and running the game UI.
 **/
public class Main extends Application {
//	public static void main(String[] args) {
//		// upper limit for secret number in guessing game
//		int upperBound = 100;
//		NumberGame game = new BeauGame(upperBound);
//		GameConsole ui = new GameConsole();
//		//GameSolver ui = new GameSolver();
//		int solution = ui.play(game);
//		/*
//		 *  display the answer returned by play
//		 **/
//		System.out.println("play() returned " + solution);
//		/*
//		 *  display how many guesses the user made
//		 **/
//		System.out.println("Tried : " + game.getCount() + " time(s)");
//	}
@Override
public void start(Stage stage) {
	try {
		Parent root = (Parent) FXMLLoader.load(
				getClass().getResource("GuessingGameUI.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();
	} catch (Exception e) {
		System.out.println("Exception creating scene: " + e.getMessage());
	}
}

	/**
	 * start the application.
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		Application.launch(args);
	}
}
