package GameMapView;

import java.util.Collections;

import GameStartScreenView.StartScreenView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

public class GameOver {
	public GameOver()
	{
	Stage window=new Stage();
	window.setTitle("Game Over");
	
	Button button=new Button("EXIT GAME");
	Label lose=new Label("Try Again next Time");
	
	Font font=Font.font("Copperplate Gothic", FontWeight.EXTRA_BOLD,FontPosture.ITALIC, 25);
	lose.setTextFill(Color.BLACK);
	lose.setFont(font);
	Pane layout=new Pane();
	
	
	
	button.setLayoutX(150);
	button.setLayoutY(150);
lose.setLayoutX(150);
lose.setLayoutY(100);

	layout.getChildren().addAll(lose,button);
	
	Image pic= new Image("GameMapView/Lose.jpg");
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
