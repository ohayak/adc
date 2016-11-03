package tp.eirb.it310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ServerWebRequest {
	private String path;
	private Map<String, String> parameters;

	public ServerWebRequest(InputStream request) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(request));
		String line = null;
		while ((line = br.readLine()) != null) {
			if (line.startsWith("GET")) { 
				path =  line.split(" |?|#")[1];
				parameters = processQuery( line.split("?|#")[1]);
				
			} else if(line.startsWith("POST")) {
				
			} else if (line.startsWith("PUT")) {
			
			} else {
				throw new IOException("Unhandled http request methode");
			}
		}

	}
	public String getPath() {
		return path;
	}

	public Map<String, String> getParameters() {
		return parameters;
	}

	private Map<String, String> processQuery(String query) {
		Map<String, String> result  = new HashMap<String, String>();
		for(String iter : query.split("&")) {
			String[] keyval = iter.split("=");
			result.put(keyval[0], keyval[1]);
		}
		return result;
	}
}
