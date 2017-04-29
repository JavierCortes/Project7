package assignment7;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;

public class ChatGUI implements Initializable{
	String user;
	@FXML
	private Button btn_send;
	@FXML
	private TextField text_chat;
	@FXML
	private Label label_chat;
	@FXML
	private ScrollPane scroll;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		btn_send.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				String message = text_chat.getText();
				if(message!= null && (message.trim().length() > 0) ){
					ClientMain.clients.get(user).sendMessage(message);
				}
				else{
					text_chat.setText("");
				}
			}
		});
	}	
	
	public void displayMessage(String line) {
		
		Platform.runLater(new Runnable(){

			@Override
			public void run() {
				String chat = label_chat.getText();
				chat += line;
				label_chat.setText(chat);
				text_chat.setText("");
			}
			
		});
		
		scroll.setVvalue(scroll.getVmax());
		
		DoubleProperty vprop = new SimpleDoubleProperty();
		vprop.bind(label_chat.heightProperty());
		vprop.addListener(new ChangeListener<Object>(){
			@Override
			public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
				scroll.setVvalue(scroll.getVmax());
			}
		});
	}
}