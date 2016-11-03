package tp.eirb.it310;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

class Server {
	private static final Logger LOGGER = Logger.getLogger( Server.class.getName() );
	private static long linesCounter = 0;
	private static int idCounter = 0;

	public static void main(String args[]) throws IOException {
		Server server = new Server();
		server.start();
	}

	public void start() throws IOException {
		try (ServerSocket serverSocket = new ServerSocket(2144)) {
			while(true) {
				LOGGER.info("Waiting for client ...");
				Socket socket = serverSocket.accept();
				Thread t = new Thread(new ClientManager(this, socket, idCounter++));
				t.start();
			}
		}

	}
	
	public synchronized void incrementLinesCounter(long c) {
		linesCounter+=c;
	}
	
	public long getLinesCounter() {
		return linesCounter;
	}


}
