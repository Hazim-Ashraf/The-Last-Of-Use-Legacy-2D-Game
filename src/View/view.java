package View;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class view extends Application{

	 
		Button Zombie=new Button();
		Button Enlarge=new Button();
		
		int  count=0;
		Pane layout=new Pane();
		
		Stage window;
		int x=100;
		int y=200;
		
		public view()
		{
			window=new Stage();
			
			Zombie.setText("small ZOMBIE");
			Enlarge.setText("enlarge");
			
			Zombie.setPrefSize(100, 200);
			Enlarge.setPrefSize(500, 50);
			
			Enlarge.setLayoutX(0);
			Enlarge.setLayoutY(400);

			
			
			layout.getChildren().addAll(Zombie,Enlarge);
			
			//Enlarge.setAlignment(Pos.BOTTOM_CENTER);
			Scene scene=new Scene(layout,500,500);
			Enlarge.setOnAction(e->
			{
				count++;
				x+=50;
				y+=50;
				if(count==3)
					Zombie.setText("HUGE ZOMBIE");
				if(count<3)
					Zombie.setPrefSize(x, y);
			});
			window.setScene(scene);
			window.show();
		}

		@Override
		public void start(Stage arg0) throws Exception {
			new view();
			
		}
//		public static void main(String []args)
//		{
//			launch(args);
//		}
	}



