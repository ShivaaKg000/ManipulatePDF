package view;


import java.io.File;

import controller.DecryptController;
import controller.NavigationController;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class DecryptView {


	@FXML private AnchorPane decryptAnchorPane;
	
	@FXML private TextField lockedPath;
	@FXML private TextField unLockedPath;
	@FXML private TextArea logArea;
	
	public void initialize() {
		lockedPath.setText("C:\\Users\\Bcsoft\\Desktop\\LOCKED");
		unLockedPath.setText("C:\\Users\\Bcsoft\\Desktop\\UNLOCKED");
	}

	public void chooseSourceFolder() {
		DirectoryChooser directoryChooser = new DirectoryChooser();
		Stage stage = (Stage) decryptAnchorPane.getScene().getWindow();
		File selectedDirectory = directoryChooser.showDialog(stage);
		lockedPath.setText(selectedDirectory.getAbsolutePath());

	}

	public void chooseDestFolder() {
		DirectoryChooser directoryChooser = new DirectoryChooser();
		Stage stage = (Stage) decryptAnchorPane.getScene().getWindow();
		File selectedDirectory = directoryChooser.showDialog(stage);
		unLockedPath.setText(selectedDirectory.getAbsolutePath());
	}
	
	public void startDecrypt() {
		String lockedPathString= lockedPath.getText()+"\\";
		String unLockedPathString = unLockedPath.getText()+"\\";
		logArea.appendText(DecryptController.getInstance().decrypt(lockedPathString, unLockedPathString));
	}
	
	public void back() {
		NavigationController.getInstance().navigateBack();
	}

}
