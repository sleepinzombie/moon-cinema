
import cinema.CinemaInter;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

// admin bizin  "ADD option la" cave aussi remove/de-assign theater-movie
// ONE movie to MANY theater
// theater rest BUSY c pour ca bizin cave de-assign theaer-movie
// sinon jamais theater pour free
// create table theater , chaque theater pour cave ene seulment 1 movieID

public class adminFrame extends javax.swing.JFrame 
{
    private static String ip;
    private static String name;
    Registry r;
    CinemaInter aCinemaDir;
    public adminFrame(String Ip, String Name) throws RemoteException, NotBoundException 
    {
        initComponents();
        ip = Ip;
        name = Name;
        //System.out.println(ip);
        r = LocateRegistry.getRegistry(ip,1099);
        aCinemaDir=(CinemaInter) r.lookup("CinemaService");
        
        setMoviesList();
        setTheaterList();
        setOccupiedTheater();
    }

    public void setMoviesList()
    {
        DefaultListModel listModel = new DefaultListModel();
        
        ArrayList<String> arrmovielist = new ArrayList<String>();
        
        try 
        {
            arrmovielist = aCinemaDir.getAllMovies();
            for (int i=0; i<arrmovielist.size(); i++) 
            {
                listModel.addElement(arrmovielist.get(i));
            }
        } 
        catch (RemoteException ex) 
        {
            Logger.getLogger(adminFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        MoviesList.setModel(listModel);
        
        MoviesList.setSelectedIndex(0);
        
        
    }
    
    public void setOccupiedTheater()
    {
        DefaultListModel listModel = new DefaultListModel();
        
        ArrayList<String> OccupiedTheaterlist = new ArrayList<String>();
        
        try 
        {
            OccupiedTheaterlist = aCinemaDir.getOccupiedTheater();
            for (int i=0; i<OccupiedTheaterlist.size(); i++) 
            {
                listModel.addElement(OccupiedTheaterlist.get(i));
            }
        } 
        catch (RemoteException ex) 
        {
            Logger.getLogger(adminFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        lstfreetheater.setModel(listModel);
        
    }
    
    public void setTheaterList()
    {
        DefaultListModel listModel = new DefaultListModel();
        
        ArrayList<String> arrtheaterlist = new ArrayList<String>();
        
        try 
        {
            arrtheaterlist = aCinemaDir.getAllFreeTheater();
            for (int i=0; i<arrtheaterlist.size(); i++) 
            {
                listModel.addElement(arrtheaterlist.get(i));
            }
        } 
        catch (RemoteException ex) 
        {
            Logger.getLogger(adminFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
              
        TheaterList.setModel(listModel);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnexit = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        movieId1 = new javax.swing.JLabel();
        txtMovieId1 = new javax.swing.JTextField();
        desc = new javax.swing.JLabel();
        txtMovieName1 = new javax.swing.JTextField();
        btnCreateMovie = new javax.swing.JButton();
        movie = new javax.swing.JLabel();
        movieId = new javax.swing.JLabel();
        txtDesc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDeleteMovie = new javax.swing.JTextField();
        btnDeleteMovie = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtpwd = new javax.swing.JPasswordField();
        txtRole = new javax.swing.JComboBox<>();
        User = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        role = new javax.swing.JLabel();
        txtuname = new javax.swing.JTextField();
        pwd = new javax.swing.JLabel();
        btnCreateUser = new javax.swing.JButton();
        deleteUname = new javax.swing.JLabel();
        txtDeleteUname = new javax.swing.JTextField();
        btnDeleteUser = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        ticketId1 = new javax.swing.JTextField();
        btnticket = new javax.swing.JButton();
        txtTicketId = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        MoviesList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        TheaterList = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnAssign = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstfreetheater = new javax.swing.JList<>();
        jLabel9 = new javax.swing.JLabel();
        btnDeassign = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrator Panel");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Administrators Panel");

        btnexit.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnexit.setText("EXIT");
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        movieId1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        movieId1.setText("Movie Name: ");

        txtMovieId1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMovieId1ActionPerformed(evt);
            }
        });

        desc.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        desc.setText("Description: ");

        txtMovieName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMovieName1ActionPerformed(evt);
            }
        });

