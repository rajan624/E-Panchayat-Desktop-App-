/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginreg;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rkp33
 */
public class details extends javax.swing.JFrame {

    /**
     * Creates new form details
     */
    public details() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
  
    void applydetail(String adhar2){
        int i =0;
        System.out.print(adhar2);
        try{
            Class.forName("java.sql.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost/logins","root","956248713");
            Statement star=conn.createStatement();
              String q="select * from apply where applyadhar = "+"'"+adhar2+"';";
               jPanel1.setVisible(true);
               ResultSet rsa = star.executeQuery(q);
                  DefaultTableModel tbmodel=(DefaultTableModel) tftable.getModel();
                 tbmodel.setRowCount(0);
               while(rsa.next()){
                   String name1=rsa.getString("applyid");
                    String adhar1=rsa.getString("applyadhar");
                     String sex1=rsa.getString("servicesid");
                      String dob1=rsa.getString("staff");
                       String address1=rsa.getString("officer");
                        String city1=rsa.getString("phone");
                          String tbdata []={name1,adhar1,sex1,dob1,address1,city1," "," "," "};
               //  DefaultTableModel tbmodel=(DefaultTableModel) tftable.getModel();
              //   tbmodel.setRowCount(0);
                 tbmodel.addRow(tbdata);
                 i++;
               }
               if(i==0){
                    JOptionPane.showMessageDialog(null,"you nothing apply"+adhar2);
                    user User = new user();
                    User.setVisible(true);
                    dispose();
               }
               conn.close();
        
            
            
}
        catch(HeadlessException | ClassNotFoundException | SQLException ex){
                       
            JOptionPane.showMessageDialog(null,"Error in connectivty"+ex);
        }
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tftable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 255));

        tftable.setBackground(new java.awt.Color(0, 51, 102));
        tftable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 51)));
        tftable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tftable.setForeground(new java.awt.Color(153, 255, 255));
        tftable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Name", "Adhar no", "Sex", "Dob", "Address", "City", "State", "Mobile no", "Status"
            }
        ));
        jScrollPane2.setViewportView(tftable);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("           User Details ");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton1.setBackground(new java.awt.Color(0, 0, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setText("close");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(334, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(305, 305, 305))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(343, 343, 343)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(321, 321, 321)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(435, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(846, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
void detail(String ulser){
        try{
            Class.forName("java.sql.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost/logins","root","956248713");
            Statement star=conn.createStatement();
              String q="select * from logindetails";
               jPanel1.setVisible(true);
               ResultSet rsa = star.executeQuery(q);
                  DefaultTableModel tbmodel=(DefaultTableModel) tftable.getModel();
                 tbmodel.setRowCount(0);
               while(rsa.next()){
                   String name1=rsa.getString("name");
                    String adhar1=rsa.getString("adhar");
                     String sex1=rsa.getString("sex");
                      String dob1=rsa.getString("dob");
                       String address1=rsa.getString("address");
                        String city1=rsa.getString("city");
                         String state1=rsa.getString("state");
                          String mobile1=rsa.getString("mobile");
                          String status1=rsa.getString("status");
                          String tbdata []={name1,adhar1,sex1,dob1,address1,city1,state1,mobile1,status1};
               //  DefaultTableModel tbmodel=(DefaultTableModel) tftable.getModel();
              //   tbmodel.setRowCount(0);
                 tbmodel.addRow(tbdata);
               }
               conn.close();
        
            
            
}
        catch(HeadlessException | ClassNotFoundException | SQLException ex){
                       
            JOptionPane.showMessageDialog(null,"Error in connectivty"+ex);
        }
        }
        
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
            java.util.logging.Logger.getLogger(details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new details().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tftable;
    // End of variables declaration//GEN-END:variables
}
