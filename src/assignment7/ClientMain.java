package assignment7;

import java.io.*;
import java.net.*;
import java.util.*;

public class ClientMain implements Observer{
	HashMap<String, Client> clients = new HashMap<String, Client>();
	
	@Override
	public void update(Observable arg0, Object arg1) {
		
	}
	
	public void connectClient(String client, String ip, int port){
		try {
			Socket sock = new Socket(ip, port);
			Client c = new Client(client, sock);
			clients.put(client, c);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void disconnectClient(String client){
		Client c = clients.get(client);
		c.disconnect();
		clients.remove(client);
	}
}
