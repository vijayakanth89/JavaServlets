import org.eclipse.jetty.server.Server;


public class SampleServer
{
    public static void main(String[] args) throws Exception
    {
        Server server = new Server(9090);
//        HelloWorldHandler handlerGreeting = new HelloWorldHandler();
//        server.setHandler(handlerGreeting);
        WatchHandler handlerWatch = new WatchHandler();
        server.setHandler(handlerWatch);
        server.start();
        server.join();
    }
    
}
