
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
    }

    public void setMoviesList()
    {
        DefaultListModel listModel = new DefaultListModel();
        
        ArrayList<String> arrmovielist = new ArrayList<String>();
        
        try {
            arrmovielist = aCinemaDir.getAllMovies();
            for (int i=0; i<arrmovielist.size(); i++) {
                listModel.addElement(arrmovielist.get(i));
            }
        } catch (RemoteException ex) {
            Logger.getLogger(adminFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        /*
        arrmovielist = aCinemaDir.getAllMovies();
        
        for (int i = 0; i < arrmovielist().size(); i++)
        {
            listModel.addElement(arrmovielist().get(i));
        }
        */ 
        
        // un comment /**/ apres comment ban addElement la
//        listModel.addElement("Movie1");
//        listModel.addElement("Movie2");
//        listModel.addElement("Movie3");
        
        MoviesList.setModel(listModel);
        
        MoviesList.setSelectedIndex(0);
    }
    
    public void setTheaterList()
    {
        DefaultListModel listModel = new DefaultListModel();
        
        ArrayList<String> arrtheaterlist = new ArrayList<String>();
        
        try {
            arrtheaterlist = aCinemaDir.getAllFreeTheater();
            for (int i=0; i<arrtheaterlist.size(); i++) {
                listModel.addElement(arrtheaterlist.get(i));
            }
        } catch (RemoteException ex) {
            Logger.getLogger(adminFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        /*
        arrtheaterlist = aCinemaDir.getAllFreeTheater();
        
        for (int i = 0; i < arrtheaterlist.size(); i++)
        {
            listModel.addElement(arrtheaterlist.get(i));
        }
        */
        
//        listModel.addElement("Theater1");
//        listModel.addElement("Theater2");
//        listModel.addElement("Theater3");
        
        TheaterList.setModel(listModel);
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnticket = new javax.swing.JButton();
        txtuname = new javax.swing.JTextField();
        txtTicketId = new javax.swing.JLabel();
        movie = new javax.swing.JLabel();
        movieId = new javax.swing.JLabel();
        txtDesc = new javax.swing.JTextField();
        movieId1 = new javax.swing.JLabel();
        txtMovieId1 = new javax.swing.JTextField();
        desc = new javax.swing.JLabel();
        txtMovieName1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        MoviesList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        TheaterList = new javax.swing.JList<>();
        btnAssign = new javax.swing.JButton();
        btnCreateMovie = new javax.swing.JButton();
        btnDeleteMovie = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtDeleteMovie = new javax.swing.JTextField();
        User = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ticketId1 = new javax.swing.JTextField();
        role = new javax.swing.JLabel();
        pwd = new javax.swing.JLabel();
        btnCreateUser = new javax.swing.JButton();
        deleteUname = new javax.swing.JLabel();
        txtDeleteUname = new javax.swing.JTextField();
        btnDeleteUser = new javax.swing.JButton();
        btnexit = new javax.swing.JButton();
        txtpwd = new javax.swing.JPasswordField();
        txtRole = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("Admin");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Ticket");

        btnticket.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnticket.setText("Cancel Ticket");
        btnticket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnticketActionPerformed(evt);
            }
        });

        txtuname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtunameActionPerformed(evt);
            }
        });

        txtTicketId.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTicketId.setText("Ticket Id:");

        movie.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        movie.setText("Movie");

        movieId.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        movieId.setText("Movie Id: ");

        txtDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescActionPerformed(evt);
            }
        });

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

        btnAssign.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnAssign.setText("Assign");
        btnAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignActionPerformed(evt);
            }
        });

        btnCreateMovie.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCreateMovie.setText("Create Movie");
        btnCreateMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateMovieActionPerformed(evt);
            }
        });

        btnDeleteMovie.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnDeleteMovie.setText("Delete Movie");
        btnDeleteMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteMovieActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Movie Id:");

        txtDeleteMovie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDeleteMovieActionPerformed(evt);
            }
        });

        User.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        User.setText("User");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Username:");

        ticketId1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ticketId1ActionPerformed(evt);
            }
        });

        role.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        role.setText("Role:");

        pwd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pwd.setText("Password:");

        btnCreateUser.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
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

        btnDeleteUser.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnDeleteUser.setText("Delete User");
        btnDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteUserActionPerformed(evt);
            }
        });

        btnexit.setText("EXIT");
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });

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

        jLabel5.setText("Movie:");

        jLabel6.setText("Theatre:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAssign)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnexit))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(movie)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(movieId)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtMovieId1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(movieId1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtMovieName1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(desc)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(65, 65, 65)
                                        .addComponent(jLabel6)))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(134, 134, 134)
                                        .addComponent(User)
                                        .addGap(168, 168, 168)
                                        .addComponent(jLabel2))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnDeleteUser)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(jLabel1)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addComponent(jLabel4)
                                                                    .addComponent(role)
                                                                    .addComponent(pwd)))
                                                            .addComponent(deleteUname))
                                                        .addGap(32, 32, 32)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(txtuname, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                                            .addComponent(txtDeleteUname, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                                            .addComponent(txtpwd)
                                                            .addComponent(txtRole, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(5, 5, 5)
                                                        .addComponent(btnCreateUser)))
                                                .addGap(51, 51, 51)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(txtTicketId)
                                                        .addGap(29, 29, 29)
                                                        .addComponent(ticketId1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(btnticket)))))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(17, 17, 17)
                                .addComponent(txtDeleteMovie, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnCreateMovie)
                            .addComponent(btnDeleteMovie))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(movie)
                    .addComponent(User)
                    .addComponent(jLabel2))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(movieId)
                            .addComponent(txtMovieId1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(movieId1)
                            .addComponent(txtMovieName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(desc)
                            .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCreateMovie)
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtDeleteMovie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDeleteMovie)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAssign)
                            .addComponent(btnexit))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtuname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTicketId)
                                .addComponent(ticketId1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(role)
                                .addComponent(txtRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnticket))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pwd)
                            .addComponent(txtpwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addComponent(btnCreateUser)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deleteUname, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDeleteUname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeleteUser)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        txtRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "clerk"}));

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
        String movieselected = MoviesList.getSelectedValue();
        String theaterselected = TheaterList.getSelectedValue();
        System.out.println(movieselected + theaterselected);
        String [] mid =  movieselected.split(",");
        System.out.println(mid[0]);

        try {
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
//        setTheaterList();
        } catch (RemoteException ex) {
            Logger.getLogger(adminFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        setTheaterList();
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
            
            if(movieid.equals("")||name.equals("")||des.equals("")){
            JOptionPane.showMessageDialog(null,"Please fill all information","Alert",JOptionPane.ERROR_MESSAGE);
            }
            
            else{
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
            if(movieid.equals("")){
            JOptionPane.showMessageDialog(null,"Please fill all information","Alert",JOptionPane.ERROR_MESSAGE);
            }
            else{
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
             if(name.equals("")){
            JOptionPane.showMessageDialog(null,"Please fill all information","Alert",JOptionPane.ERROR_MESSAGE);
            }
            else{
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
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
