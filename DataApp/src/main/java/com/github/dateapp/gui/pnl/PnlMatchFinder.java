package com.github.dateapp.gui.pnl;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ImageIcon;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.github.dateapp.Database;
import com.github.dateapp.Hobby;
import com.github.dateapp.User;
import com.github.dateapp.Util;
import com.github.dateapp.ViewPanel;
import com.github.dateapp.gui.FrameMain;

/**
 * Match finder panel.
 *
 * @author Matthew Van der Bijl
 */
public final class PnlMatchFinder extends ViewPanel {

    private User current;
    private final FrameMain parent;

    /**
     * Creates new form PnlMatchFinder.
     *
     * @param parent parent main frame
     */
    public PnlMatchFinder(FrameMain parent) {
        this.initComponents();
        this.pnlButtons.setLayout(new GridLayout(1, 0));
        this.pnlData.setLayout(new GridLayout(1, 0));
        this.pnlDetails.setLayout(new GridLayout(1, 0));
        this.parent = parent;

        next();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * <strong>WARNING: Do NOT modify this code.</strong> The content of this
     * method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        pnlButtons = new javax.swing.JPanel();
        btnNo = new javax.swing.JButton();
        btnYes = new javax.swing.JButton();
        pnlData = new javax.swing.JPanel();
        lblPicture = new javax.swing.JLabel();
        pnlDetails = new javax.swing.JPanel();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(250, 250, 250));

        pnlButtons.setBackground(new java.awt.Color(250, 250, 250));

        btnNo.setBackground(new java.awt.Color(102, 102, 255));
        btnNo.setText("No");
        btnNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoActionPerformed(evt);
            }
        });

        btnYes.setBackground(new java.awt.Color(102, 102, 255));
        btnYes.setText("Yes");
        btnYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlButtonsLayout = new javax.swing.GroupLayout(pnlButtons);
        pnlButtons.setLayout(pnlButtonsLayout);
        pnlButtonsLayout.setHorizontalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNo, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnYes, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlButtonsLayout.setVerticalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlButtonsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnYes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlData.setBackground(new java.awt.Color(250, 250, 250));
        pnlData.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblPicture.setText("jLabel1");

        pnlDetails.setBackground(new java.awt.Color(250, 250, 250));

        javax.swing.GroupLayout pnlDetailsLayout = new javax.swing.GroupLayout(pnlDetails);
        pnlDetails.setLayout(pnlDetailsLayout);
        pnlDetailsLayout.setHorizontalGroup(
            pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        pnlDetailsLayout.setVerticalGroup(
            pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlDataLayout = new javax.swing.GroupLayout(pnlData);
        pnlData.setLayout(pnlDataLayout);
        pnlDataLayout.setHorizontalGroup(
            pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlDataLayout.setVerticalGroup(
            pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDataLayout.createSequentialGroup()
                        .addComponent(pnlDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblPicture, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoActionPerformed
        next();
    }//GEN-LAST:event_btnNoActionPerformed

    private void btnYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYesActionPerformed
        match();
        next();
    }//GEN-LAST:event_btnYesActionPerformed

    private void next() {
        try {
            Statement stmt = Database.getStatement();

            String q = String.format("SELECT * FROM SinglePerson", "");
            System.out.println(q);

            List<User> users = new ArrayList<>();
            ResultSet rs = stmt.executeQuery(q);
            while (rs.next()) {
                User user = new User(rs);
                for (Hobby hobby : user.getHobbies(parent)) {
                    if (parent.getUser().getHobbies(parent).contains(hobby)) {
                        users.add(user);
                        break;
                    }
                }
            }
            rs.close();
            stmt.close();

            if (users.isEmpty()) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(parent, "No matches found.");
                JOptionPane.showMessageDialog(parent, "Please find some new hobbies.");
                this.lblPicture.setText("No matches found.");
                this.btnNo.setEnabled(false);
                this.btnYes.setEnabled(false);
                //this.parent.changePannel(new PnlEditInformation(parent));

            } else {
                do {
                    Collections.shuffle(users);
                    this.current = users.get(0);
                } while (isMatched());

                // JOptionPane.showMessageDialog(parent, current.toString());
                this.addDetails(new PnlViewUser(parent, current));
                this.lblPicture.setIcon(new ImageIcon(Util.resize(current.getProfilePic(), 300, 340)));
                this.lblPicture.setText("");
            }
        } catch (SQLException sqle) {
            Util.err(sqle, parent);
        }
    }

    private void match() {
        Toolkit.getDefaultToolkit().beep();

        String q = String.format("call match_users(%d, %d)",
                parent.getUser().getID(), current.getID());

        System.out.println(q);

        try {
            Statement stmt = Database.getStatement();

            if (!stmt.execute(q)) {
//                JOptionPane.showMessageDialog(parent, "Insert Sucessul", "Inserted",
//                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(parent, "Failed", "Failed",
                        JOptionPane.ERROR_MESSAGE);
            }

            stmt.close();
        } catch (SQLException sqle) {
            Util.err(sqle, parent);
        }
    }

    private boolean isMatched() {
        if (parent.getUser().getID() == current.getID()) {
            return true;
        }

        boolean rtn = false;
        try {
            Statement stmt = Database.getStatement();

            String q = String.format("SELECT COUNT(*) FROM Compatible WHERE userA = %d "
                    + "AND userB = %d", parent.getUser().getID(), current.getID());

            System.out.println(q);
            ResultSet rs = stmt.executeQuery(q);
            rs.next();

            rtn = rs.getInt(1) == 1;
            rs.close();
            stmt.close();
        } catch (SQLException sqle) {
            Util.err(sqle, parent);
        }
        return rtn;
    }

    public void addDetails(JPanel pnl) {
        System.out.println(pnl.getClass().getSimpleName());

        this.pnlDetails.removeAll();
        this.pnlDetails.add(pnl);
        this.pnlDetails.revalidate();
        this.pnlDetails.repaint();
    }

    //<editor-fold defaultstate="collapsed" desc="Generated Varibles">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNo;
    private javax.swing.JButton btnYes;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel lblPicture;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JPanel pnlData;
    private javax.swing.JPanel pnlDetails;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
}