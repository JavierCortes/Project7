package assignment7;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;

public class ClientSignInGUI implements Initializable{
	@FXML
	private Button btn_create, btn_login;
	@FXML
	private TextField text_username;
	@FXML
	private PasswordField text_stats;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		btn_create.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent e){
				String clientName = text_username.getText();
				ClientMain.connectClient(clientName, Main.ip, Main.port);
				//SelfChatGUI gui = new SelfChatGUI();
				//gui.openChat(clientName);
			}
		});
	}

}
