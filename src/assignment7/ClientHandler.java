package assignment7;

import java.io.*;
import java.net.*;

public class ClientHandler implements Runnable {
	String client;
	Socket socket;
	
	public ClientHandler(Socket sock){
		socket = sock;
	}

	@Override
	public void run() {
		BufferedReader in = null;
		try{
			in = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			client = in.readLine();
			
			while(true){
				String line = in.readLine();
				
				if(line != null) {
					ClientMain.clientUI.get(client).gui.displayMessage(line + "\n");
				}
			}
		} catch (IOException e){
			e.printStackTrace();
		} finally{
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
