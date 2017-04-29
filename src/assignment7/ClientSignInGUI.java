package assignment7;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

public class ClientSignInGUI implements Initializable{
	@FXML
	private Button btn_create, btn_login;
	@FXML
	private TextField text_username;
	@FXML
	private PasswordField text_password;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		btn_create.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent e){
				String clientName = text_username.getText();
				String password = text_password.getText();
				if(!clientName.equals("")){
					if(!password.equals("")){
						
						if(ClientMain.passwords.get(clientName) == null){
							ClientMain.connectClient(clientName, password, Main.ip, Main.port);
						}else infoAlert("User already exists, please login", "Incorrect Password");
						
					}else infoAlert("Enter a password", "Invalid Password");
				}else infoAlert("Enter a Username", "Invalid Username");
			}
		});
		
		btn_login.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent e){
				String clientName = text_username.getText();
				String password = text_password.getText();
				if(!clientName.equals("")){
					if(!password.equals("")){
						String correctPassword = ClientMain.passwords.get(clientName);
						
						if(correctPassword != null){
							if(correctPassword.equals(password)){
								ClientMain.connectClient(clientName, password, Main.ip, Main.port);
							}else infoAlert("Please enter the correct password", "Incorrect Password");
						}else infoAlert("Please create a new account", "Invalid account");
						
						
					}else infoAlert("Enter a password", "Invalid Password");
				}else infoAlert("Enter a Username", "Invalid Username");
			}
		});
	}
	
	private void infoAlert(String info, String type){
		Alert alert = new Alert(AlertType.INFORMATION, info);
		alert.setTitle(type);
		alert.setHeaderText(null);
		alert.showAndWait();
	}

}
