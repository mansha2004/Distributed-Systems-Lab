package mutualexclusion;

import java.util.*;
public class TokenRing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();
        int token = 0; // Start with process 1
        System.out.println("\n--- Token Ring Execution ---\n");
        for (int i = 0; i < n; i++) {
            System.out.println("Token is with Process " + (token + 1));
            System.out.println("Process " + (token + 1) + " ENTERING Critical Section...");          
            // Simulate work
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Process " + (token + 1) + " EXITING Critical Section...\n");
            // Pass token to next process
            token = (token + 1) % n;
        }
        sc.close();
    }
}

