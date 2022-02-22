package controller;

import java.io.IOException;
import java.util.LinkedList;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.Window;

public class NavigationController {
	
	private static NavigationController navigationController;
	private final LinkedList<Scene> previousSceneStack = new LinkedList<>();
	private Stage currentStage;

	public static NavigationController getInstance() {
		if(navigationController==null)
			navigationController= new NavigationController();
		return navigationController;
	}
	
	private NavigationController() {
		
	}

	public void navigateToView(String newViewFxml,Object controller)
    {		
		Scene previousScene=currentStage.getScene();
		previousSceneStack.addLast(previousScene);
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(newViewFxml));
        loader.setController(controller);

		Parent view;
		try {
			view = loader.load();
			Scene viewscene = new Scene(view);
			currentStage.setScene(viewscene);
			currentStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
    }
	
	public void navigateToView(String newViewFxml)
    {		
		Scene previousScene=currentStage.getScene();
		previousSceneStack.addLast(previousScene);
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource(newViewFxml));
		Parent view;
		try {
			view = loader.load();
			Scene viewscene = new Scene(view);
			currentStage.setScene(viewscene);
			currentStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}

    }
	
	public void navigateBack() {
		if(!previousSceneStack.isEmpty()) {
			currentStage.setScene(previousSceneStack.pollLast());
			currentStage.show();
		}
			
		
	}

	public boolean buildAlert(String title,String header){
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle(title);
		alert.setHeaderText(header);
		return alert.showAndWait().filter(ButtonType.OK::equals).isPresent();
	}
	public void buildInfoBox(String title,String header){
		Platform.runLater(() -> {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle(title);
			alert.setHeaderText(header);
			alert.showAndWait();
		});

	}

	public void setCurrentStage(Stage currentStage) {

		this.currentStage = currentStage;
		currentStage.setHeight(720);
        currentStage.setWidth(1280);
	}

	public Stage getCurrentStage() {
		return currentStage;
	}
	
}
