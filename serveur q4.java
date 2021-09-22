import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.PrintWriter;

public class Serveur {
	
	public static void main(String[] zero) {
		
		ServerSocket socketserver  ;
		Socket socketduserveur ;
		BufferedReader in;
		PrintWriter out;
		
		try {
		  //connexion
			socketserver = new ServerSocket(1600);
			socketduserveur = socketserver.accept();
		  //status report
			System.out.println("Le serveur est à l'écoute du port "+socketserver.getLocalPort());
		    System.out.println("Un zéro s'est connecté");
		  //ouverture chat
			out = new PrintWriter(socketduserveur.getOutputStream());
			in = new BufferedReader (new InputStreamReader (socketduserveur.getInputStream()));
			//reception
			String message_distant = in.readLine();
			System.out.println("le serveur à reçu : "+message_distant);
			
			//choix  //DATE? | HOUR?| MOON? 
			String message_reponce = null;
			if(message_distant.equals("DATE?")){
				
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
				LocalDateTime now = LocalDateTime.now();
				
				message_reponce=dtf.format(now);
			}if(message_distant.equals("HOUR?")){
				
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH/mm/ss");  
				LocalDateTime now = LocalDateTime.now(); 
				
				message_reponce=dtf.format(now);
			}if(message_distant.equals("MOON?")){
				
				message_reponce="I DON'T KNOW";
			}
			//envoi(works)
		    out.println(message_reponce);
		    out.flush();
		    System.out.println("le serveur à envoyé : "+message_reponce);
		  
		  //deconnexion 
		    socketduserveur.close();
		    socketserver.close();
		        
		}catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
