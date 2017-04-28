package assignment7;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.*;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client {
	String name;
	Socket socket;
	JFrame frame = new JFrame("422C \"It Exists\" Chatroom");
	private JTextField textField = new JTextField(50);
	private JTextArea textArea = new JTextArea(10,60);
	public Client(String n, Socket sock){
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
		BufferedWriter bWriter;
		try {
			bWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bWriter.write(m);
			textArea.append(m+ "\n");
			textArea.setCaretPosition(textArea.getDocument().getLength());
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

	public void run() {
		// TODO Auto-generated method stub
		int i = 0;
		while(i<1000){
			i++;
			textArea.append(i+"\n");
		}
	}
}
