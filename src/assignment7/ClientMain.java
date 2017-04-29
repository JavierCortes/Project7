package assignment7;

import java.io.*;
import java.net.*;
import java.util.*;

public class ClientMain{
	static HashMap<String, Client> clients;
	static HashMap<String, SelfChatGUI> clientUI;
	
	public static void main(String[] args){
		clients = new HashMap<String, Client>();
		clientUI = new HashMap<String, SelfChatGUI>();
	}
	
	public static void connectClient(String client, String ip, int port){
		try {
			Socket sock = new Socket(ip, port);
			Client c = new Client(client, sock);
			clients.put(client, c);
			c.sendMessage(client);
			
			SelfChatGUI s = new SelfChatGUI();
			clientUI.put(client, s);
			s.openChat(client);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void disconnectClient(String client){
		Client c = clients.get(client);
		c.disconnect();
		clients.remove(client);
	}
}
