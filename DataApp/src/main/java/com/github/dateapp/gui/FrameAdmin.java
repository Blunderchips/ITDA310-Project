package com.github.dateapp.gui;

import com.github.dateapp.Database;
import com.github.dateapp.User;
import com.github.dateapp.Util;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Admin Frame. Created by Matthew at 08 May 2018 1:33:26 PM.
 *
 * @author Matthew Van der Bijl
 */
public final class FrameAdmin extends JFrame {

    private final String passwd;
    private final Connection cnctn;

    /**
     * Creates new Admin Frame.
     *
     * @param parent parent frame
     * @param password admin password
     *
     * @throws java.sql.SQLException Can't connect to database
     * @throws java.lang.ClassNotFoundException Can't connect to database
     */
    public FrameAdmin(Component parent, String password) throws IllegalArgumentException,
            SQLException, ClassNotFoundException {
        super("~ Admin Frame ~");
        this.initComponents();

        this.passwd = password;

        Class.forName("com.mysql.cj.jdbc.Driver");
        this.cnctn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/dateing_database", "root", password);

        this.pnlOutput.setLayout(new GridLayout(0, 3));
        getUsers().forEach((id) -> {
            User user = getUser(id);
            String name = user.getName();

            JButton view = new JButton("View " + name);
            view.addActionListener((ActionEvent evt) -> {
                new DialogViewUser(FrameAdmin.this, user).setVisible(true);
            });
            JButton delete = new JButton("Delete " + name);
            delete.addActionListener((ActionEvent evt) -> {
                delete(id);
            });

            JLabel img = new JLabel(new ImageIcon(Util.resize(user.getProfilePic(), 128, 128)));
            img.setToolTipText(name);
//
            this.pnlOutput.add(img);
            this.pnlOutput.add(view);
            this.pnlOutput.add(delete);
        });

        super.pack();
        super.setLocationRelativeTo(parent);
    }

    private List<Integer> getUsers() {
        ArrayList<Integer> rtn = new ArrayList<>();
        try {
            Statement stmt = getStatement();

            String q = String.format("SELECT * FROM SinglePerson");
            System.out.println(q);

            ResultSet rs = stmt.executeQuery(q);
            while (rs.next()) {
                rtn.add(rs.getInt("userID"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }
        return rtn;
    }

    private User getUser(int userID) {
        User rtn = null;
        try {
            Statement stmt = getStatement();

            String q = String.format("SELECT * FROM SinglePerson WHERE userID = %d", userID);
            System.out.println(q);

            ResultSet rs = stmt.executeQuery(q);
            rs.next();

            rtn = new User(rs);

            rs.close();
            stmt.close();
        } catch (SQLException sqle) {
            System.err.println(sqle);
        }

        return rtn;
    }

    private void delete(int userID) {
        try {
            String q = String.format("DELETE FROM `dateing_database`.`singleperson` "
                    + "WHERE userID = %d", userID);

            System.out.println(q);

            Statement stmt = Database.getStatement();

            Toolkit.getDefaultToolkit().beep();
            if (!stmt.execute(q)) {
                JOptionPane.showMessageDialog(this, "Delete Sucessul", "Added",
                        JOptionPane.INFORMATION_MESSAGE);
                super.dispose();
                new FrameAdmin(this, passwd).setVisible(true);
            } else {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(this, "Failed to Delete Sucessully", "Failed",
                        JOptionPane.ERROR_MESSAGE);
                this.dispose();
            }
        } catch (HeadlessException | ClassNotFoundException
                | IllegalArgumentException | SQLException ex) {
            Util.err(ex, this);
        }
    }

    private Statement getStatement() throws SQLException {
        return this.cnctn.createStatement();
    }

    @Override
    public void dispose() {
        try {
            this.cnctn.close();
        } catch (SQLException ignore) {
        }
        new FrameLogin(this).setVisible(true);
        super.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * <strong>WARNING: Do NOT modify this code.</strong> The content of this
     * method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlOutput = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuItemClose = new javax.swing.JMenuItem();
        menuItemExit = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlOutput.setBackground(new java.awt.Color(250, 250, 250));

        javax.swing.GroupLayout pnlOutputLayout = new javax.swing.GroupLayout(pnlOutput);
        pnlOutput.setLayout(pnlOutputLayout);
        pnlOutputLayout.setHorizontalGroup(
            pnlOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 407, Short.MAX_VALUE)
        );
        pnlOutputLayout.setVerticalGroup(
            pnlOutputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(pnlOutput);

        jMenu1.setText("File");

        menuItemClose.setText("Close");
        menuItemClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCloseActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemClose);

        menuItemExit.setText("Exit");
        menuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemExitActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemExit);

        menuBar.add(jMenu1);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemExitActionPerformed
        super.dispose();
    }//GEN-LAST:event_menuItemExitActionPerformed

    private void menuItemCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCloseActionPerformed
        new FrameLogin(this).setVisible(true);
        super.dispose();
    }//GEN-LAST:event_menuItemCloseActionPerformed

    //<editor-fold defaultstate="collapsed" desc="Generated Varibles">  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuItemClose;
    private javax.swing.JMenuItem menuItemExit;
    private javax.swing.JPanel pnlOutput;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
}
