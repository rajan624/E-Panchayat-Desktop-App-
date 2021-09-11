/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginreg;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.table.*;
/**
 *
 * @author rkp33
 */
public class LoginReg extends javax.swing.JFrame {

    /**
     * Creates new form LoginReg
     */
    public LoginReg() {
        initComponents();
         tfpanel.setVisible(false);
    }
    
    void visibilty(boolean b){
        tfname.setVisible(b);
        tfsex.setVisible(b);
        tfaddress.setVisible(b);
        tfcity.setVisible(b);
        tfstate.setVisible(b);
        tfmobile.setVisible(b); 
        lbname.setVisible(b);
        lbsex.setVisible(b);
        lbaddress.setVisible(b);
        lbcity.setVisible(b);
        lbstate.setVisible(b);
        lbmobile.setVisible(b); 
        if(b){
            tfmain.setText("Register");
            jblogin.setText("Already have an account");
        }
        else{
            tfmain.setText("Login");
            jblogin.setText("Login");   
        }
    }
    String status="user";  
    void RegisterCall(String name,String adhar ,String sex,String dob,String address,String city,String state,String mobile){
         
        try{
            Class.forName("java.sql.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost/logins","root","956248713");
            Statement star=conn.createStatement();
            String qrry =  "Insert into logindetails values("
                    +"'" +name+"',"
                    +"'" +adhar+"',"
                    +"'" +sex+"',"
                    +"'" +dob+"',"
                    +"'" +address+"',"
                    +"'" +city+"',"
                    +"'" +state+"',"
                    +"'" +mobile+"',"
                    +"'" +status+"'"
                    +")";
            star.executeUpdate(qrry);
            star.close();
            conn.close();
             JOptionPane.showMessageDialog(null, "Registration Successful");
             tfname.setText("");
               tfsex.setText("");
               tfadhar.setText("");
             tfdob.setText("");
                 tfaddress.setText("");
                  tfcity.setText("");
                   tfstate.setText("");
                    tfmobile.setText("");
        }catch(HeadlessException | ClassNotFoundException | SQLException ex){
            JOptionPane.showMessageDialog(null,"Error in connectivty"+ex);
        }
    }
    void reg(){
        visibilty(true);
    }
    void log(){
        visibilty(false);
    }
    String var1 = "staff";
    void LoginCall(String adhar ,String dob){
        boolean flag = false;
        try{
            Class.forName("java.sql.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost/logins","root","956248713");
            Statement star=conn.createStatement();
            if(tfadhar.getText().equals("admin")&&tfdob.getText().equals("admin")){
                Admin admin = new Admin();
                admin.setVisible(true);
                dispose();
              String q="select * from logindetails";
               tfpanel.setVisible(true);
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
               else{
            String qrry =  "select * from logindetails where adhar =\""+adhar+"\"and dob=\""+dob+"\" and status =\""+var1+"\";";
         
            ResultSet rs = star.executeQuery(qrry);
            while(rs.next()){
                flag=true;
                lbstatus.setText("you are "+rs.getString("status"));
            }
            if(flag){
                   JOptionPane.showMessageDialog(null,"Sucessfully Login");
                if(var1.equals("user")){
                user userobj = new user();
                userobj.setVisible(true);
                userobj.data = adhar;
                dispose();}
                else{
                        staff Stf  = new staff();
                        Stf.setVisible(true);
                                dispose();
                        }
            }else{
               JOptionPane.showMessageDialog(null,"Invalid user/password");  
            }
             
        
        }
            }
        catch(HeadlessException | ClassNotFoundException | SQLException ex){
                       
            JOptionPane.showMessageDialog(null,"Error in connectivty"+ex);
        }
        }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel = new javax.swing.JPanel();
        tfname = new javax.swing.JTextField();
        tfadhar = new javax.swing.JTextField();
        tfsex = new javax.swing.JTextField();
        tfdob = new javax.swing.JTextField();
        tfaddress = new javax.swing.JTextField();
        tfcity = new javax.swing.JTextField();
        tfstate = new javax.swing.JTextField();
        tfmobile = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lbsex = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbaddress = new javax.swing.JLabel();
        lbcity = new javax.swing.JLabel();
        lbstate = new javax.swing.JLabel();
        lbmobile = new javax.swing.JLabel();
        lbname = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jblogin = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        tfpanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tftable = new javax.swing.JTable();
        lbstatus = new javax.swing.JLabel();
        tfmain = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));

        jPanel.setBackground(new java.awt.Color(102, 102, 255));

        tfdob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdobActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Adhar No:");

        lbsex.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbsex.setForeground(new java.awt.Color(255, 255, 255));
        lbsex.setText("Sex:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Dob :");

        lbaddress.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbaddress.setForeground(new java.awt.Color(255, 255, 255));
        lbaddress.setText("Address :");

        lbcity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbcity.setForeground(new java.awt.Color(255, 255, 255));
        lbcity.setText("CIty :");

        lbstate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbstate.setForeground(new java.awt.Color(255, 255, 255));
        lbstate.setText("State :");

        lbmobile.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbmobile.setForeground(new java.awt.Color(255, 255, 255));
        lbmobile.setText("Mobile :");

        lbname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbname.setForeground(new java.awt.Color(255, 255, 255));
        lbname.setText("NAME:");

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(29, 133, Short.MAX_VALUE)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                            .addComponent(lbname, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(92, 92, 92))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                            .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbcity, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbstate, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbmobile, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(55, 55, 55)))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbsex, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfadhar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfsex, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdob, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfaddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfcity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfstate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfmobile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(112, 112, 112))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbname, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfname, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfadhar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(tfsex, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbsex, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)))
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdob, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfcity, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcity, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfstate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbstate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfmobile, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbmobile, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(102, 102, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Register");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jblogin.setBackground(new java.awt.Color(102, 102, 255));
        jblogin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jblogin.setForeground(new java.awt.Color(255, 255, 255));
        jblogin.setText("Already have an account");
        jblogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbloginActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(102, 102, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout tfpanelLayout = new javax.swing.GroupLayout(tfpanel);
        tfpanel.setLayout(tfpanelLayout);
        tfpanelLayout.setHorizontalGroup(
            tfpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tfpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        tfpanelLayout.setVerticalGroup(
            tfpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tfpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbstatus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbstatus.setForeground(new java.awt.Color(255, 255, 255));

        tfmain.setBackground(new java.awt.Color(102, 102, 255));
        tfmain.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tfmain.setForeground(new java.awt.Color(255, 255, 255));
        tfmain.setText("Register");

        jButton2.setBackground(new java.awt.Color(102, 102, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Home");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(102, 102, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Close");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tfpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(140, 140, 140)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(77, 77, 77)
                                        .addComponent(jblogin)
                                        .addGap(38, 38, 38)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(35, 35, 35)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(179, 179, 179)
                                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(400, 400, 400)
                        .addComponent(tfmain, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(tfmain, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jblogin))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3)
                        .addComponent(jButton2)))
                .addGap(35, 35, 35)
                .addComponent(tfpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        frontPage front = new frontPage();
        front.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        tfpanel.setVisible(false);
        lbstatus.setText("");
        tfadhar.setText("");
        tfdob.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jbloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbloginActionPerformed
        // TODO add your handling code here:
        if(tfmain.getText().equals("Login")){
            if(tfadhar.getText().length()==0||tfdob.getText().length()==0){
                JOptionPane.showMessageDialog(null,"Fills all details");
            }else{
                LoginCall(tfadhar.getText(),tfdob.getText());
            }
        }
        visibilty(false);
    }//GEN-LAST:event_jbloginActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        if(tfmain.getText().equals("Register")){
            if(tfname.getText().length()==0||tfadhar.getText().length()==0||tfsex.getText().length()==0||tfdob.getText().length()==0||tfaddress.getText().length()==0||tfcity.getText().length()==0||tfstate.getText().length()==0||tfmobile.getText().length()==0){
                JOptionPane.showMessageDialog(null,"Fills all details");
            }else{

                RegisterCall(tfname.getText(),tfadhar.getText(),tfsex.getText(),tfdob.getText(),tfaddress.getText(),tfcity.getText(),tfstate.getText(),tfmobile.getText());
            }
        }
        visibilty(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tfdobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdobActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed
        
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
            java.util.logging.Logger.getLogger(LoginReg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginReg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginReg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginReg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       
          
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginReg().setVisible(true);
            
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jblogin;
    private javax.swing.JLabel lbaddress;
    private javax.swing.JLabel lbcity;
    private javax.swing.JLabel lbmobile;
    private javax.swing.JLabel lbname;
    private javax.swing.JLabel lbsex;
    private javax.swing.JLabel lbstate;
    private javax.swing.JLabel lbstatus;
    private javax.swing.JTextField tfaddress;
    private javax.swing.JTextField tfadhar;
    private javax.swing.JTextField tfcity;
    private javax.swing.JTextField tfdob;
    private javax.swing.JLabel tfmain;
    private javax.swing.JTextField tfmobile;
    private javax.swing.JTextField tfname;
    private javax.swing.JPanel tfpanel;
    private javax.swing.JTextField tfsex;
    private javax.swing.JTextField tfstate;
    private javax.swing.JTable tftable;
    // End of variables declaration//GEN-END:variables
}
