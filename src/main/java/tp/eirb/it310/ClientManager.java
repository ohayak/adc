package tp.eirb.it310;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

class ClientManager implements Runnable {

	private static final Logger LOGGER = Logger.getLogger( ClientManager.class.getName() );
	private String TAG;
	private final Socket clientSocket;
	private int id;

	public ClientManager(Server serv, Socket s, int c) {
		clientSocket = s;
		id = c;
		TAG = "Thread["+Thread.currentThread().getName()+"]:Client["+id+"]:";
	}

	public void run() {
		try {			
			LOGGER.info("New client connected, id="+id);
			LOGGER.info(TAG+"Writing response...");
			ServerWebRequest req = new ServerWebRequest(clientSocket.getInputStream());
			ServerWebResponse resp = new ServerWebResponse(clientSocket.getOutputStream());
			ServerWebDataProvider interpreter;
			switch(req.getPath()) {
			case "/hello_world.html":
				interpreter = new ServerWebDataHello();
				interpreter.doGet(req, resp);
			default :
				break;

			}
			clientSocket.close();
			LOGGER.info(TAG+"Response sent...");
			LOGGER.info(TAG+"Socket closed..");

		} catch (IOException e) {
			LOGGER.severe(e.getMessage());
			return;
		}
	}


}