package GameMapView;

import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import com.sun.javafx.geom.Shape;

import AlertBox.InvalidTargetExceptionAlert;
import AlertBox.MovementAlert;
import AlertBox.NotEnoughActionAlert;
import AlertBox.NotEnoughResourcesAlert;
import AlertBox.SelectCharacterAlert;
import AlertBox.TrapCellAlert;
import GameStartScreenView.StartScreenView;
import engine.Game;
import exceptions.InvalidTargetException;
import exceptions.MovementException;
import exceptions.NoAvailableResourcesException;
import exceptions.NotEnoughActionsException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Point3D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.scene.transform.Rotate;
import javafx.stage.Popup;
import javafx.stage.Stage;
import model.characters.Direction;
import model.characters.Explorer;
import model.characters.Fighter;
import model.characters.Hero;
import model.characters.Medic;
import model.characters.Zombie;
import model.world.CharacterCell;
import model.world.TrapCell;

public class GameMapView {
	Scene ChooseHero;
	
	Stage HeroDetails;
	
	Label CharacterInfo =new Label();
	Button HeroName=new Button();
	
	VBox CharacterInfoPane=new VBox();
	HBox AvaiableHeroesBox =new HBox();
	
	Button MoveUp=new Button("up");
	Button MoveDown=new Button("down");
	Button MoveLeft=new Button("left");
	Button MoveRight=new Button("right");
	Button Next;
	Button Back;
	Button HeroInfo;
	Button HeroType=new Button();
	Button HeroMaxHp=new Button();
	Button HeroCurrentHp=new Button();
	Button HeroActionPoints=new Button();
	Button HeroMaxActionPoints=new Button();
	Button SupplyCount=new Button();
	Button VaccineCount=new Button();
	Button HeroAttackdmg=new Button();
	Button HeroSpecialActionUsed=new Button();
    
	Label Billimg=new Label();
	Label Davidimg=new Label();
	Label Ellieimg=new Label();
	Label Henryimg=new Label();
	Label Joelimg=new Label();
	Label Rileyimg=new Label();
	Label Tessimg=new Label();
	Label Tommyimg=new Label();

	
	VBox HeroStats=new VBox();
	
	ArrayList<Button> HeroesButtons;
	Button[][] MapButtons= new Button[15][15];
	Label Label1;
	
	ArrayList<String> HerosImgUrl=new ArrayList(8);
	
	Boolean SelectCharacter=false;
	Boolean SelectTarget=true;
	
