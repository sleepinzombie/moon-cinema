
package cinema;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface CinemaInter extends Remote
{
    boolean checkUser (String name, String pwd) throws RemoteException;
    
    String checkRole (String name) throws RemoteException;
    
    ArrayList<String> getAllMovies() throws RemoteException;
    
    boolean checkAvailable(String movieselected , String theaterselected) throws RemoteException;
    
    String createTicket(String movieselected , String theaterselected) throws RemoteException;
    
    String createMovie(String id, String name , String des) throws RemoteException;
    
    String createUser(String id, String name , String role) throws RemoteException;
    
    String deleteMovie(String id) throws RemoteException;
    
    String deleteTicket(String id) throws RemoteException;
    
    String deleteUser(String name) throws RemoteException;
    
    ArrayList<String> getAllFreeTheater() throws RemoteException;
    
    String assign(String movie,String theater) throws RemoteException;
}
