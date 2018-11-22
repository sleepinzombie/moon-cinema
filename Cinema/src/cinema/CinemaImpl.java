
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
        try 
        {
            rs = S.executeQuery(query);
            while (rs.next()) 
            {
                String result;
                result = rs.getString("MovieID")+","+rs.getString("Name");
                arrList.add(result);
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(CinemaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("getallmovies");
        return arrList;
    }

    public boolean checkAvailable(String movieselected , String theaterselected) throws RemoteException
    {
        String query = "SELECT NumOfSeat FROM theatre WHERE TheatreID=" + theaterselected + "";
        ResultSet rs;
        boolean reply = true;
        
        try {
            rs = S.executeQuery(query);
            while (rs.next())
            {
                System.out.println(rs.getInt("NumOfSeat"));
                if (rs.getInt("NumofSeat") > 0)
                {
                    reply = true;
                }
                else
                {
                    reply = false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CinemaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("checkavailable");
        return reply;
    }
    
    public int createTicket(String movieselected , String theaterselected) throws RemoteException
    {
        System.out.println("createticket");
        int generatedID = 0;
        String insert = "INSERT INTO tickets (MovieID, TheatreID) VALUES ('"+movieselected+"', '"+theaterselected+"')";
        String DecrementSeats = "UPDATE theatre SET NumOfSeat = NumOfSeat - 1 WHERE TheatreID='" + theaterselected + "'";
        
        try {
            S.executeUpdate(insert, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = S.getGeneratedKeys();
            rs.next();
            generatedID = rs.getInt(1);
            S.executeUpdate(DecrementSeats);
            
        } catch (SQLException ex) {
            Logger.getLogger(CinemaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
       return generatedID; 
    }
    
    public String createMovie(String id, String name , String des) throws RemoteException
    {
          String sql = "INSERT INTO movies (MovieID,Name,Description) VALUES('"+id+"','"+name+"','"+des+"')";
        try {
            S.executeUpdate(sql);
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
        String queryForTheatre = "SELECT TheatreID FROM tickets WHERE TicketID='" + id + "'";
        ResultSet rs;
        
        try {
            rs = S.executeQuery(queryForTheatre);
            rs.next();
            int theatreID = rs.getInt("TheatreID");
            String IncrementSeats = "UPDATE theatre SET NumOfSeat = NumOfSeat + 1 WHERE TheatreID='" + theatreID + "'";
            S.executeUpdate(IncrementSeats);
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
        String query = "SELECT TheatreID FROM theatre WHERE MovieID IS NULL";
        ResultSet rs;
        
        ArrayList<String> result = new ArrayList<String>();
        
        try 
        {
            rs = S.executeQuery(query);
            while(rs.next())
            {
                result.add(rs.getString("TheatreID"));
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(CinemaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("getAllFreeTheater");
        return result;
    }
    
    public ArrayList<Integer> getTheaterByMovieID(String movie) {
        String query = "SELECT TheatreID FROM theatre WHERE MovieID='" + movie + "'";
        ResultSet rs;
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        try {
            rs = S.executeQuery(query);
            while (rs.next()) {
                result.add(rs.getInt("TheatreID"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CinemaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
    
    public String assign(String movie,String theater) throws RemoteException
    {
        String query = "SELECT * FROM theatre WHERE TheatreID ='" + theater + "'";
        ResultSet rs;
        String reply = "";
        
        try 
        {
            rs = S.executeQuery(query);
            rs.next();
                if (rs.getString("MovieID") != null) 
                {
                    reply = "This theatre is already booked.";
                } 
                else 
                {
                    String update = "UPDATE theatre SET MovieID='" + movie + "' WHERE TheatreID='" + theater + "'";
                    S.executeUpdate(update);
                    reply = "Theatre has been booked!";
                }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(CinemaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("assign movie to theater");
        return reply;
    }
   
    public ArrayList<String> getOccupiedTheater() throws RemoteException
    {
        String query = "SELECT TheatreID FROM theatre WHERE MovieID IS NOT NULL"; 
        ResultSet rs;
        
        ArrayList<String> result = new ArrayList<String>();
        
        try 
        {
            rs = S.executeQuery(query);
            while(rs.next())
            {
                result.add(rs.getString("TheatreID"));
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(CinemaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }
    
    public String deassign(String theater) throws RemoteException 
    {
        String reply = "";
        
        try 
        {
            String update = "UPDATE theatre SET MovieID = NULL WHERE TheatreID='" + theater + "'";
            S.executeUpdate(update);
            reply = "Theatre has been cleared out.";
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(CinemaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("deassign");
        return reply;
    }
}
