package tp.eirb.it310;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class ServerWebResponse {
	private Writer output;
	public ServerWebResponse(OutputStream os) {
		output = new OutputStreamWriter(os);
	}
	public Writer getOutput() {
		return output;
	}
}
