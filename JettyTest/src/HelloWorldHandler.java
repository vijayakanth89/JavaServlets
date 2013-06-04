import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;


public class HelloWorldHandler extends AbstractHandler
{
    	public void handle(String target,Request baseRequest,HttpServletRequest request,HttpServletResponse response)
    			throws IOException, ServletException
    	{
    		response.setStatus(HttpServletResponse.SC_OK);
    		System.out.println("uri: " + baseRequest.getRequestURI() );
    		if (baseRequest.getRequestURI().compareToIgnoreCase("/getGreeting") == 0){
    			baseRequest.setHandled(true);
        		response.getWriter().println("<h1>You have done an excellent Job</h1>");
    		} else {
    			baseRequest.setHandled(true);
//        		response.getWriter().println("<h1>Server does not allow this service to be exposed</h1>");
    		}
    	}

}
