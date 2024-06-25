package ConfirmBox;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {

	public static boolean answer;
	public static boolean display(String title,String message)
	{
		Stage window=new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		
		Label label=new Label(message);
		Button yes =new Button("yes");
		Button No=new Button("No");
		
		VBox layout=new VBox();
		layout.setSpacing(10);
		layout.getChildren().addAll(label,yes,No);
		layout.setAlignment(Pos.CENTER);
		
		yes.setOnAction(e->{ answer=true;window.close();});
		No.setOnAction(e-> {answer=false;window.close();});
		
		
		
		Scene scene=new Scene(layout,250,250);
		window.setScene(scene);
		window.showAndWait();
		
		return answer;
	}
}
