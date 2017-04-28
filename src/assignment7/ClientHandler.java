package assignment7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class ClientHandler implements Runnable {
	Socket socket;
	
	public ClientHandler(Socket sock){
		socket = sock;
	}

	@Override
	public void run() {
		try{
			
			BufferedReader in = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			String line = in.readLine();
			
			if(line != null) {
				System.out.println(line);
			}
			
		} catch (IOException e){
			e.printStackTrace();
		}
	}

}
