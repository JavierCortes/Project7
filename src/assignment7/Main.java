package assignment7;

import java.util.*;

public class Main {
	static String ip = "localhost";
	static int port = 4422;
	
	public static void main(String[] args){
		ServerMain.main(args);
		ClientMain clientMain = new ClientMain();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter a name: ");
		String name = scanner.nextLine();
		
		clientMain.connectClient(name, ip, port);
		
		if(scanner.nextLine().equals("quit")){
			clientMain.disconnectClient(name);
		}
		
		scanner.close();
	}
	
}