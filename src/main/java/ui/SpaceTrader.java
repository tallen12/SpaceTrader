package ui;





import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class SpaceTrader extends Application {
    @Override
    public void start(Stage stage) throws Exception {
       MainWindow mw=new MainWindow();
       Scene scene=new Scene(mw);
       stage.setScene(scene);
       stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

}
