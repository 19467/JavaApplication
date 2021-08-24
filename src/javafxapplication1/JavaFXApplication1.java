/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.concurrent.ThreadLocalRandom;
import javafx.scene.control.Label;

/**
 *
 * @author tweiderman
 */
public class JavaFXApplication1 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        TextField textField = new TextField();
        btn.setText("Guess");
        Label label = new Label("");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                String guess = textField.getText();
        
                int givenInt = ThreadLocalRandom.current().nextInt(0, 101);
                try {
                    if(Integer.parseInt(guess) == givenInt) {
                        label.setText("CORRECT");
                    }
                    else if(Integer.parseInt(guess) > givenInt) {
                        label.setText("Lower");
                    }
                    else if(Integer.parseInt(guess) < givenInt) {
                        label.setText("Higher");
                    }
                }
                catch(Exception e) {
                    label.setText("Please enter a number between 0-100");
                }
            }
        });
        

        
        Group root = new Group();
        root.getChildren().add(btn);
        root.getChildren().add(textField);
        root.getChildren().add(label);
        
        btn.setLayoutY(45);
        label.setLayoutY(25);
        textField.setLayoutY(0);
       
        
        
        
        Scene scene = new Scene(root, 250, 100);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
