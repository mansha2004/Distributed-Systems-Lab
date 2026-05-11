
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.CosNaming.*;


public class StringServer {
    public static void main(String[] args) throws Exception {

        ORB orb = ORB.init(args, null);

        POA poa = POAHelper.narrow(
                orb.resolve_initial_references("RootPOA"));
        poa.the_POAManager().activate();

        // create object
        StringReverseImpl obj = new StringReverseImpl();

        // register object
        org.omg.CORBA.Object ref = poa.servant_to_reference(obj);

        NamingContextExt nc = NamingContextExtHelper.narrow(
                orb.resolve_initial_references("NameService"));

        nc.rebind(nc.to_name("reverse"),
                StringReverseHelper.narrow(ref));

        System.out.println("Server Ready...");
        orb.run();
    }
}

