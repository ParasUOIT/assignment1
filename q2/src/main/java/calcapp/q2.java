package calcapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class q2 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create a GridPane and set the spacing
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(15);

        // Create TextFields to get the user input. Add these along with a label to the pane
        TextField investmentField = new TextField();
        TextField yearsField = new TextField();
        TextField interestField = new TextField();
        TextField futureValueField = new TextField();

        // Do not allow user input for the final field
        futureValueField.setDisable(true);

        pane.add(new Label("Investment Amount"), 0, 0);
        pane.add(investmentField, 1, 0);
        pane.add(new Label("Years"), 0, 1);
        pane.add(yearsField, 1, 1);
        pane.add(new Label("Annual Interest Rate"), 0, 2);
        pane.add(interestField, 1, 2);
        pane.add(new Label("Future Value"), 0, 3);
        pane.add(futureValueField, 1, 3);

        HBox hbox = new HBox();
        Button btCalculate = new Button("Calculate");
        hbox.getChildren().add(btCalculate);
        hbox.setAlignment(Pos.BOTTOM_RIGHT);
        pane.add(hbox, 1,4);

        // Lambda function for taking input, applying the formula and outputting the result.
        btCalculate.setOnAction((ActionEvent e) -> {
            double investAmount = Double.parseDouble(investmentField.getText());
            int years = Integer.parseInt(yearsField.getText());
            double interestRate = Double.parseDouble(interestField.getText()) / 100 / 12;
            double value = investAmount * Math.pow((1 + interestRate), years * 12);

            String str = String.format("%.2f", value);

            futureValueField.setText(str);
        });


        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}