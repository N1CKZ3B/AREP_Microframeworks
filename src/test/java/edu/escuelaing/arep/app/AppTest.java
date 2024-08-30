package edu.escuelaing.arep.app;

import static org.junit.Assert.*;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    

    @Test
    public void testDateTimeService() {
        // Configurar el servicio para la prueba
        App.get("/datetime", (req, resp) -> {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return "Fecha y hora actuales: " + now.format(formatter);
        });

        // Simular una solicitud y respuesta
        Request req = new Request(null);
        Response resp = new Response();

        // Obtener la fecha y hora esperadas
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String expected = "Fecha y hora actuales: " + now.format(formatter);

        // Obtener el resultado del servicio
        String result = App.getServices().get("/App/datetime").getValue(req, resp);
        
        // Verificar que la respuesta comienza con el texto esperado
        assertEquals(expected.substring(0, 18), result.substring(0, 18));
    }

    @Test
    public void testSumServiceValid() {
        // Configurar el servicio para la prueba
        App.get("/sum", (req, resp) -> {
            String num1Str = req.getValues("num1");
            String num2Str = req.getValues("num2");
            int num1, num2;

            try {
                num1 = Integer.parseInt(num1Str);
                num2 = Integer.parseInt(num2Str);
                int sum = num1 + num2;
                return "La suma de " + num1 + " y " + num2 + " es: " + sum;
            } catch (NumberFormatException e) {
                return "Por favor, proporciona números válidos para sumar.";
            }
        });

        // Simular una solicitud y respuesta
        Request req = new Request("num1=5&num2=7");
        Response resp = new Response();

        // Obtener el resultado del servicio
        String result = App.getServices().get("/App/sum").getValue(req, resp);

        // Verificar que el resultado de la suma sea el esperado
        assertEquals("La suma de 5 y 7 es: 12", result);
    }

    @Test
    public void testSumServiceInvalid() {
        // Configurar el servicio para la prueba
        App.get("/sum", (req, resp) -> {
            String num1Str = req.getValues("num1");
            String num2Str = req.getValues("num2");
            int num1, num2;

            try {
                num1 = Integer.parseInt(num1Str);
                num2 = Integer.parseInt(num2Str);
                int sum = num1 + num2;
                return "La suma de " + num1 + " y " + num2 + " es: " + sum;
            } catch (NumberFormatException e) {
                return "Por favor, proporciona números válidos para sumar.";
            }
        });

        // Simular una solicitud y respuesta
        Request req = new Request("num1=abc&num2=7");
        Response resp = new Response();

        // Obtener el resultado del servicio
        String result = App.getServices().get("/App/sum").getValue(req, resp);

        // Verificar que el servicio maneja correctamente los valores inválidos
        assertEquals("Por favor, proporciona números válidos para sumar.", result);
    }

}
