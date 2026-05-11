import org.omg.CORBA.*;
import org.omg.CosNaming.*;

import java.util.Scanner;

public class StringClient {
    public static void main(String[] args) throws Exception {

        ORB orb = ORB.init(args, null);

        NamingContextExt nc = NamingContextExtHelper.narrow(
                orb.resolve_initial_references("NameService"));

        // lookup object
        StringReverse obj = StringReverseHelper.narrow(
                nc.resolve_str("reverse"));

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.nextLine();

        // call remote method
        String result = obj.reverseString(s);

        System.out.println("Reversed = " + result);
    }
}