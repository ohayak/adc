package tp.eirb.it310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class ServerWebRequest {
	private static final Logger LOGGER = Logger.getLogger( ServerWebRequest.class.getName() );
	private String path;
	private Map<String, String> parameters;

	public ServerWebRequest(InputStream request) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(request));
		while (br.ready()) {
			String line = br.readLine();
			if (line.startsWith("GET")) {				
				String[] content = line.split(" ")[1].split("\\?");	
					path = content[0];
					if (content.length > 1)
						parameters = processQuery(content[1]);
					else
						parameters = new HashMap<String, String>();
			}
		}
		LOGGER.info("Done processing request");
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
