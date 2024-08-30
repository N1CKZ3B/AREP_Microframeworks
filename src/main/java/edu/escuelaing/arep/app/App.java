package edu.escuelaing.arep.app;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class App {
    private static Map<String, Service> services = new HashMap<>();
    private static String staticFilesLocation = "";

    public static void main(String[] args) {
        staticfiles("src/main/resources");

        get("/hello", (req, resp) -> {
            String name = req.getValues("name");
            return name != null && !name.isEmpty() ? "Hola " + name : "Hola unknown!";
        });

        get("/pi", (req, resp) -> String.valueOf(Math.PI));
        
        get("/datetime", (req, resp) -> {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            while(true){
                return "Fecha y hora actuales: " + now.format(formatter);
            }
            
        });

        get("/sum", (req, resp) -> {
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


        WebServer.getInstance().startServer();
    }

    public static void get(String url, Service s) {
        services.put("/App" + url, s);
        System.out.println("Service registered in: /App" + url);
    }

    public static void staticfiles(String location) {
        staticFilesLocation = location;
    }

    public static Map<String, Service> getServices() {
        return services;
    }

    public static String getStaticFilesLocation() {
        return staticFilesLocation;
    }
}