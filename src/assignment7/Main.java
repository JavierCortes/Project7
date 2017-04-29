package assignment7;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

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
		
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>(){

			@Override
			public void handle(WindowEvent event) {
				Platform.exit();
				ServerMain.closeServer();
				ClientMain.disconnectAll();
			}
			
		});
	}
	
	@Override
	public void stop(){
		try {
			FileWriter fw = new FileWriter("passwords.txt");
			Iterator<String> it = ClientMain.passwords.keySet().iterator();
			
			while(it.hasNext()){
				String user = it.next();
				String userPass = user + " " + ClientMain.passwords.get(user) + "\n";
				
				fw.write(userPass);
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