        btnCreateMovie.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnCreateMovie.setText("Create Movie");
        btnCreateMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateMovieActionPerformed(evt);
            }
        });

        movie.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        movie.setText("Movies");

        movieId.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        movieId.setText("Movie Id: ");

        txtDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Movie Id:");

        txtDeleteMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDeleteMovieActionPerformed(evt);
            }
        });

        btnDeleteMovie.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnDeleteMovie.setText("Delete Movie");
        btnDeleteMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteMovieActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(movieId)
                        .addGap(32, 32, 32)
                        .addComponent(txtMovieId1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(movieId1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMovieName1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(desc)
                            .addComponent(movie)
                            .addComponent(jLabel3))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDesc)
                            .addComponent(txtDeleteMovie)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 128, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDeleteMovie, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCreateMovie, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(movie)
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(movieId)
                    .addComponent(txtMovieId1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(desc))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(movieId1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMovieName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCreateMovie)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDeleteMovie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeleteMovie)
                .addGap(17, 17, 17))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtpwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpwdActionPerformed(evt);
            }
        });

        txtRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRoleActionPerformed(evt);
            }
        });

        User.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        User.setText("Users");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Username:");

        role.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        role.setText("Role:");

        txtuname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtunameActionPerformed(evt);
            }
        });

        pwd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pwd.setText("Password:");

        btnCreateUser.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnCreateUser.setText("Create User");
        btnCreateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateUserActionPerformed(evt);
            }
        });

        deleteUname.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        deleteUname.setText("Username: ");

        txtDeleteUname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDeleteUnameActionPerformed(evt);
            }
        });

        btnDeleteUser.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnDeleteUser.setText("Delete User");
        btnDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCreateUser))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnDeleteUser))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(role)
                                    .addComponent(pwd)
                                    .addComponent(User)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(deleteUname)))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDeleteUname)
                            .addComponent(txtpwd)
                            .addComponent(txtuname)
                            .addComponent(txtRole, 0, 145, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(User)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtuname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(role)
                    .addComponent(txtRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pwd)
                    .addComponent(txtpwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCreateUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteUname)
                    .addComponent(txtDeleteUname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(btnDeleteUser)
                .addContainerGap())
        );

        txtRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "clerk"}));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("Tickets");

        ticketId1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ticketId1ActionPerformed(evt);
            }
        });

        btnticket.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnticket.setText("Cancel Ticket");
        btnticket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnticketActionPerformed(evt);
            }
        });

        txtTicketId.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTicketId.setText("Ticket Id:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 98, Short.MAX_VALUE)
                        .addComponent(btnticket))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtTicketId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ticketId1)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTicketId)
                    .addComponent(ticketId1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnticket)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        MoviesList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Mov1", "Mov2", "Mov3" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(MoviesList);

        TheaterList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Thea1", "Thea2", "Thea3" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(TheaterList);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Movie:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Free Theater:");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setText("Manage Free Theaters");

        btnAssign.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnAssign.setText("Assign");
        btnAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnAssign)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnAssign)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setText("Occupied Theater:");

        lstfreetheater.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Thea1", "Thea2", "Thea3" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(lstfreetheater);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setText("Manage Occupied Theaters");

        btnDeassign.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnDeassign.setText("De-Assign");
        btnDeassign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeassignActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDeassign)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDeassign)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(339, 339, 339)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(489, 489, 489)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnexit)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(371, 371, 371))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnexit)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnticketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnticketActionPerformed
        // TODO add your handling code here:
        try 
        {
            String ticketid = ticketId1.getText();
             if(ticketid.equals("")){
            JOptionPane.showMessageDialog(null,"Please fill all information","Alert",JOptionPane.ERROR_MESSAGE);
            }
            else{
            String result = aCinemaDir.deleteTicket(ticketid);
            
            JOptionPane.showMessageDialog(this,result);
            
            ticketId1.setText("");
             }
        } 
        catch (RemoteException ex) 
        {
            Logger.getLogger(adminFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnticketActionPerformed

    private void txtunameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtunameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtunameActionPerformed

    private void txtDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescActionPerformed

    private void txtMovieId1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMovieId1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMovieId1ActionPerformed

    private void txtMovieName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMovieName1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMovieName1ActionPerformed

    private void btnAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignActionPerformed
        // TODO add your handling code here:
        String movieselected = MoviesList.getSelectedValue().toString();
        String theaterselected = TheaterList.getSelectedValue();
        System.out.println(movieselected + theaterselected);
        String [] mid =  movieselected.split(",");
        System.out.println(mid[0]);

        try 
        {
            String result = aCinemaDir.assign(mid[0], theaterselected);
            JOptionPane.showMessageDialog(this,result);
//        try
//        {
//            String movieselected = MoviesList.getSelectedValue();
//            String theaterselected = TheaterList.getSelectedValue();
//            String result = aCinemaDir.assign(movieselected,theaterselected);
//        }
//        catch (RemoteException ex) 
//        {
//            Logger.getLogger(adminFrame.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
        setOccupiedTheater();
        setTheaterList();
        } 
        catch (RemoteException ex)
        {
            Logger.getLogger(adminFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAssignActionPerformed

    private void txtDeleteMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDeleteMovieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDeleteMovieActionPerformed

    private void ticketId1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ticketId1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ticketId1ActionPerformed

    private void txtDeleteUnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDeleteUnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDeleteUnameActionPerformed

    private void btnCreateMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateMovieActionPerformed
        // TODO add your handling code here:
        try 
        {
            String movieid = txtMovieId1.getText();
            String name = txtMovieName1.getText();
            String des = txtDesc.getText();
            
            if(movieid.equals("")||name.equals("")||des.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please fill all information","Alert",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                String result = aCinemaDir.createMovie(movieid,name,des);

                JOptionPane.showMessageDialog(this,result);
                txtMovieId1.setText("");
                txtMovieName1.setText("");
                txtDesc.setText("");

                setMoviesList();
            }
        }
        catch (RemoteException ex) 
        {
            Logger.getLogger(adminFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnCreateMovieActionPerformed

    private void btnCreateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateUserActionPerformed
        // TODO add your handling code here:

        try 
        {
            String name = txtuname.getText();
            String role = (String)txtRole.getSelectedItem();
            char [] pass = txtpwd.getPassword();
            String password = new String (pass);
            
            if(name.equals("")||role.equals("")||password.equals("")){
            JOptionPane.showMessageDialog(null,"Please fill all information","Alert",JOptionPane.ERROR_MESSAGE);
            }
            
            else{
            String result = aCinemaDir.createUser(name,role,password);
            
            JOptionPane.showMessageDialog(this,result);
            
            txtuname.setText("");
            txtRole.setSelectedIndex(0);
            txtpwd.setText("");
            }
                        
        } 
        catch (RemoteException ex) 
        {
            Logger.getLogger(adminFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCreateUserActionPerformed

    private void btnDeleteMovieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteMovieActionPerformed
        // TODO add your handling code here:
        try 
        {
            String movieid = txtDeleteMovie.getText();
            if(movieid.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please fill all information","Alert",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                String result = aCinemaDir.deleteMovie(movieid);
                JOptionPane.showMessageDialog(this,result);
                txtDeleteMovie.setText("");

                setMoviesList();
            }
        } 
        catch (RemoteException ex) 
        {
            Logger.getLogger(adminFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnDeleteMovieActionPerformed

    private void btnDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteUserActionPerformed
        // TODO add your handling code here:
        try 
        {
            String name = txtDeleteUname.getText();
            if(name.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please fill all information","Alert",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                String result = aCinemaDir.deleteUser(name);
                JOptionPane.showMessageDialog(this,result);
                txtDeleteUname.setText("");
            }
        } 
        catch (RemoteException ex) 
        {
            Logger.getLogger(adminFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnDeleteUserActionPerformed

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnexitActionPerformed

    private void txtpwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpwdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpwdActionPerformed

    private void txtRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRoleActionPerformed

    private void btnDeassignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeassignActionPerformed
        // TODO add your handling code here:
        String theaterselected = lstfreetheater.getSelectedValue().toString();
        try 
        {
            String result = aCinemaDir.deassign(theaterselected);
            JOptionPane.showMessageDialog(this,result);
        }
        catch(RemoteException ex)
        {
            Logger.getLogger(adminFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        setTheaterList();
        setOccupiedTheater(); 
    }//GEN-LAST:event_btnDeassignActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(adminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                try 
                {
                    new adminFrame(ip,name).setVisible(true);
                }
                catch (RemoteException ex)
                {
                    Logger.getLogger(adminFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                catch (NotBoundException ex) 
                {
                    Logger.getLogger(adminFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> MoviesList;
    private javax.swing.JList<String> TheaterList;
    private javax.swing.JLabel User;
    private javax.swing.JButton btnAssign;
    private javax.swing.JButton btnCreateMovie;
    private javax.swing.JButton btnCreateUser;
    private javax.swing.JButton btnDeassign;
    private javax.swing.JButton btnDeleteMovie;
    private javax.swing.JButton btnDeleteUser;
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnticket;
    private javax.swing.JLabel deleteUname;
    private javax.swing.JLabel desc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> lstfreetheater;
    private javax.swing.JLabel movie;
    private javax.swing.JLabel movieId;
    private javax.swing.JLabel movieId1;
    private javax.swing.JLabel pwd;
    private javax.swing.JLabel role;
    private javax.swing.JTextField ticketId1;
    private javax.swing.JTextField txtDeleteMovie;
    private javax.swing.JTextField txtDeleteUname;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JTextField txtMovieId1;
    private javax.swing.JTextField txtMovieName1;
    private javax.swing.JComboBox<String> txtRole;
    private javax.swing.JLabel txtTicketId;
    private javax.swing.JPasswordField txtpwd;
    private javax.swing.JTextField txtuname;
    // End of variables declaration//GEN-END:variables
}
