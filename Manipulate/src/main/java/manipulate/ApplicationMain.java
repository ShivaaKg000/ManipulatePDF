package manipulate;

import controller.NavigationController;
import javafx.application.Application;
import javafx.stage.Stage;

public class ApplicationMain extends Application{

	@Override
	public void start(Stage stage) {
		try {
			
			NavigationController.getInstance().setCurrentStage(stage);	
			NavigationController.getInstance().navigateToView(Constants.MAIN_VIEW);
		    stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void stop() {
		System.exit(0);
	}

	public static void main(String[] args) {
		launch(args);
	}
}