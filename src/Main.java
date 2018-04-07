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

	@Override
	public void start(Stage primaryStage) {
		// Create the Counter object (the "model" part of our app)
		Counter counter = new Counter();
		try {
			URL url = getClass().getResource("src/GuessingGameUI.fxml");
			if (url == null) {
				System.out.println("Couldn't find file: GuessingGameUI.fxml");
				Platform.exit();
			}
			// Load the FXML and get reference to the loader
			FXMLLoader loader = new FXMLLoader(url);
			// Create the UI. This will instantiate the controller object, too.
			Parent root = loader.load();
			// Now we can get the controller object from the FXMLloader.
			// This is interesting -- we don't need to use a cast!
			GuessController controller = loader.getController();

			controller.setSecret(100);
			// Dependency Injection:
			// Set the Counter object we want the view to update.
			controller.setCount(counter);

			// Build and show the scene
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.sizeToScene();
			primaryStage.setTitle("Click Counter");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
			return;
		}

		// Add an observer that displays the Counter value on console.
		// Dependency Injection:
		// We set a reference to the counter using the constructor.
		CounterView view2 = new CounterView(counter);
		counter.addObserver(view2);
		view2.run();
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
