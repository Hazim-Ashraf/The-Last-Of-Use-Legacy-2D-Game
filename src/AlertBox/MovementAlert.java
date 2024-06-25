package AlertBox;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MovementAlert {

	public MovementAlert()
	{
		Stage window=new Stage();
		window.setTitle("Warning");
		
		Label label=new Label("Unable to move Cant move outside borders or Cell may be ocuupied");
		Button button=new Button("ok");
		
		
		Pane layout=new Pane();
		label.setWrapText(true);
		label.setAlignment(Pos.TOP_CENTER);
		button.setLayoutX(150);
		button.setLayoutY(150);

		
		button.setOnAction(e-> 
		{
			window.close();
		});
		
		layout.getChildren().addAll(label,button);
		Scene scene=new Scene(layout,300,300);
		window.setScene(scene);
		window.show();
	}
}
