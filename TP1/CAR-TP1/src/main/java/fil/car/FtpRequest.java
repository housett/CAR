package fil.car;

import java.net.*;
import java.io.*;
import java.util.*;

/**
 * Cette classe FtpRequest contient
 * 	- une methode processRequest effectuant des traitements generaux concernant une requete entrante
 * 		et deleguant le traitement des commandes (au méthodes qui suivent);
 * 	- une methode processUSER se chargeant de traiter la commande USER ;
 *  - une methode processPASS se chargeant de traiter la commande PASS ;
 *  - une methode processRETR se chargeant de traiter la commande RETR ;
 *  - une methode processSTOR se chargeant de traiter la commande STOR ;
 *  - une methode processLIST se chargeant de traiter la commande LIST ;
 *  - une methode processQUIT se chargeant de traiter la commande QUIT.
 * 
 * @author Houset Thomas
 *
 */
public class FtpRequest extends Thread{

	// Entrée
	Socket s;
	InputStream is;
	InputStreamReader isr;
	BufferedReader br;
	String line;
	//Sortie
	DataOutputStream dos;
	
	/**
	 * Firstly, this constructor tests whether connection is working!
	 * @param s
	 */
	public FtpRequest(Socket s){
		try {
			System.out.println("FTP Client Connected in Thread...");
			this.s = s;
			// in
			//System.out.println("inside in");
			is = s.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			//System.out.println("reading bufferedReader ...");
			/*line = br.readLine();
			if(line == "") {
				System.out.println("Line empty\n");
			}else {
				System.out.println(line);
			}*/
			/*line = br.readLine();*/
			// out
			//System.out.println("inside out");
			dos = new DataOutputStream(s.getOutputStream());
			dos.writeChars("220 Service Ready.\n");
			//dos.flush();
			start();
			//
			
			// closing
			//System.out.println("Disconnecting socket");
			/*is.close();
			isr.close();
			dos.close();
			s.close();*/
			} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run(){
		System.out.println("Thread running.");
		while(true){
			//System.out.println("Waiting for command...");
			String command = "";
			try {
				//is = s.getInputStream();
				command = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(command == null){
				//System.out.println("Void command");
			}else if(command.startsWith("USER")){
				try {
					System.out.println("USER Command Received : "+ command);
					dos.writeChars("331 User name ok.\n");
					//dos.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				//System.out.println("\t USER is : " + command);
			}else if(command.startsWith("PASS")){
				try {
					System.out.println("PASS Command Received : "+ command);
					dos.writeChars("230 User logged in.\n");
					//dos.flush();
					dos.writeChars("200 waiting for command.\n");
					System.out.println("WriteUTF ok");
					//dos.flush();
					System.out.println("Waiting for next");
					//dos.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			/*} else if(command.startsWith("MKD")){
				System.out.println("MKD Command Received : " + command);
				dos.writeChars("200 User logged in\n");
			}*/}else {
				System.out.println("Command : " + command + "unknown.");
			}
		}
	}
}
