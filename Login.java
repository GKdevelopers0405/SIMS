import java.sql.*;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author pavan kumar
 */
public class Login extends javax.swing.JFrame {

    private String username;
    private String password;
    static Connection con;

    public Login() throws SQLException {
        try {
            initComponents();
            ImageIcon icon = new ImageIcon("C:\\Program Files\\SIMS\\StudentWhite.png");
            setIconImage(icon.getImage());
            setTitle("Login");
             DataBaseConnection dbc = new DataBaseConnection();
            con= dbc.getCon();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    public void check() {
        try {
            username = Username.getText().trim();
            password = new String(Password.getPassword()).trim();
            if (!username.equals("") && !password.equals("")) {
                if ((username.contains("aj") || username.contains("AJ")) && username.length() == 10) {
                    boolean checkstudent = checkStudent(username, password);
                    if (checkstudent) {
                        JOptionPane.showMessageDialog(null, "Login Sucessfull...!");
                        dispose();
                        Student student = new Student();
                        student.setTitle(username.toUpperCase());
                        student.setVisible(true);
                        student.displaydetails(username, branch(username));
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid user credentials", "Alert", JOptionPane.WARNING_MESSAGE);
                    }
                } else if ((username.equals("student") && password.equals("pavan"))) {
                    JOptionPane.showMessageDialog(null, "Login Sucessfull...!");
                    dispose();
                    MainFrame f1;

                    f1 = new MainFrame();
                    f1.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid user credentials", "Alert", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid user credentials", "Alert", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    /**
     *
     * @param regd
     * @param password
     * @return
     */
    public boolean checkStudent(String regd, String password) {
        try {
            String branch = branch(regd);
            if (!branch.equals("NAN")) {
                String query = "Select password from " + branch + " where regd=?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, regd);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return password.equals(rs.getString("password"));
                }
            } else {
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return false;
    }

    /**
     *
     * @param rollno
     * @return
     */
    public String branch(String rollno) {
        try {
            String b = rollno.substring(6, 8);
            String branch;
            branch = switch (b) {
                case "05" -> "CSE";
                case "01" -> "CIVIL";
                case "02" -> "EEE";
                case "03" -> "MECH";
                case "04" -> "ECE";
                case "42" -> "CSM";
                case "44" -> "CSD";
                case "47" -> "CIC";
                case "58" -> "CBA";
                default -> "branch";
            };
            if (!branch.equals("")) {
                return branch;
            }
        } catch (Exception e) {
        }
        return "NAN";
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Username = new javax.swing.JTextField();
        Password = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        ok = new javax.swing.JButton();
        cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(560, 240, 400, 300));
        setMinimumSize(new java.awt.Dimension(398, 296));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(50, 34, 116));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("UserName");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 92, -1, 35));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 145, 86, 35));

        Username.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsernameActionPerformed(evt);
            }
        });
        jPanel1.add(Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 92, 141, 35));

        Password.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordActionPerformed(evt);
            }
        });
        jPanel1.add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 145, 141, 35));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("LOGIN");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(142, 27, 101, 47));

        ok.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ok.setForeground(new java.awt.Color(50, 34, 116));
        ok.setText("OK");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });
        jPanel1.add(ok, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 87, 37));

        cancel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cancel.setForeground(new java.awt.Color(50, 34, 116));
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel1.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 90, 37));

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsernameActionPerformed
    Password.grabFocus();
    }//GEN-LAST:event_UsernameActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
    System.exit(0);
    }//GEN-LAST:event_cancelActionPerformed

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
      check();
    }//GEN-LAST:event_okActionPerformed

    private void PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordActionPerformed
     check();
    }//GEN-LAST:event_PasswordActionPerformed
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            Login f;
            try {
                f = new Login();
                f.setVisible(true);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,ex);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Password;
    private javax.swing.JTextField Username;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton ok;
    // End of variables declaration//GEN-END:variables
}
