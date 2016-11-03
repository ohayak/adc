package tp.eirb.it310;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

public class ServerWebDataHello implements ServerWebDataProvider {
	
	@Override
	public void doGet(ServerWebRequest req, ServerWebResponse resp)  {
		
		// On récupère un paramètre depuis la requète
		Map<String, String> params = req.getParameters();
		String name = params.get("name");
		
		// On génère la réponse
		try (Writer out = resp.getOutput()){
			out.write("<h1>" + "Hello " + name + "! Je suis une servlet" + "</h1>");
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
