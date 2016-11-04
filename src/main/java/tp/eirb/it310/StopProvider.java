package tp.eirb.it310;

import java.io.IOException;
import java.io.Writer;

public class StopProvider implements ServerWebDataProvider {

	@Override
	public void doGet(ServerWebRequest req, ServerWebResponse resp) {
		try (Writer out = resp.getOutput()){
			out.write("HTTP/1.1 200 OK\n\n");
			out.write("<h1>" + "Server Stopped" + "</h1>");
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
