package tp.eirb.it310;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Logger;

class ClientManager implements Runnable {

	private static final Logger LOGGER = Logger.getLogger( ClientManager.class.getName() );
	private final Socket clientSocket;
	private int id;
	private Server server;

	public ClientManager(Server serv, Socket s, int c) {
		server = serv;
		clientSocket = s;
		id = c;
	}

	public void run() {
		try {			
			LOGGER.info("Connected with client");			
			ServerWebRequest req = new ServerWebRequest(clientSocket.getInputStream());
			ServerWebResponse resp = new ServerWebResponse(clientSocket.getOutputStream());
			ServerWebDataProvider interpreter;
			LOGGER.info("Sendind response ...");
			switch(req.getPath()) {
			case "/hello_world.html":
				interpreter = new HelloWorldProvider();
				interpreter.doGet(req, resp);
				break;
				
			case "/stop":
				interpreter = new StopProvider();
				interpreter.doGet(req, resp);
				server.stop();
				break;
				
			default :
				interpreter = new PageNotFoundProvider();
				interpreter.doGet(req, resp);
				break;
			}
			
			LOGGER.info("Closing client socket ...");
			clientSocket.close();
			

		} catch (IOException e) {
			LOGGER.severe(e.getMessage());
		}
	}


}