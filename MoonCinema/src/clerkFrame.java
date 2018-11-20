
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
        
        // quand li select 1 movie , lerla display tout theater qui ena ca movie la
        // apres li bizin choose 1 theater , si li libre alors true sinon false
        // by default li select 1st   
        
        DefaultListModel listModel1 = new DefaultListModel();
        
        ArrayList<String> arrmovielist = new ArrayList<String>();
        
        /*
        arrmovielist = aCinemaDir.getAllMovies();
        
        for (int i = 0; i < arrmovielist().size(); i++)
        {
            listModel.addElement(arrmovielist().get(i));
        }
        */
        
        listModel1.addElement("Movie1");
        listModel1.addElement("Movie2");
        listModel1.addElement("Movie3");
        
        listMovie.setModel(listModel1);
        
        listMovie.setSelectedIndex(0);
           
        ArrayList<String> arrtheaterlist = new ArrayList<String>();
        DefaultListModel listModel2 = new DefaultListModel();
        
        listMovie.addListSelectionListener(new ListSelectionListener() 
        {
            public void valueChanged(ListSelectionEvent event) 
            {
                if (!event.getValueIsAdjusting())
                {
                    JList source = (JList)event.getSource();
                    String MovieselectedL = source.getSelectedValue().toString();
                    Movieselected = MovieselectedL;
                    
                    try 
                    {
                        /*
                        arrtheaterlist = aCinemaDir.getTheater(Movieselected);

                        for (int i = 0; i < arrtheaterlist().size(); i++)
                        {
                            listMode2.addElement(arrtheaterlist().get(i));
                        }
                        */
                        listTheater.setModel(listModel2);
                        
                        listTheater.setSelectedIndex(0);
                        
                        Theaterselected = listTheater.getSelectedValue().toString();
                        
                        boolean available = aCinemaDir.checkAvailable(Movieselected,Theaterselected);
                        txtavailable.setText("Available: " + available);
                        btnTicket.setEnabled(available);
                        
                        // cave fini travail la vite vite ca

                    } 
                    catch (RemoteException ex) 
                    {
                        Logger.getLogger(clerkFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
        
                }
            }
        });

        /*
        arrtheaterlist = aCinemaDir.getTheater(Movieselected);
        
        for (int i = 0; i < arrtheaterlist().size(); i++)
        {
            listMode2.addElement(arrtheaterlist().get(i));
        }
        */
        listModel2.addElement("Theater1");
        listModel2.addElement("Theater2");
        listModel2.addElement("Theater3");

        listTheater.setModel(listModel2);
        
        listTheater.setSelectedIndex(0);
        
        listTheater.addListSelectionListener(new ListSelectionListener() 
        {
            public void valueChanged(ListSelectionEvent event) 
            {
                if (!event.getValueIsAdjusting())
                {
                    JList source = (JList)event.getSource();
                    String TheaterselectedL = source.getSelectedValue().toString();
                    Theaterselected = TheaterselectedL;
                    
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

        jLabel1 = new javax.swing.JLabel();
        txtavailable = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listTheater = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listMovie = new javax.swing.JList<>();
        btnTicket = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("Clerk");

        txtavailable.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtavailable.setText("seat Available: True");

        listTheater.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Thea1", "Thea2", "Thea3" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listTheater);

        listMovie.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Mov1", "Mov2", "Mov3" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listMovie);

        btnTicket.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnTicket.setText("Create Ticket");
        btnTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTicketActionPerformed(evt);
            }
        });

        btnExit.setText("EXIT");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(btnTicket)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jLabel1)
                        .addGap(18, 18, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExit)
                    .addComponent(txtavailable))
                .addGap(11, 11, 11))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(txtavailable)))
                .addGap(47, 47, 47)
                .addComponent(btnTicket)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(btnExit)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTicketActionPerformed
        try 
        {
            String result = aCinemaDir.createTicket(Movieselected, Theaterselected);
            if(result.equals("error"))
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listMovie;
    private javax.swing.JList<String> listTheater;
    private javax.swing.JLabel txtavailable;
    // End of variables declaration//GEN-END:variables
}
