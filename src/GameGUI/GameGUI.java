package GameGUI;

import GameStartScreenControl.StartScreenControl;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

public class GameGUI extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(false);
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		new StartScreenControl();
		
	}

}
