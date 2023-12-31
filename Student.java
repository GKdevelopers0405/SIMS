
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
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
public class Student extends javax.swing.JFrame {

    /**
     * Creates new form Student
     */
    static Connection conn;

    public Student() throws SQLException {
        initComponents();
        ImageIcon icon = new ImageIcon("C:\\Program Files\\SIMS\\StudentWhite.png");
        setIconImage(icon.getImage());
        try {
            DataBaseConnection dbc=new DataBaseConnection();
            conn=dbc.getCon();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    

    /**
     *
     * @param regdno
     * @param branch
     */
    public void displaydetails(String regdno, String branch) {
        try {
            SetPhoto sp=new SetPhoto();
            String get = String.format("Select * from %s where regd=? ", branch);
            PreparedStatement st = conn.prepareStatement(get);
            st.setString(1, regdno);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                P_regdno.setText(rs.getString(2));
                P_name.setText(rs.getString(3));
                P_dateofbirth.setText(rs.getString(8));
                P_age.setText(rs.getString(9));
                P_gender.setText(rs.getString(14));
                P_phoneno.setText(rs.getString(11));
                P_email.setText(rs.getString(12));
                P_aadhar.setText(rs.getString(13));
                P_fname.setText(rs.getString(4));
                P_mname.setText(rs.getString(5));
                P_foccupation.setText(rs.getString(6));
                P_moccupation.setText(rs.getString(7));
                P_address.setText(rs.getString(10));
                P_branch.setText(rs.getString(15));
                P_category.setText(rs.getString(16));
                P_10marks.setText(rs.getString(17));
                P_intermarks.setText(rs.getString(18));
                P_caste.setText(rs.getString(19));
                P_subcaste.setText(rs.getString(20));
                String path = rs.getString("photo");
                P_photo.setIcon(sp.seticon(path, null,P_photo.getWidth(),P_photo.getHeight()));
                String query = "select * from attendance_" + branch + " where regd=? ";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, regdno);
                ResultSet rst = ps.executeQuery();
                if (rst.next()) {
                    attendance.setText(rst.getString("attendance") + "%");
                    int a = Integer.parseInt(rst.getString("attendance"));
                    if (a < 75) {
                        atten_error.setText("Please attend the college regularly");
                    } else {
                        atten_error.setText("");
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    /**
     *
     * @param b
     */
    public void printDetails(boolean b) {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("Print Data");
        job.setPrintable((Graphics pg, PageFormat pf, int pageNum) -> {
            pf.setOrientation(PageFormat.LANDSCAPE);
            if (pageNum > 0) {
                return Printable.NO_SUCH_PAGE;
            }
            Graphics2D g2 = (Graphics2D) pg;
            g2.translate(pf.getImageableX(), pf.getImageableY());
            g2.scale(0.47, 0.47);
            PrintPanel.print(g2);
            return Printable.PAGE_EXISTS;
        });
        boolean ok = job.printDialog();
        if (ok) {
            try {
                job.print();
                if(b){
                    dispose();
                }
            } catch (PrinterException ex) {
                JOptionPane.showMessageDialog(null, ex);
                dispose();
            }
        }else{
        if(b){
        dispose();
        }
        }
    }
public void remove(){
    jLabel1.setText("");
    attendance.setText("");
    atten_error.setText("");
    if(print!=null && logout !=null){
        Container containerP=print.getParent();
        Container containerL=logout.getParent();
        containerP.remove(print);
        containerL.remove(logout);
    }
    revalidate();
    repaint();
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        PrintPanel = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        P_name = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        P_regdno = new javax.swing.JLabel();
        P_dateofbirth = new javax.swing.JLabel();
        P_age = new javax.swing.JLabel();
        P_gender = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        P_photo = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        P_phoneno = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        P_email = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        P_fname = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel70 = new javax.swing.JLabel();
        P_mname = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        P_foccupation = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        P_moccupation = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        P_aadhar = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        P_branch = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        P_category = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        P_10marks = new javax.swing.JLabel();
        P_intermarks = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        P_caste = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        P_subcaste = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        P_address = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        print = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        attendance = new javax.swing.JLabel();
        atten_error = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Student Details");
        setBackground(new java.awt.Color(50, 34, 116));
        setBounds(new java.awt.Rectangle(40, 30, 0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        PrintPanel.setBackground(new java.awt.Color(255, 255, 255));
        PrintPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel27.setText("Name ");
        PrintPanel.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 231, 160, 40));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel30.setText("Gender");
        PrintPanel.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 463, 160, 40));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel31.setText("Age");
        PrintPanel.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 405, 160, 40));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel32.setText("Regd No ");
        PrintPanel.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 289, 160, 40));

