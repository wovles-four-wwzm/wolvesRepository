package Moive_booking;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class User_login extends javax.swing.JFrame {


    public User_login() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        t1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        p1 = new javax.swing.JPasswordField();
        Jbutton = new javax.swing.JToggleButton();
        Cancel = new javax.swing.JToggleButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("宋体", 0, 36)); // NOI18N
        jLabel1.setText("狼人电影");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        jLabel2.setText("用户名：");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, -1, -1));
        getContentPane().add(t1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 246, -1));

        jLabel3.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        jLabel3.setText("密码：");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, -1, -1));
        getContentPane().add(p1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 246, -1));

        Jbutton.setText("登录");
        Jbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(Jbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 82, -1));

        Cancel.setText("取消");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });
        getContentPane().add(Cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, 86, -1));

        jLabel4.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jLabel4.setText("新用户？");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
        System.exit(0);
    }//GEN-LAST:event_CancelActionPerformed

    private void JbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbuttonActionPerformed
         ResultSet rs;     
        PreparedStatement pst; 
        if(evt.getSource()==Jbutton) {
        try{
           Connection con=DBclass.getConnection();
        String sql="select * from User where UserName=? and Password=?";
        pst=con.prepareStatement(sql);
        pst.setString(1,t1.getText());
        pst.setString(2,p1.getText());
        rs=pst.executeQuery();
        if(t1.getText().length()==0){
            JOptionPane.showMessageDialog(this,"Empty User Name","Warning",JOptionPane.WARNING_MESSAGE);
        }else if(p1.getText().length()==0){
            JOptionPane.showMessageDialog(this,"Empty Password","Warning",JOptionPane.WARNING_MESSAGE);
        }else if(rs.next()){
            Moive_booking w=new Moive_booking();
            w.show();
            this.hide();
        }else{
            JOptionPane.showMessageDialog(this,"Incorrect User Name or Password","Error",JOptionPane.WARNING_MESSAGE);
        }
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("can not connect mysql");
        }
    }          

    }//GEN-LAST:event_JbuttonActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        User_Register n = new User_Register();
        n.show();
        this.hide();
    }//GEN-LAST:event_jLabel4MouseClicked


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new User_login().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton Cancel;
    private javax.swing.JToggleButton Jbutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField p1;
    private javax.swing.JTextField t1;
    // End of variables declaration//GEN-END:variables
}
