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
	private final Socket clientSocket;
	private int id;
	private String TAG;
	private OutputStream os;
	private InputStream is;

	public ClientManager(Server serv, Socket s, int c) {
		clientSocket = s;
		try {
			os = clientSocket.getOutputStream();
			is = clientSocket.getInputStream();
		} catch (IOException e) {
			LOGGER.severe(e.getMessage());
		}

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
		}
	}

	private byte[] getContentVoid(String bytes) {
		String response = "HTTP/1.1 200 OK\n\n<h1>Mon Titre</h1>\n Taking a nap";
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			LOGGER.severe(e.getMessage());
		}
		return response.getBytes();
	}

	private void writeResponse(String requestParam[]) throws IOException {
		LOGGER.info(TAG+"opening "+requestParam[1].substring(1) );
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		File file = new File(classloader.getResource(requestParam[1].substring(1)).getFile());
		if( !file.exists()){
			os.write("HTTP 404".getBytes());
			os.flush();
		}
		LOGGER.info(TAG+"file="+file.getName()+" found");
		String name = "";
		if(requestParam[2].startsWith("name")) {
			name = requestParam[2].substring(5);
		}
		String header = "HTTP/1.1 200 OK\n\n";
		String content = "<input type='text' name='name' value='"+ name +"' />";
		BufferedReader br = new BufferedReader(new FileReader(file));
		os.write(header.getBytes());
		os.write(content.getBytes());
		String line;
		while((line = br.readLine())!=null) {
			os.write(line.getBytes());
		}
		os.flush();
		br.close();
	}

}