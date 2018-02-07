package fil.car;

import java.net.*;
import java.io.*;
import java.util.*;

import javax.sound.sampled.Port;

/**
 * Cette classe "Serveur" contient une methode main 
 * 	- ecoutant les demandes de connexion sur un port TCP > 1023 ;
 * 	- donnant acces aux fichiers presents dans un répertoire du systeme de fichier.
 * 		Cette valeur est precisee et initialisee par une valeur passee en argument eu moment du lancement du serveur FTP ;
 * 	- delegant a l'aide d'un thread le traitement d'une requete entrante a un objet de la classe FtpRequest.
 * 
 * @author Houset Thomas
 */
public class Serveur
{
	static int limit = 1000;
	static int cpt = 0;
	private static int PORT = 1903;
	static FtpRequest ftp;
	static ServerSocket ss;
	
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
        try {
//        	System.out.println("Before ss");
        	ss = new ServerSocket(PORT);
        	//ss.close();
//        	System.out.println("Before while true...");
        	while(true){
        		//System.out.println("Inside while ... waiting for a client");        		
        		ftp = new FtpRequest(ss.accept());
        		//System.out.println("A client asked a FTP connection, thread launched.");
        	}
        	
        } catch (IOException e) {
        	e.printStackTrace();
        }
        
    }
    
    
}
