

import java.io.IOException;

import org.eclipse.jetty.server.*;
import javax.servlet.ServletResponse;

import javax.servlet.ServletRequest;

public class start
{
    public static void main(String[] args)
        throws Exception
    {
        Server server = new Server();
        Connector connector=new SelectChannelConnector();
        connector.setPort(9090);
        server.setConnectors(new Connector[]{connector});
        
        Handler param=new ParamHandler();
        Handler hello=new HelloHandler();
        
        HandlerCollection handlers = new HandlerCollection();
        handlers.setHandlers(new Handler[]{param,hello});
        
        server.setHandler(handlers);

        server.start();
        server.join();
    }
    
    public static class ParamHandler extends AbstractHandler
    {
        public void handle(String target, HttpServletRequest request, HttpServletResponse response, int dispatch)
        		throws IOException, ServletException
        { 
//            System.err.println(request.getParameterMap());
        	System.out.println("Param Hanlder"  ) ;
//        	response.setStatus(0);
        }
    }
    
    public static class HelloHandler extends AbstractHandler
    {
        public void handle(String target, HttpServletRequest request, HttpServletResponse response, int dispatch) throws IOException, ServletException
        {
            Request base_request = (request instanceof Request) ? (Request)request:HttpConnection.getCurrentConnection().getRequest();
            base_request.setHandled(true);

            System.out.println("uri: " + base_request.getRequestURI() ) ;
            if (base_request.getRequestURI() == new String("/watchlist/getwatchlists") ){
            	System.out.println("Hello watchlist/getwactchlist") ; 
            }
 
            response.setContentType("text/");
            response.setStatus(HttpServletResponse.SC_OK);
            JsonMap sampleJson = new JsonMap();
            sampleJson.addNumber("age","24");
            sampleJson.addString("name","vijaykanth");
            
            JsonMap companyDetails = new JsonMap();
            companyDetails.addString("companyName", "MarketSimplified Inc");
            companyDetails.addString("position", "Software Engineer");
            companyDetails.addString("department", "Platform Integration");
            sampleJson.addJsonMap("company", companyDetails);
            
            JsonArray sampleArray = new JsonArray();
            
            sampleArray.addString("C/C++");
            sampleArray.addString("Python");
            sampleArray.addString("Java/Servlet");
            
            sampleJson.addJsonArray("skills" , sampleArray);
            response.getWriter().println(sampleJson.toString());
        }
    }
}
