package uk.co.o2;

import com.wordnik.swagger.jaxrs.JaxrsApiReader;
import javax.servlet.http.HttpServlet;

public class Bootstrap extends HttpServlet {
  
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1123068161012184154L;

static {
    JaxrsApiReader.setFormatString("");
  }
}