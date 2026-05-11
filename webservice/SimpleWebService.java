import com.sun.net.httpserver.*; 
import java.io.*; 
import java.net.*; 
public class SimpleWebService { 
public static void main(String[] args) throws Exception { 
HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0); 
server.createContext("/add", (exchange) -> { 
String query = exchange.getRequestURI().getQuery(); 
String[] params = query.split("&"); 
int a = Integer.parseInt(params[0].split("=")[1]); 
int b = Integer.parseInt(params[1].split("=")[1]); 
int result = a + b; 
String response = "Result = " + result; 
exchange.sendResponseHeaders(200, response.length()); 
OutputStream os = exchange.getResponseBody(); 
os.write(response.getBytes()); 
os.close(); 
}); 
server.start(); 
System.out.println("Server running at http://localhost:8000"); 
} 
}
student database
  import com.sun.net.httpserver.*;
import java.io.*;
import java.net.*;

public class StudentDatabaseService {

    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        server.createContext("/student", (exchange) -> {

            String query = exchange.getRequestURI().getQuery();

            String roll = query.split("=")[1];

            String response = "";

            if(roll.equals("101")) {
                response = "Name: Ali, Branch: CSE, CGPA: 8.9";
            }
            else if(roll.equals("102")) {
                response = "Name: Sara, Branch: IT, CGPA: 9.1";
            }
            else {
                response = "Student Not Found";
            }

            exchange.sendResponseHeaders(200, response.length());

            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });

        server.start();

        System.out.println("Student Database Server running at http://localhost:8000");
    }
}
command http://localhost:8000/student?roll=101

  weather prediction
  import com.sun.net.httpserver.*;
import java.io.*;
import java.net.*;

public class WeatherPredictionService {

    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        server.createContext("/weather", (exchange) -> {

            String query = exchange.getRequestURI().getQuery();

            String city = query.split("=")[1];

            String response = "";

            if(city.equalsIgnoreCase("Srinagar")) {
                response = "Weather: 18°C, Cloudy";
            }
            else if(city.equalsIgnoreCase("Delhi")) {
                response = "Weather: 35°C, Sunny";
            }
            else {
                response = "Weather data not available";
            }

            exchange.sendResponseHeaders(200, response.length());

            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });

        server.start();

        System.out.println("Weather Server running at http://localhost:8000");
    }
}
command-http://localhost:8000/weather?city=Srinagar

  currency exchange
  import com.sun.net.httpserver.*;
import java.io.*;
import java.net.*;

public class CurrencyExchangeService {

    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        server.createContext("/convert", (exchange) -> {

            String query = exchange.getRequestURI().getQuery();

            String[] params = query.split("&");

            double amount = Double.parseDouble(params[0].split("=")[1]);

            double rate = 83.5;

            double converted = amount * rate;

            String response = "Converted Amount in INR = " + converted;

            exchange.sendResponseHeaders(200, response.length());

            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });

        server.start();

        System.out.println("Currency Exchange Server running at http://localhost:8000");
    }
} command http://localhost:8000/convert?amount=10
  
  
