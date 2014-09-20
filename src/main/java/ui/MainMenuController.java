package ui;



import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Tyler Allen
 */
public class MainMenuController implements Initializable{
    @FXML
    Button start;
    @FXML
    Pane background;
    @FXML
    Button exit;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        exit.setOnAction((ActionEvent event)->{
            Platform.exit();
        });
    }
    public Button getStart(){
        return start;
    }
    public Pane getPane(){
        return background;
    }
}
