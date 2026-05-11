package ds;

import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) {

        try {

            Socket socket = new Socket("localhost", 6000);

            BufferedReader userInput =
                    new BufferedReader(new InputStreamReader(System.in));

            BufferedReader input =
                    new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));

            PrintWriter output =
                    new PrintWriter(socket.getOutputStream(), true);

            System.out.print("Enter message: ");

            String message = userInput.readLine();

            output.println(message);

            String serverResponse = input.readLine();

            System.out.println("Server says: " + serverResponse);

            socket.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}