        P_name.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        PrintPanel.add(P_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 231, 360, 40));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel34.setText("Date Of BIrth ");
        PrintPanel.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 347, 160, 40));

        P_regdno.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        PrintPanel.add(P_regdno, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 289, 200, 40));

        P_dateofbirth.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        PrintPanel.add(P_dateofbirth, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 347, 200, 40));

        P_age.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        PrintPanel.add(P_age, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 405, 200, 40));

        P_gender.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        PrintPanel.add(P_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 463, 200, 40));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel29.setText("Student Details");
        PrintPanel.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(367, 45, 340, 55));

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel40.setText("Personal Details");
        PrintPanel.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 158, 366, 39));

        P_photo.setToolTipText("");
        P_photo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PrintPanel.add(P_photo, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 245, 180, 200));

        jLabel56.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel56.setText("Phone No");
        PrintPanel.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 521, 160, 40));

        P_phoneno.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        PrintPanel.add(P_phoneno, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 521, 230, 40));

        jLabel63.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel63.setText("Email ID");
        PrintPanel.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(584, 579, 160, 40));

        P_email.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        PrintPanel.add(P_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 579, 330, 40));

        jLabel65.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel65.setText("Parents Information");
        PrintPanel.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 659, 366, 39));

        P_fname.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        PrintPanel.add(P_fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 732, 270, 40));

        jLabel67.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel67.setText("Father Name");
        PrintPanel.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 732, 160, 40));
        PrintPanel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 704, 930, 10));

        jLabel70.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel70.setText("Mother Name");
        PrintPanel.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 790, 160, 40));

        P_mname.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        PrintPanel.add(P_mname, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 790, 270, 40));

        jLabel72.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel72.setText("Occupatoin");
        PrintPanel.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 732, 130, 40));

        P_foccupation.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        PrintPanel.add(P_foccupation, new org.netbeans.lib.awtextra.AbsoluteConstraints(721, 732, 350, 40));

        jLabel74.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel74.setText("Occupation");
        PrintPanel.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 790, 130, 40));

        P_moccupation.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        PrintPanel.add(P_moccupation, new org.netbeans.lib.awtextra.AbsoluteConstraints(731, 790, 340, 40));

        jLabel76.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel76.setText("Aadhar");
        PrintPanel.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 579, 160, 40));

        P_aadhar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        PrintPanel.add(P_aadhar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 579, 230, 40));

        jLabel78.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel78.setText("Other  Details");
        PrintPanel.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 988, 366, 39));

        jLabel79.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel79.setText("Branch");
        PrintPanel.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 1061, 160, 40));

        P_branch.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        PrintPanel.add(P_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 1061, 230, 40));

        jLabel81.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel81.setText("Category");
        PrintPanel.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 1119, 160, 40));

        P_category.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        P_category.setText(" ");
        PrintPanel.add(P_category, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 1119, 230, 40));

        jLabel83.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel83.setText("10 Marks");
        PrintPanel.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 1177, 160, 40));

        P_10marks.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        PrintPanel.add(P_10marks, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 1177, 230, 40));

        P_intermarks.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        PrintPanel.add(P_intermarks, new org.netbeans.lib.awtextra.AbsoluteConstraints(751, 1177, 230, 40));

        jLabel86.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel86.setText("Inter Marks");
        PrintPanel.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 1177, 160, 40));

        jLabel87.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel87.setText("Caste");
        PrintPanel.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 1235, 160, 40));

        P_caste.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        PrintPanel.add(P_caste, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 1235, 230, 40));

        jLabel89.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel89.setText("Sub Caste");
        PrintPanel.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 1235, 160, 40));

        P_subcaste.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        PrintPanel.add(P_subcaste, new org.netbeans.lib.awtextra.AbsoluteConstraints(751, 1235, 230, 40));

        jLabel91.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel91.setText("Address");
        PrintPanel.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 848, 160, 40));

        P_address.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        P_address.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        P_address.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        P_address.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        PrintPanel.add(P_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 848, 681, 100));
        PrintPanel.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 1033, 930, 10));

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        PrintPanel.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 203, 930, 10));

        jScrollPane1.setViewportView(PrintPanel);

        print.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        print.setText("Print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        logout.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        logout.setText("LOG OUT");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Attendance");

        attendance.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        atten_error.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        atten_error.setForeground(new java.awt.Color(204, 0, 0));
        atten_error.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logout)
                    .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(attendance, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(atten_error, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(134, 134, 134)
                        .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(attendance, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(atten_error, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        try {
            int result = JOptionPane.showConfirmDialog(null, "Are you sure , you want to logout...", "log out", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                dispose();
                Login login = new Login();
                login.setVisible(true);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_logoutActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        printDetails(false);
    }//GEN-LAST:event_printActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
                 int result = JOptionPane.showConfirmDialog(Student.this, "Do you want to exit", "Closing", JOptionPane.YES_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
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
                java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>
            //</editor-fold>
            //</editor-fold>
            //</editor-fold>

            /* Create and display the form */
            Student s = new Student();
            s.setVisible(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        //</editor-fold>
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel P_10marks;
    private javax.swing.JLabel P_aadhar;
    private javax.swing.JLabel P_address;
    private javax.swing.JLabel P_age;
    private javax.swing.JLabel P_branch;
    private javax.swing.JLabel P_caste;
    private javax.swing.JLabel P_category;
    private javax.swing.JLabel P_dateofbirth;
    private javax.swing.JLabel P_email;
    private javax.swing.JLabel P_fname;
    private javax.swing.JLabel P_foccupation;
    private javax.swing.JLabel P_gender;
    private javax.swing.JLabel P_intermarks;
    private javax.swing.JLabel P_mname;
    private javax.swing.JLabel P_moccupation;
    private javax.swing.JLabel P_name;
    private javax.swing.JLabel P_phoneno;
    private javax.swing.JLabel P_photo;
    private javax.swing.JLabel P_regdno;
    private javax.swing.JLabel P_subcaste;
    private javax.swing.JPanel PrintPanel;
    private javax.swing.JLabel atten_error;
    private javax.swing.JLabel attendance;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JButton logout;
    private javax.swing.JButton print;
    // End of variables declaration//GEN-END:variables
}
