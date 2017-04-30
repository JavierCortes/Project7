package assignment7;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client implements Observer{
	String name;
	Socket socket;
	
	public Client(String n, Socket sock){
		name = n;
		socket = sock;
	}
	
	public void sendMessage(String m){
		PrintWriter pWriter;
		try {
			pWriter = new PrintWriter(socket.getOutputStream(), true);
			pWriter.println(m);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void disconnect(){
		try {
			//ChatGUI.vbox.getChildren().remove(ChatGUI.cbs.get(name));
			//ChatGUI.cbs.remove(name);
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
	}
}
