package assignment7;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	static String ip = "localhost";
	static int port = 4422;
	
	public static void main(String[] args){
		ServerMain.main(args);
		ClientMain.main(args);
		
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage){
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getResource("/Client Sign-In.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.show();
	}
}
