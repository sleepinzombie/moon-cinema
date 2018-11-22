
import cinema.CinemaInter;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

// comment zot conner quand 1 theater full ??? 0 seats left
// b li decrement ?
// bon alors bizin insert so seats to database a chaque foi ?
// plus simple , met column max seat , current seats
// si admin cave cree theater lerla cave insert max seat , sinon hardcode

public class clerkFrame extends javax.swing.JFrame
{
    private static String ip;
    private static String name;
    Registry r;
    CinemaInter aCinemaDir;
    String Movieselected;
    String Theaterselected;
    
    
    
    public clerkFrame(String Ip, String Name) throws RemoteException, NotBoundException 
    {
        initComponents();
        ip = Ip;
        name = Name;
        r = LocateRegistry.getRegistry(ip,1099);
        aCinemaDir=(CinemaInter) r.lookup("CinemaService");
        
        setMoviesList();
        
        // quand li select 1 movie , lerla display tout theater qui ena ca movie la
        // apres li bizin choose 1 theater , si li libre alors true sinon false
        // by default li select 1st   
//        
//        DefaultListModel listModel1 = new DefaultListModel();
//        
//        ArrayList<String> arrmovielist = new ArrayList<String>();
//        
//        arrmovielist = aCinemaDir.getAllMovies();
//        for (int i=0; i<arrmovielist.size(); i++)
//        {
//            listModel1.addElement(arrmovielist.get(i));
//        }
//        
        /*
        arrmovielist = aCinemaDir.getAllMovies();
        
        for (int i = 0; i < arrmovielist().size(); i++)
        {
            listModel.addElement(arrmovielist().get(i));
        }
        */
        
//        listModel1.addElement("Movie1");
//        listModel1.addElement("Movie2");
//        listModel1.addElement("Movie3");
        
//        listMovie.setModel(listModel1);
//        
//        listMovie.setSelectedIndex(0);
           
        ArrayList<String> arrtheaterlist = new ArrayList<String>();
        
        
        
        
        listMovie.addListSelectionListener(new ListSelectionListener() {
            DefaultListModel listModel2 = new DefaultListModel();
            ArrayList<Integer> tlist = new ArrayList<Integer>();
            
             public void valueChanged(ListSelectionEvent event) {
                 listModel2.clear();
                 if (!event.getValueIsAdjusting())
                {
                    JList source = (JList)event.getSource();
                    String MovieselectedL = source.getSelectedValue().toString();
                    Movieselected = MovieselectedL;
                    String [] mid =  Movieselected.split(",");
                    System.out.println(mid[0]);
                    
                    try {
                        tlist = aCinemaDir.getTheaterByMovieID(mid[0]);
                        for (int i=0; i<tlist.size(); i++) {
                            listModel2.addElement(tlist.get(i));
                        }
                        
                        listTheater.setModel(listModel2);
                        
                    }
                    catch (RemoteException ex) 
                    {
                        Logger.getLogger(clerkFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
             }
                 
        }
             
    });
    
                  
//        listMovie.addListSelectionListener(new ListSelectionListener() 
//        {
//            public void valueChanged(ListSelectionEvent event) 
//            {
//                if (!event.getValueIsAdjusting())
//                {
//                    JList source = (JList)event.getSource();
//                    String MovieselectedL = source.getSelectedValue().toString();
//                    Movieselected = MovieselectedL;
//                    
//                    try 
//                    {
//                        /*
//                        arrtheaterlist = aCinemaDir.getTheater(Movieselected);
//
//                        for (int i = 0; i < arrtheaterlist().size(); i++)
//                        {
//                            listMode2.addElement(arrtheaterlist().get(i));
//                        }
//                        */
//                        listTheater.setModel(listModel2);
//                        
//                        listTheater.setSelectedIndex(0);
//                        
//                        Theaterselected = listTheater.getSelectedValue().toString();
//                        
//                        boolean available = aCinemaDir.checkAvailable(Movieselected,Theaterselected);
//                        txtavailable.setText("Available: " + available);
//                        btnTicket.setEnabled(available);
//                        
//                        // cave fini travail la vite vite ca
//
//                    } 
//                    catch (RemoteException ex) 
//                    {
//                        Logger.getLogger(clerkFrame.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//        
//                }
//            }
//        });

        /*
        arrtheaterlist = aCinemaDir.getTheater(Movieselected);
        
        for (int i = 0; i < arrtheaterlist().size(); i++)
        {
            listMode2.addElement(arrtheaterlist().get(i));
        }
        */

//        listTheater.setModel(listModel2);
//        
//        listTheater.setSelectedIndex(0);
        
        listTheater.addListSelectionListener(new ListSelectionListener() 
        {
            public void valueChanged(ListSelectionEvent event) 
            {
                if (!event.getValueIsAdjusting())
                {
                    JList source = (JList)event.getSource();
                    String TheaterselectedL = source.getSelectedValue().toString();
                    Theaterselected = TheaterselectedL;
                    System.out.print(Theaterselected);
                    
                    try 
                    {
                        boolean available = aCinemaDir.checkAvailable(Movieselected,Theaterselected);
                        txtavailable.setText("Available: " + available);
                        btnTicket.setEnabled(available);
                    } 
                    catch (RemoteException ex) 
                    {
                        Logger.getLogger(clerkFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
        boolean available = aCinemaDir.checkAvailable(Movieselected,Theaterselected);
        txtavailable.setText("Available: " + available);
        btnTicket.setEnabled(available);
   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listMovie = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listTheater = new javax.swing.JList<>();
        txtavailable = new javax.swing.JLabel();
        btnTicket = new javax.swing.JButton();

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Clerk Panel");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Clerks Panel");

        btnExit.setText("EXIT");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Movie:");

        jLabel6.setText("Tickets Creation");

        listMovie.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Mov1", "Mov2", "Mov3" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listMovie);

        jLabel4.setText("Theatre:");

        jScrollPane1.setViewportView(listTheater);

        txtavailable.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtavailable.setText("Seat Available: True");

        btnTicket.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnTicket.setText("Create Ticket");
        btnTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTicketActionPerformed(evt);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnTicket)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtavailable)
                .addGap(140, 140, 140))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtavailable)
                .addGap(18, 18, 18)
                .addComponent(btnTicket)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExit))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel2)
                                .addGap(93, 93, 93)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(263, 263, 263)
                                .addComponent(jLabel1)))
                        .addGap(0, 94, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel2)
                .addContainerGap(386, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExit)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        
        listMovie.setModel(listModel);
        
        //listMovie.setSelectedIndex(0);
        
        
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
        
        listTheater.setModel(listModel);
