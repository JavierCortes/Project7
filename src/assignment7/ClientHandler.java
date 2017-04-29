package assignment7;

import java.io.*;
import java.net.*;

public class ClientHandler implements Runnable {
	Socket socket;
	
	public ClientHandler(Socket sock){
		socket = sock;
	}

	@Override
	public void run() {
		BufferedReader in = null;
		try{
			while(true){
				in = new BufferedReader(
						new InputStreamReader(socket.getInputStream()));
				String line = in.readLine();
				
				if(line != null) {
					System.out.println(line);
				}
			}
		} catch (IOException e){
			
		} finally{
			try {
				in.close();
			} catch (IOException e) {
				
			}
		}
	}

}
