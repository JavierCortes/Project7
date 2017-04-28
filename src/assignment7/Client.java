package assignment7;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.*;

public class Client {
	String name;
	Socket socket;
	
	public Client(String n, Socket sock){
		name = n;
		socket = sock;
	}
	
	public void sendMessage(String m){
		BufferedWriter bWriter;
		try {
			bWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bWriter.write(m);
			bWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void disconnect(){
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(name + " disconnected");
	}
}
