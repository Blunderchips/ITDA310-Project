package com.github.dateapp.gui.pnl;

import com.github.dateapp.Database;
import com.github.dateapp.User;
import com.github.dateapp.Util;
import com.github.dateapp.gui.DialogViewUser;
import com.github.dateapp.gui.FrameMain;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import static java.util.concurrent.TimeUnit.SECONDS;
import javax.swing.JOptionPane;
import com.github.dateapp.ViewPanel;

/**
 * View message panel.
 *
 * @author Matthew Van der Bijl (xq9x3wv31)
 */
public class PnlMessages extends ViewPanel implements Runnable {

    private final User user;
    private final FrameMain parent;

    private final ScheduledFuture ticker;

    /**
     * Creates new form PnlMessages.
     *
     * @param parent parent main frame
     * @param user
     */
    @SuppressWarnings("LeakingThisInConstructor")
    public PnlMessages(FrameMain parent, User user) {
        this.initComponents();

        this.user = user;
        this.parent = parent;
        this.txtName.setText(user.getName());

        this.ticker = Executors.newScheduledThreadPool(1)
                .scheduleAtFixedRate(this, 0, 1, SECONDS); // LeakingThisInConstructor
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * <strong>WARNING: Do NOT modify this code.</strong> The content of this
     * method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtOutput = new javax.swing.JTextArea();
        txtInput = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        btnViewUser = new javax.swing.JButton();

        setBackground(new java.awt.Color(250, 250, 250));

        txtOutput.setEditable(false);
        txtOutput.setColumns(20);
        txtOutput.setRows(5);
        jScrollPane1.setViewportView(txtOutput);

        btnSubmit.setBackground(new java.awt.Color(102, 102, 255));
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        txtName.setEditable(false);
        txtName.setText("NAME");

        btnViewUser.setBackground(new java.awt.Color(102, 102, 255));
        btnViewUser.setText("View User");
        btnViewUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnViewUser)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnViewUser)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtName)
                        .addGap(2, 2, 2)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        if (txtInput.getText().trim().isEmpty()) {
            System.err.println("Empty message");
            return;
        }
        sendMessage();
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnViewUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewUserActionPerformed
        new DialogViewUser(parent, user).setVisible(true);
    }//GEN-LAST:event_btnViewUserActionPerformed

    private void sendMessage() {
        String msg = txtInput.getText().trim();

        String q = String.format("INSERT INTO `dateing_database`.`message`\n"
                + "(`message`, `userFrom`, `userTo`) VALUES ('%s', %s, %s);",
                msg, parent.getUser().getID(), user.getID());

        System.out.println(q);

        try {
            Statement stmt = Database.getStatement();

            if (!stmt.execute(q)) {
//                JOptionPane.showMessageDialog(parent, "Saved Sucessully", "Saved",
//                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(parent, "Failed to send message", "Failed",
                        JOptionPane.ERROR_MESSAGE);
            }
            stmt.close();
        } catch (SQLException sqle) {
            Util.err(sqle, parent);
        }

        // -- 
        this.txtOutput.append(msg + "\n");
        this.txtInput.setText("");
    }

    private String getUsersName(int userID) {
        if (user.getID() == userID) {
            return user.getName();
        } else {
            return parent.getUser().getName();
        }
    }

    private void loadMessages() {
        try {
            this.txtOutput.setText("");

            Statement stmt = Database.getStatement();
            ResultSet rs = stmt.executeQuery(String.format("SELECT `userTo`, `message`, `sent` FROM "
                    + "message WHERE (userTo = %d AND userFrom = %d) OR "
                    + "(userTo = %d AND userFrom = %d)",
                    user.getID(), parent.getUser().getID(),
                    parent.getUser().getID(), user.getID()));
            while (rs.next()) {
                String ln = String.format("%s %s - %s\n", rs.getString(3),
                        getUsersName(rs.getInt(1)), rs.getString(2));
                System.out.println(ln);
                this.txtOutput.append(ln);
            }
            rs.close();
            stmt.close();
        } catch (SQLException sqle) {
            Util.err(sqle, parent);
        }
    }

    @Override
    public void run() {
        loadMessages();
    }

    @Override
    public void dispose() {
        this.ticker.cancel(false);
    }

    //<editor-fold defaultstate="collapsed" desc="Generated Varibles">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnViewUser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtInput;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextArea txtOutput;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
}