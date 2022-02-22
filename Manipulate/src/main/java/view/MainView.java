package view;

import manipulate.Constants;

import controller.NavigationController;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainView  {

	@FXML private Text welcomeText;
	@FXML private AnchorPane anchorPane;
	
	
	 public void initialize() {
		
	 }
	 
	@FXML 
	private void decrypt() {
	    Stage window = (Stage) anchorPane.getScene().getWindow();
        NavigationController.getInstance().setCurrentStage(window);
        NavigationController.getInstance().navigateToView(Constants.DECRYPT_VIEW);
	}
	
	@FXML 
	private void copyAcrofield() {
	    Stage window = (Stage) anchorPane.getScene().getWindow();
        NavigationController.getInstance().setCurrentStage(window);
        NavigationController.getInstance().navigateToView(Constants.COPY_ACROFIELD_VIEW);
	}
	
	
	
}
