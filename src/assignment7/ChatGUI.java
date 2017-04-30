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
	private HashMap<String,CheckBox> cbs = new HashMap<String,CheckBox>();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		btn_send.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent arg0) {
				String message = text_chat.getText();
				if(message!= null && (message.trim().length() > 0) ){
					Iterator<Map.Entry<String, CheckBox>> it = cbs.entrySet().iterator();
					String chat = label_chat.getText();
					chat += "(to:";
					boolean toSomeone = false;
					while (it.hasNext()) {
					    Map.Entry<String, CheckBox> mp = it.next();
					    if(mp.getValue().isSelected()){
					    	if(message.charAt(0) == ':' && message.charAt(5) == ':'){
					    		String sc = message.substring(1, 5);
					    		switch (sc) {
					    		case "2602": 
					    			ClientMain.clients.get(mp.getKey()).sendMessage(user + ": " +"\u2602" + " " + message.substring(6));
					    			break;
					    		case "2603": 
					    			ClientMain.clients.get(mp.getKey()).sendMessage(user + ": " +"\u2603" + " " + message.substring(6));
					    			
					    			break;
					    		case "2604": 
					    			ClientMain.clients.get(mp.getKey()).sendMessage(user + ": " +"\u2604" + " " + message.substring(6));
					    			
					    			break;
					    		case "2605": 
					    			ClientMain.clients.get(mp.getKey()).sendMessage(user + ": " +"\u2605" + " " + message.substring(6));
					    			
					    			break;
					    		case "2606": 
					    			ClientMain.clients.get(mp.getKey()).sendMessage(user + ": " +"\u2606" + " " + message.substring(6));
					    			
					    			break;
					    		case "2607": 
					    			ClientMain.clients.get(mp.getKey()).sendMessage(user + ": " +"\u2607" + " " + message.substring(6));
					    			
					    			break;
					    		case "2608": 
					    			ClientMain.clients.get(mp.getKey()).sendMessage(user + ": " +"\u2608" + " " + message.substring(6));
					    			
					    			break;
					    		case "2609": 
					    			ClientMain.clients.get(mp.getKey()).sendMessage(user + ": " +"\u2609" + " " + message.substring(6));
					    			
					    			break;
					    		case "2610": 
					    			ClientMain.clients.get(mp.getKey()).sendMessage(user + ": " +"\u2610" + " " + message.substring(6));
					    			
					    			break;
					    		case "2611": 
					    			ClientMain.clients.get(mp.getKey()).sendMessage(user + ": " +"\u2611" + " " + message.substring(6));
					    			
					    			break;
					    		case "2612": 
					    			ClientMain.clients.get(mp.getKey()).sendMessage(user + ": " +"\u2612" + " " + message.substring(6));
					    			
					    			break;
					    		case "2613": 
					    			ClientMain.clients.get(mp.getKey()).sendMessage(user + ": " +"\u2613" + " " + message.substring(6));
					    			
					    			break;
					    		case "2614": 
					    			ClientMain.clients.get(mp.getKey()).sendMessage(user + ": " +"\u2614" + " " + message.substring(6));
					    			
					    			break;
					    		case "2615": 
					    			ClientMain.clients.get(mp.getKey()).sendMessage(user + ": " +"\u2615" + " " + message.substring(6));
					    			
					    			break;
					    		case "2616": 
					    			ClientMain.clients.get(mp.getKey()).sendMessage(user + ": " +"\u2616" + " " + message.substring(6));
					    			
					    			break;
					    		case "2617": 
					    			ClientMain.clients.get(mp.getKey()).sendMessage(user + ": " +"\u2617" + " " + message.substring(6));
					    			
					    			break;
					    		case "2618": 
					    			ClientMain.clients.get(mp.getKey()).sendMessage(user + ": " +"\u2618" + " " + message.substring(6));
					    			
					    			break;
					    		case "2619": 
					    			ClientMain.clients.get(mp.getKey()).sendMessage(user + ": " +"\u2619" + " " + message.substring(6));
					    			
					    			break;
					    		case "2620": 
					    			ClientMain.clients.get(mp.getKey()).sendMessage(user + ": " +"\u2620" + " " + message.substring(6));
					    			
					    			break;
					    		case "2621": 
					    			ClientMain.clients.get(mp.getKey()).sendMessage(user + ": " +"\u2621" + " " + message.substring(6));
					    			
					    			break;
					    		case "2622": 
					    			ClientMain.clients.get(mp.getKey()).sendMessage(user + ": " +"\u2622" + " " + message.substring(6));
					    			
					    			break;
					    		case "2623": 
					    			ClientMain.clients.get(mp.getKey()).sendMessage(user + ": " +"\u2623" + " " + message.substring(6));
					    			
					    			break;
					    		case "2624": 
					    			ClientMain.clients.get(mp.getKey()).sendMessage(user + ": " +"\u2624" + " " + message.substring(6));
					    			
					    			break;
					    		case "2625": 
					    			ClientMain.clients.get(mp.getKey()).sendMessage(user + ": " +"\u2625" + " " + message.substring(6));
					    			
					    			break;
					    		case "2626": 
					    			ClientMain.clients.get(mp.getKey()).sendMessage(user + ": " +"\u2626" + " " + message.substring(6));
					    			
					    			break;
					    		case "2627": 
					    			ClientMain.clients.get(mp.getKey()).sendMessage(user + ": " +"\u2627" + " " + message.substring(6));
					    			
					    			break;
					    		case "2628": 
					    			ClientMain.clients.get(mp.getKey()).sendMessage(user + ": " +"\u2628" + " " + message.substring(6));
					    			
					    			break;
					    		case "2629": 
					    			ClientMain.clients.get(mp.getKey()).sendMessage(user + ": " +"\u2629" + " " + message.substring(6));
					    			
					    			break;
					    		case "2630": 
					    			ClientMain.clients.get(mp.getKey()).sendMessage(user + ": " +"\u2630" + " " + message.substring(6));
					    			
					    			break;
					    		case "2631": 
					    			ClientMain.clients.get(mp.getKey()).sendMessage(user + ": " +"\u2631" + " " + message.substring(6));
					    			
					    			break;
					    		case "2632": 
					    			ClientMain.clients.get(mp.getKey()).sendMessage(user + ": " +"\u2632" + " " + message.substring(6));
					    			
					    			break;
					    		case "2633": 
					    			ClientMain.clients.get(mp.getKey()).sendMessage(user + ": " +"\u2633" + " " + message.substring(6));
					    			
					    			break;
					    		case "2634": 
					    			ClientMain.clients.get(mp.getKey()).sendMessage(user + ": " +"\u2634" + " " + message.substring(6));
					    			
					    			break;
					    		case "2635": 
					    			ClientMain.clients.get(mp.getKey()).sendMessage(user + ": " +"\u2635" + " " + message.substring(6));
					    			
					    			break;
					    		case "2636": 
					    			ClientMain.clients.get(mp.getKey()).sendMessage(user + ": " +"\u2636" + " " + message.substring(6));
					    			
					    			break;
					    		case "2637": 
					    			ClientMain.clients.get(mp.getKey()).sendMessage(user + ": " +"\u2637" + " " + message.substring(6));
					    			
					    			break;
					    		case "2638": 
					    			ClientMain.clients.get(mp.getKey()).sendMessage(user + ": " +"\u2638" + " " + message.substring(6));
					    			
					    			break;
					    		case "2639": 
					    			ClientMain.clients.get(mp.getKey()).sendMessage(user + ": " +"\u2639" + " " + message.substring(6));
					    			
					    			break;
					    		case "2640": 
					    			ClientMain.clients.get(mp.getKey()).sendMessage(user + ": " +"\u2640" + " " + message.substring(6));
					    			
					    			break;
					    		}
					    		
					    	}
					    	else{
					    		ClientMain.clients.get(mp.getKey()).sendMessage(user + ": " + message);
					    	}
							text_chat.setText("");
							if(!toSomeone){ //if we haven't found someone checked yet just put a space
								chat+= " " + mp.getKey();
								toSomeone = true;
							}
							else{ //else put a comma before the space
								chat+= ", " + mp.getKey();
							}
					    }
					}
					chat += "): " + message + "\n";
					if(!toSomeone){
						chat = label_chat.getText()+"(System Message) Select someone to send this message to! \n";
					}
					label_chat.setText(chat);
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
				CheckBox cb = new CheckBox(client);
				cbs.put(client, cb);
				vbox.getChildren().add(cb);
			}
		}
	}
}
