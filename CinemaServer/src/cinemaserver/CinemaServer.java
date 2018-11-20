
package cinemaserver;

import cinema.CinemaImpl;
import cinema.CinemaInter;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CinemaServer {

    public static void main(String[] args) 
    {
        // This is cinemaServer;
        // TODO code application logic here
        System.out.println("Main ok");
        try{
            Registry r = LocateRegistry.createRegistry(1099);
            CinemaInter aCinemaDir = new CinemaImpl();
            Naming.rebind("rmi://localhost:1099/CinemaService",aCinemaDir);
            System.out.println("Directory Server ready");
        }
        catch(Exception e)
        {
            System.out.print("Directory server main " + e.getMessage());
            
        }
    }
    
}
