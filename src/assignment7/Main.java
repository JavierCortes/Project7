package assignment7;

import java.util.*;

import javax.swing.JFrame;

public class Main {
	static String ip = "localhost";
	static int port = 4422;
	
	public static void main(String[] args){
		ServerMain.main(args);
		ClientMain clientMain = new ClientMain();
		boolean done = false;

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter a name: ");
		String name = scanner.nextLine();
		clientMain.connectClient(name, ip, port);
		clientMain.clients.get(name).frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		clientMain.clients.get(name).frame.setVisible(true);
		clientMain.clients.get(name).run();
		
		while(!done){
			String input = scanner.nextLine();
			Scanner parse = new Scanner(input);
			
			String cmd = parse.next();
			
			if(cmd.equals("quit")){
				clientMain.disconnectClient(name);
				ServerMain.closeServer();
				done = true;
			}
			
			else if(cmd.equals("send")){
				String message = parse.nextLine().trim();
				clientMain.clients.get(name).sendMessage(message);
			}
			
			parse.close();
		}
		
		scanner.close();
	}
	
}
