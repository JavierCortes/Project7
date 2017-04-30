package assignment7;

import java.io.*;
import java.net.*;
import java.util.*;

public class ClientMain{
	static File passFile;
	static HashMap<String, Client> clients;
	static HashMap<String, SelfChatGUI> clientUI;
	static HashMap<String, ClientHandler> clientHandlers;
	static HashMap<String, String> passwords;
	
	public static void main(String[] args){
		clients = new HashMap<String, Client>();
		clientUI = new HashMap<String, SelfChatGUI>();
		clientHandlers = new HashMap<String, ClientHandler>();
		passwords = new HashMap<String, String>();
		
		passFile = new File("passwords.txt");
		
		if(!passFile.isFile()){
			try {
				passFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("passwords.txt"));
			String userPass = br.readLine();
			
			while(userPass != null){
				Scanner parse = new Scanner(userPass);
				
				passwords.put(parse.next(), parse.next());
				parse.close();
				
				userPass = br.readLine();
			}
			
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void connectClient(String client, String password, String ip, int port){
		try {
			Socket sock = new Socket(ip, port);
			Client c = new Client(client, sock);
			clients.put(client, c);
			c.sendMessage(client);
			
			SelfChatGUI s = new SelfChatGUI();
			clientUI.put(client, s);
			passwords.put(client, password);
			s.openChat(client);
			
			Iterator<String> it = clientUI.keySet().iterator();
			while(it.hasNext()){
				String user = it.next();
				
				clientUI.get(user).gui.updateClientList();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void disconnectClient(String client){
		Client c = clients.get(client);
		c.disconnect();
		clients.remove(client);


	}
	
	public static void disconnectAll(){
		Iterator<String> it = clientHandlers.keySet().iterator();
		
		while(it.hasNext()){
			clientHandlers.get(it.next()).stop();
		}
	}
}
