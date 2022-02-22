package view;

import java.io.File;

import controller.CopyAcrofieldController;
import controller.NavigationController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class CopyAcrofieldView {
	
	@FXML AnchorPane copyAcrofieldAnchorPane;
	
	@FXML TextField mappedPath;
	@FXML TextField folderPath;
	@FXML TextField toMapPath;
	@FXML TextField destPath;
	
	public void initialize() {
	}
	
	
	public void chooseFolder() {
		DirectoryChooser directoryChooser = new DirectoryChooser();
		Stage stage = (Stage) copyAcrofieldAnchorPane.getScene().getWindow();
		File selectedDirectory = directoryChooser.showDialog(stage);
		folderPath.setText(selectedDirectory.getAbsolutePath());
	}
	
	public void chooseMapped() {
		FileChooser fileChooser = new FileChooser();
		Stage stage = (Stage) copyAcrofieldAnchorPane.getScene().getWindow();
		File selectedFile = fileChooser.showOpenDialog(stage);
		mappedPath.setText(selectedFile.getAbsolutePath());
	}
	public void chooseToMap() {
		FileChooser fileChooser = new FileChooser();
		Stage stage = (Stage) copyAcrofieldAnchorPane.getScene().getWindow();
		File selectedFile = fileChooser.showOpenDialog(stage);
		toMapPath.setText(selectedFile.getAbsolutePath());
	}
	public void chooseDest() {
		DirectoryChooser directoryChooser = new DirectoryChooser();
		Stage stage = (Stage) copyAcrofieldAnchorPane.getScene().getWindow();
		File selectedDirectory = directoryChooser.showDialog(stage);
		destPath.setText(selectedDirectory.getAbsolutePath());
	}
	
	public void startMultipleCopy() {
		
	}
	
	public void startSingleCopy() {
		CopyAcrofieldController.getInstance().MapSingleDoc(toMapPath.getText(), mappedPath.getText(), destPath.getText());
	}
	
	public void back() {
		NavigationController.getInstance().navigateBack();
	}
}
