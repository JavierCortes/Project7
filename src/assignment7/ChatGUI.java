package assignment7;

import java.net.URL;
import java.util.*;

import javafx.application.Platform;
import javafx.beans.property.*;
import javafx.beans.value.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class ChatGUI implements Initializable{
	String user;
	private List<String> clientList = new ArrayList<String>();
	@FXML
	private Button btn_send;
	@FXML
	private TextField text_chat;
	@FXML
	private Label label_chat;
	@FXML
	private ScrollPane scroll;
	@FXML
	private VBox vbox;

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
	
	public void updateClientList(){
		Iterator<String> it = ClientMain.clients.keySet().iterator();
		
		while(it.hasNext()){
			String client = it.next();
			if(!client.equals(user) && !clientList.contains(client)){
				clientList.add(client);
				
				RadioButton r = new RadioButton(client);
				vbox.getChildren().add(r);
			}
		}
	}
}
