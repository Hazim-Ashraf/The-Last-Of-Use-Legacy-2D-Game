package GameStartScreenControl;

import java.io.IOException;

import ConfirmBox.ConfirmBox;
import GameMapView.GameMapView;
import GameStartScreenView.StartScreenView;
import HelpScreen.HelpScreenView;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class StartScreenControl {

	StartScreenView viewStartScreen;
public StartScreenControl()
{
	viewStartScreen=new StartScreenView();
	
	
	//Control x esc
	viewStartScreen.window.setOnCloseRequest(e->
	{
		e.consume();
	 Close();
	 });
	// Control Exit button
	
	viewStartScreen.ExitButton.setOnAction(e -> Close());
	
	//Control Helpbutton
	viewStartScreen.HelpButton.setOnAction(e->
	{
		new HelpScreenView();
	});
	
	//control StartGame button
	
	viewStartScreen.StartButton.setOnAction(e-> 
	{
		try {
			new GameMapView();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	});
		 
	
	
}
public void Close()
{
	boolean answer=ConfirmBox.display("Confirm", "Are you sure?");
	if(answer==true)
viewStartScreen.window.close();
	

}



}
