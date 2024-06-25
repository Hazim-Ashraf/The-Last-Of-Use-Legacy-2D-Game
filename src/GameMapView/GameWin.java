package GameMapView;

import java.util.Collections;

import GameStartScreenView.StartScreenView;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class GameWin {

	public GameWin()
	{
	Stage window=new Stage();
	window.setTitle("Congratulations");
	
	Button button=new Button("EXIT GAME");
	
	
	Pane layout=new Pane();
	Label Won=new Label("YOU WON");
	
	Font font=Font.font("Copperplate Gothic", FontWeight.EXTRA_BOLD,FontPosture.ITALIC, 25);
	Won.setTextFill(Color.WHITE);
	Won.setFont(font);
	
	
	button.setLayoutX(150);
	button.setLayoutY(150);
	Won.setLayoutX(150);
	Won.setLayoutY(100);
	
	layout.getChildren().addAll(Won,button);
	
	Image pic= new Image("GameMapView/Win.jpg");
	ImageView img = new ImageView(pic);
	
	BackgroundImage myBI= new BackgroundImage(pic,
	        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
	          BackgroundSize.DEFAULT);
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
	
	Scene scene=new Scene(layout,300,300);
	window.setScene(scene);
	window.show();
	

	
	
	button.setOnAction(e-> 
	{
		
		window.close();
		StartScreenView.window.close();
	});
	}
}
