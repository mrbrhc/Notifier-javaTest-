/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mrbrhcnotifier;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Mason
 */
public class MrbrhcNotifier extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        //create textfield
        TextField userText = new TextField();
        //create buttons
        Button btnNotify = new Button();
        btnNotify.setText("Notify");
        btnNotify.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btnNotify.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                userText.setText(invokeMe());
            }
        });
        
        Button btnPrint = new Button();
        btnPrint.setText("Print");
        btnPrint.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btnPrint.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                String btnPrintVar = userText.getText();
                System.out.println(btnPrintVar);
            }
        });
        
        Button btnClear = new Button();
        btnClear.setText("Clear");
        btnClear.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btnClear.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                userText.setText("");
            }
        });
        
        Button btnAlert = new Button();
        btnAlert.setText("Alert");
        btnAlert.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btnAlert.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("ALERT!!");
                alert.setHeaderText("Sent as an 'Alert'");
                alert.setContentText(userText.getText());

                alert.showAndWait();
            }
        });
        //Set Gridpane structure
        GridPane root = new GridPane();
        
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(10,10,10,10));
        
        
        userText.setPrefWidth(350);
        
        //text field
        root.add(userText,0,0);
        //create vbox for buttons
        VBox vbox = new VBox(10); // spacing = 10
        vbox.setPadding(new Insets(0, 0, 10, 0));
        //add buttons to vbox
        vbox.getChildren().addAll(btnNotify, btnClear, btnPrint, btnAlert);
        //add vbox to gridpane
        root.add(vbox, 0, 1);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Notifier");
        primaryStage.setScene(scene);
        primaryStage.setWidth(420);
        primaryStage.setHeight(250);
        primaryStage.show();
    }
    
    public String invokeMe(){
       String pawPrint = "mrbrhc";
      // System.out.println("My pawprint is mrbrhc ");
       return "You have been notified by: " + pawPrint + " on: " +
               new SimpleDateFormat("yyyy/MM/dd HH:mm").
               format(Calendar.getInstance().getTime()) ;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
      
    }
    
}
