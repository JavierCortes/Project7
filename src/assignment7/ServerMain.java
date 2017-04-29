package assignment7;

import java.io.*;
import java.net.*;
import java.util.Observable;

public class ServerMain extends Observable{
	static ServerSocket serverSock;
	static Thread clientAccept;
	static boolean listening = true;
	
	public static void main(String[] args){
		clientAccept = new Thread() {
			@Override
			public void run(){
				try {
					serverSock = new ServerSocket(4422);
					
					while(listening){
						Socket clientSock = serverSock.accept();
						Thread t = new Thread(new ClientHandler(clientSock));
						t.start();
					}
					
				} catch (IOException e) {
					
				}
			}
		};
		
		clientAccept.start();
	}
	
	public static void closeServer(){
		try {
			serverSock.close();
		} catch (IOException e) {
			
		}
	}
	
}
