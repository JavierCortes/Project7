package assignment7;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.Stage;

public class SelfChatGUI extends Application{
	private String user;
	ChatGUI gui;
	
	public void openChat(String client){
		user = client;
		try {
			start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void start(Stage primaryStage){
		Parent root;
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(ChatGUI.class.getResource("/ChatWithSelf.fxml"));
			root = loader.load();
			gui = loader.getController();
			gui.user = user;
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
