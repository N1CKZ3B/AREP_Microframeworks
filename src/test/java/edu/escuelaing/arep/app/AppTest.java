package edu.escuelaing.arep.app;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Map;

public class AppTest {

    @Test
    public void testStaticFilesLocation() {
        App.staticfiles("src/main/resources");
        assertEquals("src/main/resources", App.getStaticFilesLocation());
    }

    @Test
    public void testServiceRegistration() {
        App.get("/test", (req, resp) -> "Test Service");
        Map<String, Service> services = App.getServices();
        assertTrue(services.containsKey("/App/test"));
        assertEquals("Test Service", services.get("/App/test").getValue(new Request(null), new Response()));
    }

    @Test
    public void testHelloService() {
        App.get("/hello", (req, resp) -> {
            String name = req.getValues("name");
            return name != null && !name.isEmpty() ? "Hola " + name : "Hola unknown!";
        });

        Request nameRequest = new Request("name=Nicolas");

        assertEquals("Hola Nicolas", App.getServices().get("/App/hello").getValue(nameRequest, new Response()));
      
    }

    @Test
    public void testHelloServiceEmpty(){
        App.get("/hello", (req, resp) -> {
            String name = req.getValues("name");
            return name != null && !name.isEmpty() ? "Hola " + name : "Hola unknown!";
        });

        Request noNamRequest = new Request(null);
        
        assertEquals("Hola unknown!", App.getServices().get("/App/hello").getValue(noNamRequest, new Response()));
    }
    
    @Test
    public void testPiService() {
        App.get("/pi", (req, resp) -> String.valueOf(Math.PI));
        assertEquals(String.valueOf(Math.PI), App.getServices().get("/App/pi").getValue(new Request(null), new Response()));
    }
}
