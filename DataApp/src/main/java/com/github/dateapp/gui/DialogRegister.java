package com.github.dateapp.gui;

import com.github.dateapp.Database;
import com.github.dateapp.User;
import com.github.dateapp.Util;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

/**
 * Register Dialog. (26 Apr 2018 10:14:52 PM).
 *
 * @author Matthew Van der Bijl (xq9x3wv31)
 */
public final class DialogRegister extends JDialog {

    private User user;
    private JFrame parent;

    /**
     * Creates new form Dialog Registration frame.
     *
     * @param parent parent frame
     */
    public DialogRegister(JFrame parent) {
        super(parent, true);
        this.initComponents();

        this.user = new User();
        this.parent = parent;

        try {
            Statement stmt = Database.getStatement();
            ResultSet rs = stmt.executeQuery("SELECT genderName FROM Gender");
            while (rs.next()) {
                String gender = rs.getString(1);
//                this.cmbGenderManager.addItem(gender);
                this.cmbGenderUser.addItem(gender);
            }
            rs.close();
            stmt.close();
        } catch (SQLException sqle) {
            System.err.println(sqle);
        } finally {
//            this.cmbGenderManager.setSelectedIndex(0);
            this.cmbGenderUser.setSelectedIndex(0);
        }

        super.setTitle("Register for DateApp!");
        super.setLocationRelativeTo(parent);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * <strong>WARNING: Do NOT modify this code.<strong> The content of this
     * method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtUsernameUser = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtFirstNameUser = new javax.swing.JTextField();
        txtLastNameUser = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtPhoneNumberUser = new javax.swing.JTextField();
        cmbGenderUser = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        btnSelectPictureUser = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        btnSubmitUser = new javax.swing.JButton();
        btnResetUser = new javax.swing.JButton();
        btnCloseUser = new javax.swing.JButton();
        btnViewPictureUser = new javax.swing.JButton();
        txtPasswordUserA = new javax.swing.JPasswordField();
        txtPasswordUserB = new javax.swing.JPasswordField();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));

        jLabel8.setText("Username");

        jLabel9.setText("First Name");

        jLabel10.setText("Last Name");

        jLabel11.setText("Phone Number");

        jLabel12.setText("Gender");

        btnSelectPictureUser.setBackground(new java.awt.Color(102, 102, 255));
        btnSelectPictureUser.setText("Select Picture");
        btnSelectPictureUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectPictureUserActionPerformed(evt);
            }
        });

        jLabel14.setText("Picture");

        btnSubmitUser.setBackground(new java.awt.Color(102, 102, 255));
        btnSubmitUser.setText("Submit");
        btnSubmitUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitUserActionPerformed(evt);
            }
        });

        btnResetUser.setBackground(new java.awt.Color(102, 102, 255));
        btnResetUser.setText("Reset");
        btnResetUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetUserActionPerformed(evt);
            }
        });

        btnCloseUser.setBackground(new java.awt.Color(102, 102, 255));
        btnCloseUser.setText("Close");
        btnCloseUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseUserActionPerformed(evt);
            }
        });

        btnViewPictureUser.setBackground(new java.awt.Color(102, 102, 255));
        btnViewPictureUser.setText("View Picture");
        btnViewPictureUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewPictureUserActionPerformed(evt);
            }
        });

        jLabel15.setText("Password");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel12))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPhoneNumberUser)
                                    .addComponent(cmbGenderUser, 0, 194, Short.MAX_VALUE)
                                    .addComponent(txtLastNameUser)
                                    .addComponent(txtFirstNameUser)
                                    .addComponent(txtUsernameUser)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(txtPasswordUserA, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPasswordUserB, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSelectPictureUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnViewPictureUser)
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSubmitUser)
                        .addGap(18, 18, 18)
                        .addComponent(btnResetUser)
                        .addGap(18, 18, 18)
                        .addComponent(btnCloseUser)
                        .addGap(12, 12, 12)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUsernameUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFirstNameUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLastNameUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhoneNumberUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbGenderUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelectPictureUser)
                    .addComponent(btnViewPictureUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPasswordUserA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPasswordUserB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCloseUser)
                    .addComponent(btnResetUser)
                    .addComponent(btnSubmitUser))
                .addGap(69, 69, 69))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitUserActionPerformed
        if (!txtPasswordUserA.getText().equals(txtPasswordUserB.getText())) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "Passwords do not match.");
            return;
        }

        try {
            Util.str(txtPasswordUserA);
            this.user.setFirstName(Util.str(txtFirstNameUser.getText()));
            this.user.setGender(cmbGenderUser.getSelectedItem().toString());
            this.user.setLastName(Util.str(txtLastNameUser.getText()));
            this.user.setPhoneNumber(Util.phoneNumber(txtPhoneNumberUser.getText()));
            this.user.setUserName(Util.str(txtUsernameUser.getText()));
            this.user.setPasswsd(Util.str(txtPasswordUserA.getText()));

            this.user.insert(parent);
            super.dispose();
        } catch (Exception ex) {
            Util.err(ex, parent);
        }
    }//GEN-LAST:event_btnSubmitUserActionPerformed

    private void btnResetUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetUserActionPerformed
        this.txtFirstNameUser.setText("");
        this.txtLastNameUser.setText("");
        this.txtPhoneNumberUser.setText("");
        this.txtUsernameUser.setText("");
        this.txtPasswordUserA.setText("");
        this.txtPasswordUserB.setText("");
    }//GEN-LAST:event_btnResetUserActionPerformed

    private void btnCloseUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseUserActionPerformed
        super.dispose();
    }//GEN-LAST:event_btnCloseUserActionPerformed

    private void btnViewPictureUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewPictureUserActionPerformed
        try {
//            System.out.println(parent);
            new DialogViewImage(user, parent).dispose();
        } catch (NullPointerException npe) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "No image set.");
        }
    }//GEN-LAST:event_btnViewPictureUserActionPerformed

    private void btnSelectPictureUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectPictureUserActionPerformed
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = jfc.showOpenDialog(parent);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                System.out.println(jfc.getSelectedFile());
                this.user.setProfilePic(ImageIO.read(jfc.getSelectedFile()));
            } catch (Exception ioe) {
                Util.err(ioe, parent);
            }
        }
    }//GEN-LAST:event_btnSelectPictureUserActionPerformed

    //<editor-fold defaultstate="collapsed" desc="Generated Varibles">  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCloseUser;
    private javax.swing.JButton btnResetUser;
    private javax.swing.JButton btnSelectPictureUser;
    private javax.swing.JButton btnSubmitUser;
    private javax.swing.JButton btnViewPictureUser;
    private javax.swing.JComboBox<String> cmbGenderUser;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtFirstNameUser;
    private javax.swing.JTextField txtLastNameUser;
    private javax.swing.JPasswordField txtPasswordUserA;
    private javax.swing.JPasswordField txtPasswordUserB;
    private javax.swing.JTextField txtPhoneNumberUser;
    private javax.swing.JTextField txtUsernameUser;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
}