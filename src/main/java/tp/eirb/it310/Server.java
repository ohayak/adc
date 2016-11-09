package tp.eirb.it310;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Logger;

class Server {
	private static final Logger LOGGER = Logger.getLogger( Server.class.getName() );
	private static long linesCounter = 0;
	private static int idCounter = 0;
	private static int PORT = 2134;
	private ServerSocket serverSocket;

	public static void main(String args[]) throws IOException {
		try {
		Server server = new Server();
		server.start();
		} catch (SocketException e) {
			LOGGER.info(e.getMessage());
			return;
		}
	}

	public void start() throws IOException {
		serverSocket = new ServerSocket(PORT);
		LOGGER.info("Server started at port: "+ PORT); 
		while(true) {
			LOGGER.info("Waiting for client ...");
			Socket socket = serverSocket.accept();
			Thread t = new Thread(new ClientManager(this, socket, idCounter++));
			t.start();
		}
	}


	public void stop() throws IOException {
		LOGGER.info("Stoping server ....");
		serverSocket.close();

	}

	public synchronized void incrementLinesCounter(long c) {
		linesCounter+=c;
	}

	public long getLinesCounter() {
		return linesCounter;
	}


}