	static int LocationX=0;
	static int LocationY=0;
	static int HeroIndexSelectedimg;
	static int HereSelect;
	static int TargetX=0;
	static int TargetY=0;
	static int HealX=0;
	static int HealY=0;
	static int indexHeroSelected=0;
	static int Heroimg;

	
	int spacing=0;
	
	
	 
		
	public GameMapView() throws IOException
	{
		HerosImgUrl.add("GameMapView/joel.jpeg");
		HerosImgUrl.add("GameMapView/ellie.jpeg");
		HerosImgUrl.add("GameMapView/tess.jpeg");
		HerosImgUrl.add("GameMapView/riley abel.jpeg");
		HerosImgUrl.add("GameMapView/tommymiller.jpeg");
		HerosImgUrl.add("GameMapView/bill.jpeg");
		HerosImgUrl.add("GameMapView/david.jpeg");
		HerosImgUrl.add("GameMapView/henryburell.jpeg");


		
		Game.loadHeroes("/Users/zuma/eclipse-workspace/Milestone2-Solution/Heroes.csv");
		HeroesButtons=new ArrayList(9);
		
		Label1=new Label("CHOOSE A HERO TO START THE GAME");
		Next=new Button("Next");
		Back=new Button("Back");
		HeroInfo=new Button("Check Hero's `ability");
		Pane layout=new Pane();
		
		Next.setLayoutX(1400);
		Next.setLayoutY(0);
		Back.setLayoutX(0);
		HeroInfo.setLayoutX(500);
		HeroInfo.setLayoutY(800);
		Label1.setLayoutX(400);
		Label1.setLayoutY(200);
		Font fontl=Font.font("NoteWorthy", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 40);
		Font font=Font.font("Noteworthy", FontWeight.EXTRA_BOLD, 40);
		
		Label1.setFont(font);
		Label1.setTextFill(Color.WHITE);
		
		HeroInfo.setFont(font);
		HeroInfo.setBackground(Background.EMPTY);
		HeroInfo.setTextFill(Color.WHITE);
		HeroInfo.setBorder(Border.stroke(Color.AQUAMARINE));
		HeroInfo.setWrapText(true);
		HeroInfo.setShape(new Circle(1));
		HeroInfo.setPadding(new Insets(14));
		
		Next.setStyle("-fx-background-color: #ff0000; ");
		Back.setStyle("-fx-background-color: #ff0000; ");
		
		
        
		
		for(int i=0;i<8;i++)
		{
			Button Hero=new Button();
			
			
			Rectangle rectangle = new Rectangle(100, 100, 120, 80);
			rectangle.setArcHeight(10);
	        rectangle.setArcWidth(10);
	        
			
			Hero.setMaxHeight(300);
			Hero.setMaxWidth(200);
			Hero.setText(""+Game.availableHeroes.get(i).getName());
			Hero.setWrapText(true);
			Hero.setFont(font);
			Hero.setTextFill(Color.WHITE);
			Hero.setBorder(Border.stroke(Color.BLUE));
			Hero.setBackground(Background.EMPTY);
			Hero.setShape(rectangle);
			
			Hero x=Game.availableHeroes.get(i);
			if(i<=3)
			{
				
			Hero.setLayoutX(200+spacing);
			Hero.setLayoutY(300);
			spacing+=300;
			if(i==3)
				spacing=0;
			}
			
			else
			{
				Hero.setLayoutX(100+spacing);
				Hero.setLayoutY(500);
				spacing+=300;
			}
			layout.getChildren().add(Hero);
			HeroesButtons.add(Hero);
			
			Popup popup = new Popup();
            popup.setAutoHide(true);

            Hero.setOnMouseEntered(event -> {
            	String Type=" ";
       		 if(x instanceof Fighter)
       		Type="FIGHTER";
       		 if(x instanceof Medic)
       				Type="MEDIC";
       		 if(x instanceof Explorer)
       				Type="EXPLORER";
       		 
                Label HeroDetails = new Label(
                        "\nMax HP: " + x.getMaxHp() +
                        "\nAttack Dmg: " + x.getAttackDmg()
                        +  "\nMax Actions: " +x.getMaxActions()+  
                        "\nType : " +Type
                        );
                HeroDetails.setTextFill(Color.WHITE);
                StackPane HeroDetailsPane = new StackPane(HeroDetails);
                HeroDetailsPane.setBorder(Border.stroke(Color.AQUAMARINE)) ;
                HeroDetailsPane.setBackground(Background.fill(Color.BLACK));
                HeroDetails.setPadding(new Insets(5)); 
                popup.getContent().add(HeroDetailsPane);
                popup.show(Hero, event.getScreenX(), event.getScreenY());
            });

            Hero.setOnMouseExited(event -> {
                popup.hide();
            });
			
			
			Hero.setOnAction(Handler);
		}
		
		layout.getChildren().addAll(Label1,Next,Back,HeroInfo);
		
		
		//BAckGround
		
		Image pic= new Image("GameMapView/ChooseHero.jpg");
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
		
		// Handling buttons
		
		//Back buttons
		Back.setOnAction(e-> 
		{
			StartScreenView.window.setScene(StartScreenView.sceneStart);
			StartScreenView.window.show();
			StartScreenView.window.setFullScreen(true);
			
		});
		
		//Check Ability button
		
		
		
		// Check selection of heroes
		
		
		
		
		ChooseHero=new Scene(layout,2880,1800);
		StartScreenView.window.setScene(ChooseHero);
		StartScreenView.window.show();
		StartScreenView.window.setFullScreen(true);
		
	}
	final EventHandler<ActionEvent> Handler = new EventHandler<ActionEvent>(){

		 @Override
		public void handle(ActionEvent Event) {
			// TODO Auto-generated method stub
	    	Button x=(Button) Event.getSource();
	    	int index=HeroesButtons.indexOf(x);
	 
	    	
	    Game.startGame(Game.availableHeroes.get(index));
    	System.out.print("hi");
    	HeroIndexSelectedimg=index;
    	
    	GameMap();
        AvaiableHeroesHandleBox(Game.heroes.get(0).getName());
    	// Set label avaable heroes when selected
    			
	    
    	
    	
	    	switch(index)
	    	{
	    	case 0:
	    	{
	    		
	    		UpdateCellBackground("GameMapView/joel.jpeg",new Point(0,0));
	    		Heroimg=0;
	    		break;
	    		
	    	}
	    	case 1:
	    	{
	    		UpdateCellBackground("GameMapView/ellie.jpeg",new Point(0,0));
	    		Heroimg=1;
	    		break;
	    	}
	    	case 2:
	    	{
	    		UpdateCellBackground("GameMapView/tess.jpeg",new Point(0,0));
	    		
	    		Heroimg=2;
	    		System.out.print(Heroimg+"h");
	    		break;
	    	}
	    	case 3:
	    	{
	    		UpdateCellBackground("GameMapView/riley abel.jpeg",new Point(0,0));
	    		Heroimg=3;
	    		break;
	    	}
	    	case 4:
	    	{
	    		UpdateCellBackground("GameMapView/tommymiller.jpeg",new Point(0,0));
	    		Heroimg=4;
	    		break;
	    	}
	    	case 5:
	    	{
	    		UpdateCellBackground("GameMapView/bill.jpeg",new Point(0,0));
	    		Heroimg=5;
	    		break;
	    	}
	    	case 6:
	    	{
	    		UpdateCellBackground("GameMapView/david.jpeg",new Point(0,0));
	    		Heroimg=6;
	    		break;
	    	}
	    	case 7:
	    	{
	    		UpdateCellBackground("GameMapView/henryburell.jpeg",new Point(0,0));
	    		Heroimg=7;
	    		break;
	    	}	
	    	}
	    

	    	
	    	//Adjust adjacent cell visibility
	    	 ShowVisibiltyOnMap();
	    	 
	    	
	    	
	    }
	};
	public void UpdateCellBackground(String Url,Point Location)
	{
		Image pic= new Image(Url);
		ImageView img = new ImageView(pic);
		BackgroundImage myBI= new BackgroundImage(pic,
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		MapButtons[Location.x][Location.y].setBackground(
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
	}
	public void ShowVisibiltyOnMap()
	{
		for(int i=0;i<15;i++)
    	{
    		for(int j=0;j<15;j++)
    		{
    			if(Game.map[i][j].isVisible())
    			{
    				MapButtons[i][j].setStyle("-fx-border-color: Orange; -fx-font-size: 20;");
    				MapButtons[i][j].setBorder(Border.stroke(Color.ORANGE));
    				if(Game.map[i][j] instanceof CharacterCell &&((model.world.CharacterCell)Game.map[i][j]).getCharacter() instanceof model.characters.Zombie)
    					{
    					UpdateCellBackground("GameMapView/zombie.jpg",new Point(i,j));
    					
    					DropShadow borderGlow = new DropShadow();
    					borderGlow.setColor(Color.RED);
    					borderGlow.setOffsetX(0f);
    					borderGlow.setOffsetY(0f);
    					borderGlow.setHeight(70);
    					
    					//MapButtons[i][j].setStyle("-fx-border-color: Red; -fx-font-size: 20;");
        				MapButtons[i][j].setBorder(Border.stroke(Color.RED));
        				MapButtons[i][j].setEffect(borderGlow);
    					}
    				if(Game.map[i][j] instanceof model.world.CollectibleCell &&((model.world.CollectibleCell)Game.map[i][j]).getCollectible() instanceof model.collectibles.Collectible)
					{
    					if(((model.world.CollectibleCell)Game.map[i][j]).getCollectible() instanceof model.collectibles.Vaccine)
    					{
    					UpdateCellBackground("GameMapView/Syringe.jpg",new Point(i,j));
					DropShadow borderGlow = new DropShadow();
					borderGlow.setColor(Color.LIME);
					borderGlow.setOffsetX(0f);
					borderGlow.setOffsetY(0f);
					borderGlow.setHeight(70);
					System.out.println("Vaccine");
    				MapButtons[i][j].setBorder(Border.stroke(Color.LIME));
    				MapButtons[i][j].setEffect(borderGlow);
    					}
    				if(((model.world.CollectibleCell)Game.map[i][j]).getCollectible() instanceof model.collectibles.Supply)

    				{
    					UpdateCellBackground("GameMapView/supply.jpg",new Point(i,j));
    					DropShadow borderGlow = new DropShadow();
    					borderGlow.setColor(Color.LIME);
    					borderGlow.setOffsetX(0f);
    					borderGlow.setOffsetY(0f);
    					borderGlow.setHeight(70);
    					System.out.println("supply");
        				MapButtons[i][j].setBorder(Border.stroke(Color.LIME));
        				MapButtons[i][j].setEffect(borderGlow);
    				}
					}
    			}
    			
    		}
    	}
		
	}
	
	
	public ObservableList <model.characters.Hero> getAvaibleheros()
	{
		ObservableList<model.characters.Hero> temp=FXCollections.observableArrayList();
		for(int i=0;i<8;i++)
		{
			temp.add(Game.availableHeroes.get(i));
		}
		return temp;
	}
	
	public void AbvaiableHeroesLabelbackground(String Url, Label x)
	{
		Image pic= new Image(Url);
		ImageView img = new ImageView(pic);
		
		BackgroundImage myBI= new BackgroundImage(pic,
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		x.setBackground(
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
	}
	
	public void AvaiableHeroesHandleBox(String Name)
	{
		  switch(Name)
		     {
		     case "Bill":
		     {
				 Billimg.setBackground(Background.EMPTY);
				 Billimg.setText(" ALIVE ");
				 Billimg.setTextFill(Color.GREEN);
				 System.out.println("bill");
				 break;
		     }
		     case "David":
		     {
				 Davidimg.setBackground(Background.EMPTY);
				 Davidimg.setText(" ALIVE ");
				 Davidimg.setTextFill(Color.GREEN);
				 System.out.println("david");
				 break;

		     }
		     case "Tess":
		     {
				 Tessimg.setBackground(Background.EMPTY);
				 Tessimg.setText(" ALIVE ");
				 Tessimg.setTextFill(Color.GREEN);
				 System.out.println("tess");
				 break;
		     }
		     case "Tommy Miller":
		     {
				 Tommyimg.setBackground(Background.EMPTY);
				 Tommyimg.setText(" ALIVE ");
				 Tommyimg.setTextFill(Color.GREEN);
				 System.out.println("tommy");
				 break;
		     }
		     case "Riley Abel":
		     {
				 Rileyimg.setBackground(Background.EMPTY);
				 Rileyimg.setText(" ALIVE ");
				 Rileyimg.setTextFill(Color.GREEN);
				 System.out.println("riley");
				 break;
		     }
		     case "Ellie Williams":
		     {
				 Ellieimg.setBackground(Background.EMPTY);
				 Ellieimg.setText(" ALIVE ");
				 Ellieimg.setTextFill(Color.GREEN);
				 System.out.println("ellie");
				 break;
		     }
		     case "Henry Burell":
		     {
				 Henryimg.setBackground(Background.EMPTY);
				 Henryimg.setText(" ALIVE ");
				 Henryimg.setTextFill(Color.GREEN);
				 System.out.println("henry");
				 break;
		     }
		     case "Joel Miller":
		     {
				 Joelimg.setBackground(Background.EMPTY);
				 Joelimg.setText(" ALIVE ");
				 Joelimg.setTextFill(Color.GREEN);
				 System.out.println("joel");
				 break;
		     }
		     }
	}
	public void AvaiableHeroesHandleBoxDead(String Name)
	{
		  switch(Name)
		     {
		     case "Bill":
		     {
				 Billimg.setBackground(Background.EMPTY);
				 Billimg.setText(" DEAD ");
				 Billimg.setTextFill(Color.RED);
				 break;
		     }
		     case "David":
		     {
				 Davidimg.setBackground(Background.EMPTY);
				 Davidimg.setText(" DEAD ");
				 Davidimg.setTextFill(Color.RED);
				 break;

		     }
		     case "Tess":
		     {
				 Tessimg.setBackground(Background.EMPTY);
				 Tessimg.setText(" DEAD ");
				 Tessimg.setTextFill(Color.RED);
				 break;
		     }
		     case "Tommy Miller":
		     {
				 Tommyimg.setBackground(Background.EMPTY);
				 Tommyimg.setText(" DEAD ");
				 Tommyimg.setTextFill(Color.RED);
				 break;
		     }
		     case "Riley Abel":
		     {
				 Rileyimg.setBackground(Background.EMPTY);
				 Rileyimg.setText(" DEAD ");
				 Rileyimg.setTextFill(Color.RED);
				 break;
		     }
		     case "Ellie Williams":
		     {
				 Ellieimg.setBackground(Background.EMPTY);
				 Ellieimg.setText(" DEAD ");
				 Ellieimg.setTextFill(Color.RED);
				 break;
		     }
		     case "Henry Burell":
		     {
				 Henryimg.setBackground(Background.EMPTY);
				 Henryimg.setText(" DEAD ");
				 Henryimg.setTextFill(Color.RED);
				 break;
		     }
		     case "Joel Miller":
		     {
				 Joelimg.setBackground(Background.EMPTY);
				 Joelimg.setText(" DEAD ");
				 Joelimg.setTextFill(Color.RED);
				 break;
		     }
		     }
	}
	public void setMoveButtonimg(String Url,Button x)
	{
		Image pic= new Image(Url);
		ImageView img = new ImageView(pic);
		
		BackgroundImage myBI= new BackgroundImage(pic,
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		x.setBackground(
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
	}
	public void GameMap()
	{
		
		BorderPane layout=new BorderPane();
		GridPane Map=new GridPane();
		Label temp=new Label("HEllo");
		
		temp.setTextFill(Color.BLUE);
		
		
		VBox Actions=new VBox();
		
		Pane TopMenu=new Pane();
		Pane Bottom=new Pane();
		Pane Right=new Pane();
		Pane Left=new Pane();
		
		Button EndTurn=new Button();
		Button Attack=new Button();
		Button UseSpecial=new Button("Use Special");
		Button Cure=new Button();
		
		Label Turn=new Label("");
		Turn.setTextFill(Color.BLUE);
		
		
		DropShadow borderGlow = new DropShadow();
		borderGlow.setColor(Color.ORANGE);
		borderGlow.setOffsetX(0f);
		borderGlow.setOffsetY(0f);
		borderGlow.setHeight(70);
		
		for(int i=0;i<15;i++)
		{
			for(int j=0;j<15;j++)
			{
		Button button1=new Button();
		button1.setStyle("-fx-border-color: Black; -fx-font-size: 20;");
		//button1.setText();
		button1.setMaxSize(20, 10);
		button1.setMaxHeight(10);
		button1.setMinWidth(50);
		button1.setBackground(Background.EMPTY);
		button1.setBorder(Border.stroke(Color.BLACK.brighter().darker()));
		Map.add(button1, i, j);
		
		button1.setEffect(borderGlow);
		MapButtons[i][j]=button1;
		
		button1.setOnAction(AttackHandler);
		button1.setOnAction(SelectHandler);
			}
		}
		
		
		
		//Background
				Image pic= new Image("GameMapView/Map.jpg");
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
				
				Font font=Font.font("Noteworthy", FontWeight.EXTRA_BOLD, 40);
				Turn.setFont(font);
				
				
				
				Label StartGameLabel=new Label();
				
			StartGameLabel.setText("KILL ALL ZOMBIES  OR CURE THEM!!");
			Cure.setText("Cure");
			Attack.setText("Attack");
			EndTurn.setText("EndTurn");

		//MapAdjust.getChildren().add(Map);
			
			CharacterInfo.setPrefSize(400, 500);
			CharacterInfo.setBackground(Background.fill(Color.GRAY));
			
			Rectangle rectangle = new Rectangle(100, 100, 120, 80);
			rectangle.setArcHeight(10);
	        rectangle.setArcWidth(10);
	        
	        CharacterInfo.setShape(rectangle);
	        CharacterInfo.setBorder(Border.stroke(Color.ORANGE));
			
	
		StartGameLabel.setBorder(Border.stroke(Color.ORANGE));
		StartGameLabel.setShape(rectangle);
		StartGameLabel.setBackground(Background.fill(Color.GRAY));	
		
		Turn.setMaxSize(200, 30);	
		StartGameLabel.setPrefSize(300, 200);
		
		
		StartGameLabel.setLayoutX(-20);
		StartGameLabel.setLayoutY(-100);
		Turn.setLayoutX(500);
		Turn.setLayoutY(20);
		
		UseSpecial.setPrefSize(80, 100);
		
		MoveUp.setPrefSize(40, 40);
		MoveUp.setLayoutX(1300);
		MoveUp.setLayoutY(-80);
		//MoveUp.;
		setMoveButtonimg("GameMapView/up.png",MoveUp);
		
		
		MoveDown.setPrefSize(40, 40);
		MoveDown.setLayoutX(1300);
		MoveDown.setLayoutY(-40);
		setMoveButtonimg("GameMapView/down.png",MoveDown);
		
		MoveLeft.setPrefSize(40, 40);
		MoveLeft.setLayoutX(1250);
		MoveLeft.setLayoutY(-40);
		setMoveButtonimg("GameMapView/left.png",MoveLeft);
		
		MoveRight.setPrefSize(40, 40);
		MoveRight.setLayoutX(1350);
		MoveRight.setLayoutY(-40);
		setMoveButtonimg("GameMapView/right.png",MoveRight);
		
		Font Font2=Font.font("Chalkduster", FontWeight.EXTRA_BOLD,FontPosture.ITALIC, 15);
		
		 HeroType.setDisable(true);
		 HeroType.setBackground(Background.EMPTY);
		 HeroType.setTextFill(Color.WHITE);
		 HeroType.setFont(Font2);
		 
		 HeroMaxHp.setDisable(true);
		 HeroMaxHp.setBackground(Background.EMPTY);
		 HeroMaxHp.setTextFill(Color.WHITE);
		 HeroMaxHp.setFont(Font2);

		 
		 HeroCurrentHp.setDisable(true);
		 HeroCurrentHp.setBackground(Background.EMPTY);
		 HeroCurrentHp.setTextFill(Color.WHITE);
		 HeroCurrentHp.setFont(Font2);

		 
		 HeroActionPoints.setDisable(true);
		 HeroActionPoints.setBackground(Background.EMPTY);
		 HeroActionPoints.setTextFill(Color.WHITE);
		 HeroActionPoints.setFont(Font2);

		 
		 HeroMaxActionPoints.setDisable(true);
		 HeroMaxActionPoints.setBackground(Background.EMPTY);
		 HeroMaxActionPoints.setTextFill(Color.WHITE);
		 HeroMaxActionPoints.setFont(Font2);

		 
		 SupplyCount.setDisable(true);
		 SupplyCount.setBackground(Background.EMPTY);
		 SupplyCount.setTextFill(Color.WHITE);
		 SupplyCount.setFont(Font2);

		 
		 VaccineCount.setDisable(true);
		 VaccineCount.setBackground(Background.EMPTY);
		 VaccineCount.setTextFill(Color.WHITE);
		 VaccineCount.setFont(Font2);

		 
		 HeroAttackdmg.setDisable(true);
		 HeroAttackdmg.setBackground(Background.EMPTY);
		 HeroAttackdmg.setTextFill(Color.WHITE);
		 HeroAttackdmg.setFont(Font2);

		 
		 HeroSpecialActionUsed.setDisable(true);
		 HeroSpecialActionUsed.setBackground(Background.EMPTY);
		 HeroSpecialActionUsed.setTextFill(Color.WHITE);
		 HeroSpecialActionUsed.setFont(Font2);

		  Billimg.setPrefSize(50, 50);
		  Davidimg.setPrefSize(50, 50);
		  Henryimg.setPrefSize(50, 50);
		  Ellieimg.setPrefSize(50, 50);
		  Joelimg.setPrefSize(50, 50);
		  Rileyimg.setPrefSize(50, 50);
		  Tessimg.setPrefSize(50, 50);
		  Tommyimg.setPrefSize(50, 50);
		 

		  
		  AbvaiableHeroesLabelbackground("GameMapView/bill.jpeg",Billimg);
		  AbvaiableHeroesLabelbackground("GameMapView/david.jpeg",Davidimg);
		  AbvaiableHeroesLabelbackground("GameMapView/ellie.jpeg",Ellieimg);
		  AbvaiableHeroesLabelbackground("GameMapView/henryburell.jpeg",Henryimg);
		  AbvaiableHeroesLabelbackground("GameMapView/Joel.jpeg",Joelimg);
		  AbvaiableHeroesLabelbackground("GameMapView/riley abel.jpeg",Rileyimg);
		  AbvaiableHeroesLabelbackground("GameMapView/tess.jpeg",Tessimg);
		  AbvaiableHeroesLabelbackground("GameMapView/tommymiller.jpeg",Tommyimg);

		  
	 
		HeroStats.getChildren().addAll(HeroType,HeroMaxHp,HeroCurrentHp,HeroActionPoints,SupplyCount,VaccineCount,HeroAttackdmg,HeroSpecialActionUsed);
		HeroStats.setSpacing(10);
		
		//HeroStats.setAlignment(Pos.TOP_LEFT);
		HeroStats.setLayoutY(100);
		
		AvaiableHeroesBox.setAlignment(Pos.BOTTOM_CENTER);
		AvaiableHeroesBox.setLayoutX(30);
		AvaiableHeroesBox.setLayoutY(600);
		
		
		
		AvaiableHeroesBox.setBorder(Border.stroke(Color.ORANGE));
		
		AvaiableHeroesBox.getChildren().addAll(Tessimg,Billimg,Davidimg,Ellieimg,Henryimg,Joelimg,Rileyimg,Tommyimg);
		TopMenu.getChildren().add(Turn);	
		Actions.getChildren().addAll(Cure,EndTurn,Attack,UseSpecial);
		Actions.setSpacing(20);
		Bottom.getChildren().addAll(MoveUp,MoveDown,MoveLeft,MoveRight);
		Right.getChildren().addAll(StartGameLabel,Actions);
		//CharacterInfoPane.getChildren().addAll(CharacterInfo,HeroName);
		Left.getChildren().addAll(CharacterInfo,HeroStats,AvaiableHeroesBox);
		
		 Map.setTranslateX(40);
		  Map.setTranslateY(-70);
		  Map.setTranslateZ(0);
		Map.setRotate(270);

		Actions.setLayoutX(0);
		Actions.setLayoutY(300);
		
		layout.setTop(TopMenu);
		layout.setCenter(Map);
		layout.setRight(Right);
		layout.setLeft(Left);
		layout.setBottom(Bottom);
		
		MoveUp.setOnKeyPressed(MoveHandler);
		MoveDown.setOnAction(SelectHandler);
		MoveRight.setOnAction(SelectHandler);
		MoveLeft.setOnAction(SelectHandler);
		EndTurn.setOnAction(EndTurnHandler);
		Attack.setOnAction(AttackHandler);
		Cure.setOnAction(CureHandler);
		UseSpecial.setOnAction(UsespecialHandler);
		
		ShowVisibiltyOnMap();
		Scene scene=new Scene(layout,2880,1800);
		StartScreenView.window.setScene(scene);
		StartScreenView.window.show();
		StartScreenView.window.setFullScreen(true);
		
	}
	public void SetHeroimgIndex(String Name)
	{
	     switch(Name)
	     {
	     case "Bill":
	     {
			 Heroimg=5;
			 break;
	     }
	     case "David":
	     {
			 Heroimg=6;
			 break;

	     }
	     case "Tess":
	     {
			 Heroimg=2;
			 System.out.println(Heroimg + "Hyes");
			 break;
	     }
	     case "Tommy Miller":
	     {
			 Heroimg=4;
			 break;
	     }
	     case "Riley Abel":
	     {
			 Heroimg=3;
			 break;
	     }
	     case "Ellie Williams":
	     {
			 Heroimg=1;
			 break;
	     }
	     case "Henry Burell":
	     {
			 Heroimg=7;
			 break;
	     }
	     case "Joel Miller":
	     {
			 Heroimg=0;
			 break;
	     }
	     
	}
	}
	final EventHandler<ActionEvent> UsespecialHandler = new EventHandler<ActionEvent>(){

		 @Override
		public void handle(ActionEvent Event) 
		 {

			 
			 //Selected Character
			 
			 int index= Game.heroes.indexOf(((CharacterCell)Game.map[LocationX][LocationY]).getCharacter());
			
			 
			 if(Game.heroes.get(index) instanceof Medic)
			 {
				
				 Game.heroes.get(index).setTarget(((CharacterCell)Game.map[HealX][HealY]).getCharacter());
				
			 }
			 
			 
			 try {
					Game.heroes.get(index).useSpecial();
				} 
				
				catch (NoAvailableResourcesException e) {
					// TODO Auto-generated catch block
					new NotEnoughResourcesAlert();
				} 
				
				catch (InvalidTargetException e) {
					// TODO Auto-generated catch block
					new InvalidTargetExceptionAlert();
				}
			 if(Game.heroes.get(index) instanceof Explorer)
			 {
				 for(int i=0;i<15;i++)
				 {
					 for(int j=0;j<15;j++)
					 {
						 if(Game.map[i][j].isVisible())
						 {
							 DropShadow borderGlow = new DropShadow();
							borderGlow.setColor(Color.ORANGE);
							borderGlow.setOffsetX(0f);
							borderGlow.setOffsetY(0f);
							borderGlow.setHeight(70);
							
							MapButtons[i][j].setStyle("-fx-border-color: Orange; -fx-font-size: 20;");
				      		MapButtons[i][j].setBorder(Border.stroke(Color.ORANGE));
							MapButtons[i][j].setEffect(borderGlow);
						 }
					 }
				 }
				 
			 }
			 UpdateHeroinfo();

			 
		 }
		 };
	final EventHandler<ActionEvent> CureHandler = new EventHandler<ActionEvent>(){

		 @Override
		public void handle(ActionEvent Event) 
		 {
				//get hero from array
			 if(!(SelectCharacter))
			 {
				 new SelectCharacterAlert();
				 return;
			 }
			 if(SelectTarget)
			 {
			int index= Game.heroes.indexOf(((CharacterCell)Game.map[LocationX][LocationY]).getCharacter());
			
			//set target 
			Game.heroes.get(index).setTarget(((CharacterCell)Game.map[TargetX][TargetY]).getCharacter());
			
			// Remove from list avaiable heroes
			

			 
				
					try {
						Game.heroes.get(index).cure();
					} catch (NoAvailableResourcesException e) {
						// TODO Auto-generated catch block
						new NotEnoughResourcesAlert();
					} catch (InvalidTargetException e) {
						// TODO Auto-generated catch block
						new InvalidTargetExceptionAlert();
					} catch (NotEnoughActionsException e) {
						// TODO Auto-generated catch block
						new NotEnoughActionAlert();
					}
				
			 SelectTarget=false;
			
		     String Name=((CharacterCell)Game.map[TargetX][TargetY]).getCharacter().getName();
			 SetHeroimgIndex(((CharacterCell)Game.map[TargetX][TargetY]).getCharacter().getName());
			 AvaiableHeroesHandleBox(Name);
		     switch(Name)
		     {
		     case "Bill":
		     {
				 UpdateCellBackground("GameMapView/bill.jpeg",new Point(TargetX,TargetY));
				 break;
		     }
		     case "David":
		     {

				 UpdateCellBackground("GameMapView/david.jpeg",new Point(TargetX,TargetY));break;
		     }
		     case "Tess":
		     {
				
				 UpdateCellBackground("GameMapView/tess.jpeg",new Point(TargetX,TargetY));break;
		     }
		     case "Tommy Miller":
		     {
				
				 UpdateCellBackground("GameMapView/tommymiller.jpeg",new Point(TargetX,TargetY));break;
		     }
		     case "Riley Abel":
		     {
				 
				 UpdateCellBackground("GameMapView/riley abel.jpeg",new Point(TargetX,TargetY));break;
		     }
		     case "Ellie Williams":
		     {
				 UpdateCellBackground("GameMapView/ellie.jpeg",new Point(TargetX,TargetY));break;
		     }
		     case "Henry Burell":
		     {
				 UpdateCellBackground("GameMapView/henryburell.jpeg",new Point(TargetX,TargetY));break;
		     }
		     case "Joel Miller":
		     {
				 UpdateCellBackground("GameMapView/joel.jpeg",new Point(TargetX,TargetY));break;
		     }
		     
		     }
				ShowVisibiltyOnMap();

		 }
			 if(Game.checkGameOver())
				 new GameOver();
			 if(Game.checkWin())
				 new GameWin();
			 UpdateHeroinfo();
	}
	};
	final EventHandler<ActionEvent> AttackHandler = new EventHandler<ActionEvent>(){

		 @Override
		public void handle(ActionEvent Event) 
		 {

//		    	//get hero from array
			 if(!(SelectCharacter))
			 {
				 new SelectCharacterAlert();
				 return;
			 }
			 if(SelectTarget)
			 {
			int index= Game.heroes.indexOf(((CharacterCell)Game.map[LocationX][LocationY]).getCharacter());
			
			//set target 
			Game.heroes.get(index).setTarget(((CharacterCell)Game.map[TargetX][TargetY]).getCharacter());
			// Attack 
			Hero x=Game.heroes.get(index);
			 try {
				Game.heroes.get(index).attack();
			} 
			 catch (NotEnoughActionsException e) {
				// TODO Auto-generated catch block
				new NotEnoughActionAlert();
			} 
			 catch (InvalidTargetException e) {   // ADJUSTTTTTT
				// TODO Auto-generated catch block
				new InvalidTargetExceptionAlert();
			}
			 SelectTarget=false;
			
			 //remove dead character from map
			 if(x.getCurrentHp()==0)
			 {
				 AvaiableHeroesHandleBoxDead(x.getName());
				 MapButtons[LocationX][LocationY].setBackground(Background.EMPTY);
			 }
			 if(((model.world.CharacterCell)Game.map[TargetX][TargetY]).getCharacter()==null)
				{
					MapButtons[TargetX][TargetY].setBackground(Background.EMPTY);
					//ShowVisibiltyOnMap();
				}
			 
			
			ShowVisibiltyOnMap();
//			MapButtons[TargetX][TargetY].setStyle("-fx-border-color: Red; -fx-font-size: 20;");
//			MapButtons[LocationX][LocationY].setStyle("-fx-border-color: Green; -fx-font-size: 20;");
			
			 }
			 // Select target to attack

			 if(Game.checkGameOver())
				 new GameOver();
			 if(Game.checkWin())
				 new GameWin();
			 UpdateHeroinfo();
		 }
		 };
	
	final EventHandler<ActionEvent> EndTurnHandler = new EventHandler<ActionEvent>(){

		 @Override
		public void handle(ActionEvent Event) {
			 if(!(SelectCharacter))
			 {
				 new SelectCharacterAlert();
				 return;
			 }
			 int index= Game.heroes.indexOf(((CharacterCell)Game.map[LocationX][LocationY]).getCharacter());
			 Hero x=Game.heroes.get(index);
			 try {
				Game.endTurn();
			} catch (NotEnoughActionsException e) {
				// TODO Auto-generated c9atch block
				new NotEnoughActionAlert();
			} catch (InvalidTargetException e) {
				// TODO Auto-generated catch block
				new InvalidTargetExceptionAlert();
			}
			 DropShadow borderGlow = new DropShadow();
				borderGlow.setColor(Color.ORANGE);
				borderGlow.setOffsetX(0f);
				borderGlow.setOffsetY(0f);
				borderGlow.setHeight(70);
			 for(int i=0;i<15;i++)
		    	{
		    		for(int j=0;j<15;j++)
		    		{
		    			if(!(Game.map[i][j].isVisible()) )
		    			{
		    				MapButtons[i][j].setStyle("-fx-border-color: Black; -fx-font-size: 20;");
		    				MapButtons[i][j].setBackground(Background.EMPTY);
		    				MapButtons[i][j].setBorder(Border.stroke(Color.BLACK));
		    				 MapButtons[i][j].setEffect(borderGlow);
		    			}
		    			if((Game.map[i][j]) instanceof CharacterCell && Game.map[i][j].isVisible())
		    			{
		    				if(((CharacterCell)Game.map[i][j]).getCharacter()==null)
{
		    				MapButtons[i][j].setBackground(Background.EMPTY);
		    				 MapButtons[i][j].setEffect(borderGlow);
}
		    			}
		    			
		    		}
		    	}
				
				//set target 
			 if(x.getCurrentHp()==0)			
					 AvaiableHeroesHandleBoxDead(x.getName());

			 
			 ShowVisibiltyOnMap(); 
			 if(Game.checkGameOver())
				 new GameOver();
			 if(Game.checkWin())
				 new GameWin();
			 UpdateHeroinfo();
		 }
		 };
	
	final EventHandler<ActionEvent> SelectHandler = new EventHandler<ActionEvent>(){

		 @Override
		public void handle(ActionEvent Event) {
			// TODO Auto-generated method stub
	    	Button button=(Button) Event.getSource();
	    	
	    	int x=0;
	    	int y=0;
	    	for(int i=0;i<15;i++)
	    	{
	    		for(int j=0;j<15;j++)
	    		{
	    			if(button.equals(MapButtons[i][j]) )
	    			{
	    				x=i;
	    				y=j;
//	    				LocationX=x;
//	    				LocationY=y;
	    				
	    			}
	    		}
	    	}

	    	
	    	if( button.equals(MoveUp)|| button.equals(MoveRight)||button.equals(MoveLeft)||button.equals(MoveDown) )
	    	{
	    		if(!(SelectCharacter))
	    		{
	    		new SelectCharacterAlert();
	    		return;
	    		}
	    	}
	    	
	    	
	    	 button=(Button) Event.getSource();
			 
			 if(((model.world.CharacterCell)Game.map[x][y]).getCharacter() instanceof Hero)
		    	{
		    	SelectCharacter=true;
		    	
		    	DropShadow borderGlow = new DropShadow();
				borderGlow.setColor(Color.GREEN);
				borderGlow.setOffsetX(0f);
				borderGlow.setOffsetY(0f);
				borderGlow.setHeight(70);
		    	
				MapButtons[x][y].setStyle("-fx-border-color: Green; -fx-font-size: 20;");
				MapButtons[x][y].setBorder(Border.stroke(Color.GREEN));
		    	MapButtons[x][y].setEffect(borderGlow);
		    
			HealX=LocationX;
			HealY=LocationY;
				LocationX=x;
				LocationY=y;
				
		    	}

	    	
   	if(((model.world.CharacterCell)Game.map[x][y]).getCharacter() instanceof Zombie)
	{
	SelectTarget=true;
	
	DropShadow borderGlow = new DropShadow();
	borderGlow.setColor(Color.RED);
	borderGlow.setOffsetX(0f);
	borderGlow.setOffsetY(0f);
	borderGlow.setHeight(70);
	
	
	MapButtons[x][y].setStyle("-fx-border-color: Red; -fx-font-size: 20;");
	MapButtons[x][y].setBorder(Border.stroke(Color.RED));
	MapButtons[x][y].setEffect(borderGlow);
	TargetX=x;
	TargetY=y;
	}
			 
   	UpdateHeroinfo();


	    	
	    }
	};
	final EventHandler<KeyEvent> MoveHandler = new EventHandler<KeyEvent>(){

		 @Override
		public void handle(KeyEvent Event) {
	 indexHeroSelected=0;
	 Hero temp = null;
	 String MoveDirection=Event.getCode().getChar();

	 
	if(SelectCharacter)
	 {
		
		// get index of selected hero
		if(Game.map[LocationX][LocationY] instanceof CharacterCell)
		 indexHeroSelected=Game.heroes.indexOf(((model.world.CharacterCell)Game.map[LocationX][LocationY]).getCharacter());
	
		if(Game.heroes.get(indexHeroSelected).getCurrentHp()!=0)
		 SetHeroimgIndex(Game.heroes.get(indexHeroSelected).getName());
		
		 temp=Game.heroes.get(indexHeroSelected);
		 System.out.print(MoveDirection);
		  
		switch(MoveDirection)
	 {
	 case "W":
	 {
	  try
	  {
		  MapButtons[LocationX][LocationY].setBackground(Background.EMPTY);
		  Game.heroes.get(indexHeroSelected).move(Direction.UP);
		  LocationX=Game.heroes.get(indexHeroSelected).getLocation().x;
		  LocationY=Game.heroes.get(indexHeroSelected).getLocation().y;
	} 
	  catch (MovementException e) {
		new MovementAlert();
		
	} 
	  catch (NotEnoughActionsException e) {
		  SelectCharacter=false;
		new NotEnoughActionAlert();
	}
	  UpdateCellBackground(HerosImgUrl.get(Heroimg),Game.heroes.get(indexHeroSelected).getLocation());
	  ShowVisibiltyOnMap();
	  break;
	 }
	 case "S":
	 {
	  try 
	  {
		  MapButtons[LocationX][LocationY].setBackground(Background.EMPTY);
		  Game.heroes.get(indexHeroSelected).move(Direction.DOWN);
		  LocationX=Game.heroes.get(indexHeroSelected).getLocation().x;
		  LocationY=Game.heroes.get(indexHeroSelected).getLocation().y;

	} 
	  catch (MovementException e) {
		new MovementAlert();
	} 
	  catch (NotEnoughActionsException e) {
		  SelectCharacter=false;

		new NotEnoughActionAlert();
		
	}
	  UpdateCellBackground(HerosImgUrl.get(Heroimg),Game.heroes.get(indexHeroSelected).getLocation());
	  ShowVisibiltyOnMap();
	  break;
	 }
	 case "A":
	 {
	  try 
	  {
		  MapButtons[LocationX][LocationY].setBackground(Background.EMPTY);
		  Game.heroes.get(indexHeroSelected).move(Direction.LEFT);
		  LocationX=Game.heroes.get(indexHeroSelected).getLocation().x;
		  LocationY=Game.heroes.get(indexHeroSelected).getLocation().y;
		 

	} 
	  catch (MovementException e)
	  {
		new MovementAlert();
	}
	  catch (NotEnoughActionsException e)
	  {
		  SelectCharacter=false;

		new NotEnoughActionAlert();
	}
	  UpdateCellBackground(HerosImgUrl.get(Heroimg),Game.heroes.get(indexHeroSelected).getLocation());
	  ShowVisibiltyOnMap();
	  break;
	 }
	 case "D":
	 {
	  try 
	  {
		  MapButtons[LocationX][LocationY].setBackground(Background.EMPTY);
		  Game.heroes.get(indexHeroSelected).move(Direction.RIGHT);
		  LocationX=Game.heroes.get(indexHeroSelected).getLocation().x;
		  LocationY=Game.heroes.get(indexHeroSelected).getLocation().y;
		 

	} 
	  catch (MovementException e)
	  {
		new MovementAlert();
	} 
	  catch (NotEnoughActionsException e)
	  {
		  SelectCharacter=false;

		new NotEnoughActionAlert();
	}
	 
	  UpdateCellBackground(HerosImgUrl.get(Heroimg),Game.heroes.get(indexHeroSelected).getLocation());
	  ShowVisibiltyOnMap();
	  break;
	 }
	 
	 }
		
		
		System.out.println(LocationX+" Mox");
		System.out.println(LocationY+"Moy");

	 
	 }
		 }

		
	};


	public void UpdateHeroinfo()
	{
		String Name=Game.heroes.get(indexHeroSelected).getName();
		 String MaxHP=Game.heroes.get(indexHeroSelected).getMaxHp() +"";
		 String CurrentHP=Game.heroes.get(indexHeroSelected).getCurrentHp() +"";
		 String Actionpoints=Game.heroes.get(indexHeroSelected).getActionsAvailable() +"";
		 String MaxAction=Game.heroes.get(indexHeroSelected).getMaxActions() +"";
		 String Supply=Game.heroes.get(indexHeroSelected).getSupplyInventory().size() +"";
		 String Vaccine=Game.heroes.get(indexHeroSelected).getVaccineInventory().size() +"";
		 String Attackdmg=Game.heroes.get(indexHeroSelected).getAttackDmg() +"";
		 String Special=Game.heroes.get(indexHeroSelected).isSpecialAction() +"";
		 String Type=" ";
		 if(Game.heroes.get(indexHeroSelected) instanceof Fighter)
		Type="FIGHTER";
		 if(Game.heroes.get(indexHeroSelected) instanceof Medic)
				Type="MEDIC";
		 if(Game.heroes.get(indexHeroSelected) instanceof Explorer)
				Type="EXPLORER";
		 
		 
   	CharacterInfo.setText(Name+"");
   	CharacterInfo.setWrapText(true);
   	CharacterInfo.setAlignment(Pos.TOP_CENTER);
   	CharacterInfo.setTextFill(Color.WHITE);
		Font font=Font.font("Chalkduster", FontWeight.EXTRA_BOLD,FontPosture.ITALIC, 25);
   	CharacterInfo.setFont(font);
   	
		
		HeroType.setText("Hero Tpe:- "+Type);
		HeroType.setWrapText(true);
		HeroType.setTextFill(Color.WHITE);
		 
		 HeroMaxHp.setText("Hero maxHp:- "+ MaxHP+" HP");
		 HeroMaxHp.setWrapText(true);
		 

		 HeroCurrentHp.setText("CurrentHP:- "+CurrentHP+" HP");
		 HeroCurrentHp.setWrapText(true);
		 
		 HeroActionPoints.setText("Action Points Avaiable"+Actionpoints);
		 HeroActionPoints.setWrapText(true);
		 

		 HeroMaxActionPoints.setText("Max Action Points:- "+MaxAction);
		 HeroMaxActionPoints.setWrapText(true);
		 
		 
		 SupplyCount.setText("Total Amount of Supply:- "+Supply );
		 SupplyCount.setWrapText(true);

		 VaccineCount.setText("Total Amount of vaccine:- "+Vaccine);
		 VaccineCount.setDisable(true);
		 
		 HeroAttackdmg.setText("Attach Damage "+Attackdmg);
		 HeroAttackdmg.setWrapText(true);
		 
		  HeroSpecialActionUsed.setText("Special used:- "+Special);
		 HeroSpecialActionUsed.setWrapText(true);
		
	}
	
}
	
	
	


