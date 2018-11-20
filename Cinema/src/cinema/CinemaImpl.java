
package cinema;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CinemaImpl extends UnicastRemoteObject implements CinemaInter 
{
    Connection con;
    Statement S;

    
    public CinemaImpl() throws RemoteException
    {
        try
        {
            //met servername , uname , password
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/moon-cinema?autoReconnect=true&useSSL=false" , "root" , "");
            S=con.createStatement();
        }
        catch(SQLException err)
        {
            System.out.println(err.getMessage());
        }    
    }
    
    public boolean checkUser(String name, String pwd) throws RemoteException 
    {
        String sql = "Select * from users where Username='" + name + "' and Password='" + pwd + "'";
        boolean reply = true;
        try 
        {
            ResultSet rs = S.executeQuery(sql);
            if(rs.next())
            {
                reply = true;
            }
            else
            {
                reply = false;
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(CinemaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("checkuser: " + reply);
        return reply;
    }

    public String checkRole(String name) throws RemoteException 
    {
        String reply ="";
        try 
        {
            String sql = "Select Role from users where Username='" + name + "'";
            ResultSet rs = S.executeQuery(sql);
            rs.next();
            String role = rs.getString("Role");
            switch(role)
            {
                case "clerk":
                    reply = "clerk";
                break;
                case "admin":
                    reply = "admin";
                break;
                default:
                    reply = "error";
                break;
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(CinemaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("checkrole: " + reply);
        return reply;
    }
    
    public ArrayList<String> getAllMovies() throws RemoteException
    {
        ArrayList<String> arrList = new ArrayList<String>();
        String query = "SELECT * FROM movies";
        ResultSet rs;
        try {
            rs = S.executeQuery(query);
            while (rs.next()) {
                String result;
                result = rs.getString("MovieID")+","+rs.getString("Name");
                arrList.add(result);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CinemaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("getallmovies");
        return arrList;
    }

    public boolean checkAvailable(String movieselected , String theaterselected) throws RemoteException
    {
        System.out.println("checkavailable");
        boolean abc = Math.random() < 0.5; // return randomly true or false
        return abc;
        // return true si ena encore place dans theater-movie
    }
    
    public String createTicket(String movieselected , String theaterselected) throws RemoteException
    {
        System.out.println("createticket");
        // generate ticket ID and return
       // re-perform checkAvailable
       // return ticket id or error 
       // decrement theater 
       // ticket : id , movieID , theater , price si bizin , ...
       return Math.random()*10000000 + ""; 
    }
    
    public String createMovie(String id, String name , String des) throws RemoteException
    {
          String sql = "INSERT INTO movies (MovieID,Name,Description) VALUES('"+id+"','"+name+"','"+des+"')";
        try {
            S.executeUpdate(sql);
//        String sql = "INSERT IGNORE INTO movies VALUES(?,?,?)";
//        try {
//            PreparedStatement St=con.prepareStatement(sql);
//            St.setString(1,id);
//            St.setString(2,name);
//            St.setString(3,des);
//            St.executeUpdate();
//            return "Movie Successfully Created";
//        } catch (SQLException ex) {
//            Logger.getLogger(CinemaImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
        } catch (SQLException ex) {
            Logger.getLogger(CinemaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("createmovie");
        return"Movie successfull Created";
       
    }
    
    public String createUser(String name , String role, String password) throws RemoteException
    {
        String sql = "INSERT INTO users (Username,Password,Role)VALUES('"+name+"','"+password+"','"+role+"')";
        try {
            S.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CinemaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("createuser");
        return "User Successfully Created";
        // met BACK dans clerk+admin
    }
    
    public String deleteMovie(String id) throws RemoteException
    {   
        String query = "SELECT MovieID FROM movies WHERE MovieID='" + id + "'";
        ResultSet rs;
        String reply = "";
        try {
            rs = S.executeQuery(query);
            if (rs.next()) {
                String sql = "DELETE FROM movies WHERE MovieID='"+id+"'";
                try {
                    S.executeUpdate(sql);
                } catch (SQLException ex) {
                    Logger.getLogger(CinemaImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("deletemovie");
                reply = "Movie Successfully Deleted!";
            }
            else {
                reply = "Movie Not Found!";
            }
        } catch (SQLException ex) {
            Logger.getLogger(CinemaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return reply;
    }
    
    public String deleteTicket(String id) throws RemoteException
    {   
        String sql = "DELETE FROM tickets WHERE TicketID='"+id+"'";
        try {
            S.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(CinemaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("deleteticket");
        return "Ticket Successfully Deleted";
    }
    
    public String deleteUser(String name) throws RemoteException
    {  
        String query = "SELECT Username FROM users WHERE Username='" + name + "'";
        ResultSet rs;
        String reply = "";
        
        try {
            rs = S.executeQuery(query);
            if (rs.next()) {
                String sql = "DELETE FROM users WHERE Username='"+name+"'";
                try {
                    S.executeUpdate(sql);
                } catch (SQLException ex) {
                    Logger.getLogger(CinemaImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("deleteuser");
                reply = "User Successfully Deleted!";
            } else {
                reply = "User Not Found!";
            }
        } catch (SQLException ex) {
            Logger.getLogger(CinemaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
       return reply; 
    }
    
    public ArrayList<String> getAllFreeTheater() throws RemoteException
    {
        String query = "SELECT * FROM theatre";
        ResultSet rs;
        ArrayList<String> theatresList = new ArrayList<String>();
        
        try {
            rs = S.executeQuery(query);
            while (rs.next()) {
                theatresList.add(rs.getString("TheatreID"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CinemaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        //return theater(name/ID) qui FREE
        System.out.println("getallfreetheater");
        return theatresList;
    }
    
    public String assign(String movie,String theater) throws RemoteException
    {
        String query = "SELECT * FROM theatre WHERE TheatreID ='" + theater + "'";
        ResultSet rs;
        String reply = "";
        
        try {
            rs = S.executeQuery(query);
            rs.next();
                if (rs.getString("MovieID") != null) {
                    reply = "This theatre is already booked.";
                } else {
                    String update = "UPDATE theatre SET MovieID='" + movie + "' WHERE TheatreID='" + theater + "'";
                    S.executeUpdate(update);
                    reply = "Theatre has been booked!";
                }
        } catch (SQLException ex) {
            Logger.getLogger(CinemaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        // avan assign ,  re-check si theater encore libre
        System.out.println("assign movie to theater");
        return reply;
    }
}