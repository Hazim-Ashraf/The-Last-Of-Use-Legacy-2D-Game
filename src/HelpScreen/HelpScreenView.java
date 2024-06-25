package HelpScreen;

import java.awt.Paint;
import java.util.Collections;

import GameStartScreenControl.StartScreenControl;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class HelpScreenView {

	//Stage helpWindow;
	Button back;
	Scene helpScene;
	Label Text1;
	Label Text2;
	Label Text3;
	Label Text4;
	Label labelhelp=new Label("GAME DESCRIPTION!");
public HelpScreenView()
{
	Pane layout=new Pane();
	// Discription box
	
	Text1=new Label();
	Text2=new Label();
	Text3=new Label();
	Text4=new Label();
	Text1.setPrefSize(600, 600);
	Text2.setPrefSize(600, 600);
	Text3.setPrefSize(600, 600);
	Text4.setPrefSize(600, 600);
	Font TextFont=Font.font("Noteworthy", FontWeight.EXTRA_BOLD, 20);;

	Text1.setText("*The Last of Us: Legacy is a single player survival game set in a zombie apocalyptic world. The game is conducted in a turn based manner, in which each player character receives a specific number of action points per turn, which they can use to move, attack or cure zombies, or use special actions.\n"
			+ "The player starts the game controlling only one hero, but can gain additional heroes by curing zombies. The objective of the game for the player is to survive as long as it takes in order to cure a sufficient number of zombies enough to build a community to survive the apocalypse.");
	Text2.setText("*Characters in the game are split into Heroes or Zombies.Heroes are the types of characters that the player can control. There are several types of heroes available in the game, each one provides different assets for the player in order to win the game. Any character; Zombie or Hero, has an initial amount of health that decreases whenever they are attacked. If the character’s health ever reaches 0 they are killed and removed from the game.\n"
			+ "*Considering that the aim of the game is to build a large enough community to survive the apocalypse thus the player must try to maintain and protect their heroes at all costs, as well as try to expand their available pool of heroes.Zombies are the types of characters that threaten the player during the game. Zombies cannot be controlled, however they can be cured or attacked. Each time a zombie is killed another zombie will spawn somewhere on the map. In addition to extra zombies spawning every time the player ends a turn.\n"
			+ "Whenever a zombie is cured an extra hero will take its place and be available for the player to use in future turns.");
	
	
	Text3.setText("*Collectibles are scattered objects across the map that can help the player survive and advance in the game. Each collectible is only usable once, and after that is discarded from the hero’s inventory and cannot be reused.\n"
			+ "* Vaccines: Vaccines are an integral and important part of the game. As the player can only win the game once all vaccines have been collected and used. Vaccines are also the only means through which players can cure zombies and recruit new heroes.\n"
			+ "\n"
			+ "* Supplies: Supplies are the other type of collectible available in the game. Supplies enable the carrying hero to use their special action.\n"
			+ "");
	
	Text4.setText("*Gameplay Flow\n"
			+ "The player starts off in a 15x15 grid map with just one hero and 10 zombies. The player can only see the directly adjacent cells next to their pool of heroes. The player then keeps taking his turn trying to collect vaccines, and cure or kill zombies. The game ends when the player has collected and used all vaccines or when all heroes have been overwhelmed and defeated by the zombies.\n"
			+ "The player only wins if he has successfully collected and used all vaccines and has 5 or more heroes alive.");
	
	Text1.setFont(TextFont);
	Text1.setWrapText(true);
	Text1.setTextFill(Color.WHITE);
	Text2.setFont(TextFont);
	Text2.setWrapText(true);
	Text2.setTextFill(Color.WHITE);
	Text3.setFont(TextFont);
	Text3.setWrapText(true);
	Text3.setTextFill(Color.WHITE);
	Text4.setFont(TextFont);
	Text4.setWrapText(true);
	Text4.setTextFill(Color.WHITE);
	
	Text1.setLayoutX(40);
	Text1.setLayoutY(-100);
	
	Text2.setLayoutX(40);
	Text2.setLayoutY(300);
	
	Text3.setLayoutX(800);
	Text3.setLayoutY(-70);
	
	Text4.setLayoutX(800);
	Text4.setLayoutY(300);
	back=new Button("Back");
	
	back.setLayoutX(10);
	back.setLayoutY(10);
	
	labelhelp.setLayoutX(600);
	labelhelp.setLayoutY(10);
	labelhelp.setTextFill(Color.WHITE);
	
	Font labelFont=Font.font("Copperplate Gothic", FontWeight.EXTRA_BOLD, 34);;
	labelhelp.setFont(labelFont);
	
	back.setStyle("-fx-background-color: #ff0000; ");
	

	layout.getChildren().addAll(back,labelhelp,Text1,Text2,Text3,Text4);
	//layout.setAlignment(labelhelp, Pos.CENTER);
	
	
	
	
	
	/// Background Image
	Image pic= new Image("HelpScreen/helpPage.jpg");
	ImageView img = new ImageView(pic);
	
	BackgroundImage myBI= new BackgroundImage(pic,
	        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
	          BackgroundSize.DEFAULT);
	;
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
	
	
	
	
	//set button back
	back.setOnAction(e->
	{
		StartScreenView.window.setScene(StartScreenView.sceneStart);
		StartScreenView.window.setFullScreen(true);
		StartScreenView.window.show();

	});

	helpScene=new Scene(layout,2880,1800);
			StartScreenView.window.setScene(helpScene);
			StartScreenView.window.show();
	        StartScreenView.window.setFullScreen(true);


}
}
