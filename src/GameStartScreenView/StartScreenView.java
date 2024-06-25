package GameStartScreenView;

import java.util.Collections;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class StartScreenView {

	public static Stage window;
	public Button StartButton;
	public Button HelpButton;
	public Button ExitButton;
	public static Scene sceneStart ;
	
	public StartScreenView()
	{
		 window=new Stage();
		Image pic= new Image("GameStartScreenView/Startscreen.jpg");
		ImageView img = new ImageView(pic);
		
		BackgroundImage myBI= new BackgroundImage(pic,
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		Pane layout=new Pane();
		///layout.getChildren().add(img);
		layout.setBackground(
                new Background(
                        Collections.singletonList(new BackgroundFill(
                                Color.WHITE,
                                new CornerRadii(0),
                                new Insets(0))),
                        Collections.singletonList(new BackgroundImage(
                                pic,
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundPosition.DEFAULT,
                                new BackgroundSize(1.0, 1.0, true, true, false, false)
                        ))));
		
		 StartButton=new Button("Start Game");
		 HelpButton=new Button("Help");
		 ExitButton=new Button("Exit Game");

		
		
		Font font1 = Font.font("Noteworthy", FontWeight.EXTRA_BOLD, 36);
		Font font2 = Font.font("Noteworthy", FontWeight.EXTRA_BOLD, 30);
		Font font3 = Font.font("Noteworthy", FontWeight.EXTRA_BOLD, 26);

		StartButton.setFont(font1);
		HelpButton.setFont(font2);
		ExitButton.setFont(font3);
//		GridPane StartScreenGrid=new GridPane();
//		StartScreenGrid.setPadding(new Insets(1000,1000,1000,1000));
//		StartScreenGrid.add(StartButton,1000,1000);
//		StartScreenGrid.add(OptionButton,5,5);
//		StartScreenGrid.add(ExitButton,3,10);
		
	//VBox StartLayout=new VBox();
		//layout.setSpacing(30);
		layout.getChildren().addAll(StartButton,HelpButton,ExitButton);
		//layout.setAlignment(Pos.CENTER);
		StartButton.setLayoutX(590);
		StartButton.setLayoutY(400);
		HelpButton.setLayoutY(500);
		HelpButton.setLayoutX(620);
		ExitButton.setLayoutX(620);
		ExitButton.setLayoutY(600);
		ExitButton.setTextFill(Color.WHITE);
		ExitButton.setBackground(Background.EMPTY);
		HelpButton.setTextFill(Color.WHITE);
		HelpButton.setBackground(Background.EMPTY);
		StartButton.setTextFill(Color.WHITE);
		StartButton.setBackground(Background.EMPTY);
	 //layout.setBottom(StartLayout);
		
	         sceneStart = new Scene(layout,2880,1800);
	        window.setTitle("Last of Us - Legacy");
	        window.setScene(sceneStart);
	       //primaryStage.sizeToScene();
	        window.show();
	        window.setFullScreen(true);
	}
}
