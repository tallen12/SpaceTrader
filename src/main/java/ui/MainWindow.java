/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

/**
 *
 * @author MainWin7
 */
public class MainWindow extends Pane{
    private Pane mm;
    private MainMenuController mmc;
    private Pane cc;
    private CharController ccc;
    public MainWindow() throws IOException{
       FXMLLoader loader=new FXMLLoader((getClass().getResource("Main.fxml"))); 
       mm = loader.load();
       this.getChildren().add(mm);
       mmc = (MainMenuController) loader.getController();
       
       
      FXMLLoader loader2=new FXMLLoader((getClass().getResource("Char.fxml"))); 
      cc = loader2.load();
      ccc = (CharController) loader2.getController();

       mmc.getStart().setOnAction((ActionEvent event) -> {
            this.getChildren().remove(mm);
            this.getChildren().add(cc);
      });
    }
}
