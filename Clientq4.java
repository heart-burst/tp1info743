import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {
	
	public static void main(String[] zero) {
		
		
		Socket socket;
		BufferedReader in;
		PrintWriter out;

		try {
		  //connexion
			socket = new Socket(InetAddress.getLocalHost(),1600);
		  //status report
		    System.out.println(InetAddress.getLocalHost());
		  //ouverture chat
		    in = new BufferedReader (new InputStreamReader (socket.getInputStream()));
		    out = new PrintWriter(socket.getOutputStream());
		  //parlé   
		    String message="DATE?";//DATE? | HOUR?| MOON? 
		    out.println(message);
		    out.flush();
		    System.out.println("Le Client a envoyé : "+message);
		    
		  //recevoir et affiché(works)    
		    String message_distant = in.readLine();
		    System.out.println("Le Client à reçu : "+message_distant);
		        
		  //repondre(works)      
		    out.println("Le Client à bien reçu : "+message_distant);
		    out.flush();
		  //deconnexion      
		    socket.close();
		       
		}catch (UnknownHostException e) {
			
			e.printStackTrace();
		}catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
