package assignment7;

import java.io.*;
import java.net.*;
import java.util.Observable;

public class ServerMain extends Observable{
	static ServerSocket serverSock;
	
	public static void main(String[] args){
		(new Thread() {
			@Override
			public void run(){
				try {
					serverSock = new ServerSocket(4422);
					
					while(true){
						Socket clientSock = serverSock.accept();
						Thread t = new Thread(new ClientHandler(clientSock));
						t.start();
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
	
}