//        listTheater.setSelectedIndex(0);
    }
    
    private void btnTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTicketActionPerformed
        try 
        {
            String [] mid =  Movieselected.split(",");
            System.out.println(mid[0]);
            int result = aCinemaDir.createTicket(mid[0], Theaterselected);
            if(result == 0)
            {
                JOptionPane.showMessageDialog(this,"Error");
            }
            else
            {
                JOptionPane.showMessageDialog(this,result); //display id
            }
            
//            clerkFrame c = new clerkFrame(ip,name);
//            c.setVisible(true);
//            this.dispose();
        } 
        catch (RemoteException ex)
        {
            Logger.getLogger(clerkFrame.class.getName()).log(Level.SEVERE, null, ex);
        } 
//        catch (NotBoundException ex) 
//        {
//            Logger.getLogger(clerkFrame.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_btnTicketActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

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
            java.util.logging.Logger.getLogger(clerkFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(clerkFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(clerkFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(clerkFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                try 
                {
                    new clerkFrame(ip,name).setVisible(true);
                } 
                catch (RemoteException ex) 
                {
                    Logger.getLogger(clerkFrame.class.getName()).log(Level.SEVERE, null, ex);
                } 
                catch (NotBoundException ex)
                {
                    Logger.getLogger(clerkFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnTicket;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listMovie;
    private javax.swing.JList<String> listTheater;
    private javax.swing.JLabel txtavailable;
    // End of variables declaration//GEN-END:variables
}
