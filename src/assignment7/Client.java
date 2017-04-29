package assignment7;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.*;
import java.net.*;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

public class Client {
	String name;
	Socket socket;
	JFrame frame = new JFrame("422C \"It Exists\" Chatroom");
	private JTextField textField = new JTextField(50);
	private JTextArea textArea = new JTextArea(10,60);
	public Client(String n, Socket sock){
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
		
		textArea.setEditable(false);
		frame.getContentPane().add(textField, BorderLayout.SOUTH);
		frame.getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);
		frame.pack();
		name = n;
		socket = sock;
		
		textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMessage(textField.getText());
                textField.setText("");
            }
        });
	}
	
	public void sendMessage(String m){
		PrintWriter pWriter;
		try {
			pWriter = new PrintWriter(socket.getOutputStream(), true);
			pWriter.println(m);
			textArea.append(m+ "\n");
			textArea.setCaretPosition(textArea.getDocument().getLength());
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

	public void run() {
		int i = 0;
		while(i<1000){
			i++;
			textArea.append(i+"\n");
		}
	}
}
