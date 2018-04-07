import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Random;

/**
 * UI controller for events and initializing components.
 *
 * @author Raksani Khunamas.
 */
public class GuessController {
    @FXML
    TextField textfield1;
    @FXML
    Label label;
    private String message;

    //make random number.
    private int secret ;
    private Counter count;

    public void setSecret(int upperBound){
        secret = new Random().nextInt(upperBound);
    }


    /**
     * JavaFX calls the initialize() method of your controller when
     * it creates the UI form, after the components have been created
     * and @FXML annotated attributes have been set.
     * <p>
     * This is a hook to initialize anything your controller or UI needs.
     */

    @FXML
    public void guess(ActionEvent actionEvent) {
        String guess = textfield1.getText();
        if(Integer.parseInt(guess) > secret){
            message = guess + " is way too large!";
            label.setText(message);
            count.add(1);

        }
        else if(Integer.parseInt(guess) < secret){
            message = guess + " is too small!";
            label.setText(message);
            count.add(1);
        }
        else{
            message = "Correct!";
            resetSecret();
            label.setText(message);
        }
    }

    @FXML
    public void resetSecret(){
        secret = new Random().nextInt(100);
        label.setText("");
        textfield1.setText("");
        textfield1.setPromptText("Enter secret number");
    }

    @FXML
    public void giveUp(ActionEvent e){
        System.out.println("hi");
        label.setText("The secret number is "+secret);
    }


    public void setCount(Counter count) {
        this.count = count;
    }
}