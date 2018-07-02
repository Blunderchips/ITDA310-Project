package com.github.dateapp;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Database Manager. Created on 26 Apr 2018 5:21:54 PM by Matthew.
 *
 * @author Matthew Van der Bijl (xq9xwv31)
 */
// https://www.javatpoint.com/example-to-connect-to-the-mysql-database
public final class Database {

    /**
     * Connection to database.
     */
    private static Connection CNCTN;

    /**
     * Creates database connection.
     */
    public static void init() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            CNCTN = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/dateing_database", "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            Toolkit.getDefaultToolkit().beep();
            ex.printStackTrace(System.err);
            JOptionPane.showMessageDialog(null, "Could not connect to database",
                    "Could not connect", JOptionPane.ERROR_MESSAGE);
            System.exit(42);
        }
    }

    public static Statement getStatement() throws SQLException {
        return Database.CNCTN.createStatement();
    }

    /**
     * Closes database connection.
     */
    public static void dispose() {
        try {
            Database.CNCTN.close();
        } catch (SQLException sqle) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, sqle);
        }
    }

    @Deprecated
    private Database() {
    }
}
