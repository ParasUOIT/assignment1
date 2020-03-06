package cardapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

// This is used to generate random numbers to select the cards
import java.util.concurrent.ThreadLocalRandom;

public class q1 extends  Application{
    // Constant for number of cards to display
    private final int NUMBER_OF_CARDS = 3;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create an HBox to display the cards in a horizontal line
        HBox pane = new HBox(10);

        // Loop for the amount specified in the constant and add an object each time
        for (int i = 0; i < NUMBER_OF_CARDS; i++) {
            pane.getChildren().add(createCardImage());
        }

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Method to create the cards. Private because only this class needs to use it.
    private ImageView createCardImage() {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 54 + 1);
        ImageView card = new ImageView("/Cards/" + randomNum + ".png");

        return card;
    }

}

