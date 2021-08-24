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
import javafx.stage.Stage;
import java.util.concurrent.ThreadLocalRandom;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;  
import java.io.FileInputStream; 
import java.io.FileNotFoundException; 

/**
 *
 * @author tweiderman
 */
public class JavaFXApplication1 extends Application {
    
    int givenInt;
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        //Instantiation of all objects in memory
        Button btnGuess = new Button();
        Button btnPlayAgain = new Button();
        Button btnClose = new Button();
        TextField textField = new TextField();
        Image image = new Image(new FileInputStream("images\\41VcjPSfjwL.png"));
        Image imageUp = new Image(new FileInputStream("images\\up-arrow.png"));
        Image imageDown = new Image(new FileInputStream("images\\down-arrow.png"));
        ImageView imageView = new ImageView(image);
        ImageView imageViewUp = new ImageView(imageUp);
        ImageView imageViewDown = new ImageView(imageDown);
        
        //Sets Width, Height, and Location for all images
        imageView.setX(250);
        imageView.setY(5);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        
        imageViewUp.setX(175);
        imageViewUp.setY(50);
        imageViewUp.setFitHeight(50);
        imageViewUp.setFitWidth(50);   
        imageViewUp.setVisible(false);
        
        imageViewDown.setX(175);    
        imageViewDown.setY(50);    
        imageViewDown.setFitHeight(50);    
        imageViewDown.setFitWidth(50);
        imageViewDown.setVisible(false);
        
        imageView.setPreserveRatio(true);
        imageViewUp.setPreserveRatio(true);
        imageViewDown.setPreserveRatio(true);
        
        //Setting all required text and assignments of variables
        btnGuess.setText("Guess");
        btnPlayAgain.setText("Play Again");
        btnClose.setText("Close Application");
        Label label = new Label("");
        givenInt = ThreadLocalRandom.current().nextInt(0, 101);
        
        // Checking for a left-mouse click event on all buttons and handling code accordingly
        btnPlayAgain.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Assigning the number that the player tries to guess again after pressing the "Play Again" button.
                givenInt = ThreadLocalRandom.current().nextInt(0, 101);
                
                //Sets both images to false to prevent an image from being on the window when it shouldn't be.
                imageViewUp.setVisible(false);
                imageViewDown.setVisible(false);
            }
        });
        
        btnClose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Closes the application window.
                System.exit(0);
            }
        });
        
        btnGuess.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                String guess = textField.getText();
        
                //Simple try catch block to prevent the application from crashing
                //when a user enters something that can't be read as an integer by the program
                try {
                    if(Integer.parseInt(guess) == givenInt) {
                        label.setText("CORRECT");
                        imageViewUp.setVisible(false);
                        imageViewDown.setVisible(false);
                    }
                    else if(Integer.parseInt(guess) > 100 || Integer.parseInt(guess) < 0) {
                        label.setText("Please enter a number between 0-100");
                        imageViewUp.setVisible(false);
                        imageViewDown.setVisible(false);
                    }
                    else if(Integer.parseInt(guess) > givenInt) {
                        label.setText("Lower");
                        imageViewUp.setVisible(false);
                        imageViewDown.setVisible(true);
                    }
                    else if(Integer.parseInt(guess) < givenInt) {
                        label.setText("Higher");
                        imageViewUp.setVisible(true);
                        imageViewDown.setVisible(false);
                    }
                    
                }
                catch(Exception e) {
                    // Shows the user that the program will not accept anything other than a valid integer
                    label.setText("Please enter a number between 0-100");
                }
            }
        });
        

        //Creates the group that displays all buttons, labels, and pictures and sets their position on the window.
        Group root = new Group();      
        root.getChildren().addAll (btnGuess, textField, label, btnPlayAgain,
                imageView, imageViewUp, imageViewDown, btnClose);
        
        btnGuess.setLayoutY(45);
        label.setLayoutY(25);
        textField.setLayoutY(0);
        btnPlayAgain.setLayoutY(85);
        btnClose.setLayoutY(125);
        
        //Instantiation
        Scene scene = new Scene(root, 375, 250);
        
        //Setting the title of the window and setting the current scene.
        primaryStage.setTitle("Higher or Lower Game!");
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
