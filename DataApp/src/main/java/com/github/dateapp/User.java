package com.github.dateapp;

import java.awt.Component;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import sun.misc.BASE64Decoder;

/**
 * Single person. Created on 20 Apr 2018 8:37:58 PM by Matthew.
 *
 * @author Matthew Van der Bijl
 */
public class User {

    private int userID;
    private String userName, firstName, lastName, phoneNumber, profilePic, passwsd;
    private String gender;

    public User() {
    }

    public User(ResultSet rs) throws SQLException {
        this.userID = rs.getInt("userID");
        this.userName = rs.getString("userName");
        this.firstName = rs.getString("firstName");
        this.lastName = rs.getString("lastName");
        this.phoneNumber = rs.getString("phoneNumber");
        this.profilePic = rs.getString("profilePic");
        this.gender = rs.getString("gender");
        this.passwsd = rs.getString("gender");
    }

    public User(int userID, String userName, String firstName, String lastName,
            String phoneNumber, String profilePic, String passwsd, String gender) {
        this.userID = userID;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.profilePic = profilePic;
        this.passwsd = passwsd;
        this.gender = null;
    }

    public int getID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPasswsd() {
        return passwsd;
    }

    public void setPasswsd(String passwsd) {
        this.passwsd = passwsd;
    }

    public BufferedImage getProfilePic() {
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] imageByte = decoder.decodeBuffer(profilePic);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            BufferedImage img = ImageIO.read(bis);
            bis.close();

            return img;
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    public void setProfilePic(BufferedImage profilePic) {
        this.profilePic = Util.encodeToString(profilePic, "PNG");
    }

    public Gender getGender() {
        return null;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

//    @Override
//    public String toString() {
//        return "User{" + "userID=" + userID + ", userName=" + userName
//                + ", firstName=" + firstName + ", lastName=" + lastName
//                + ", phoneNumber=" + phoneNumber /*+ ", profilePic=" + profilePic*/
//                + ", gender=" + gender + '}';
//    }
    @Override
    public String toString() {
        return String.format("%s %s", getClass().getSimpleName(), getName());
    }

    public void update(Component parent) {
        String q = String.format("UPDATE `dateing_database`.`singleperson`\n"
                + "SET\n"
                + "`userName` = '%s',\n"
                + "`passwd` = '%s',\n"
                + "`firstName` = '%s',\n"
                + "`lastName` = '%s',\n"
                + "`phoneNumber` = '%s',\n"
                + "`profilePic` = '%s',\n"
                + "`gender` = '%s'\n"
                + "WHERE `userID` = %d;",
                userName, passwsd, firstName, lastName, phoneNumber, profilePic, gender, userID);

        System.out.println(q);

        try {
            Statement stmt = Database.getStatement();

            Toolkit.getDefaultToolkit().beep();
            if (!stmt.execute(q)) {
                JOptionPane.showMessageDialog(parent, "Saved Sucessully", "Saved",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(parent, "Failed to Saved Sucessully", "Failed",
                        JOptionPane.ERROR_MESSAGE);
            }

            stmt.close();
        } catch (SQLException sqle) {
            Util.err(sqle, parent);
        }
    }

    public void insert(Component parent) {
        String q = String.format("INSERT INTO `dateing_database`.`singleperson`(\n"
                + "`userName`,`passwd`,`firstName`,`lastName`,`phoneNumber`,"
                + "`profilePic`,`gender`)VALUES ('%s','%s','%s','%s','%s','%s','%s');",
                getUserName(), getPasswsd(), getFirstName(), getLastName(), getPhoneNumber(),
                profilePic, gender);

        System.out.println(q);

        try {
            Statement stmt = Database.getStatement();

            if (!stmt.execute(q)) {
                JOptionPane.showMessageDialog(parent, "Insert Sucessul", "Inserted",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(parent, "Failed to Insert Sucessully", "Failed",
                        JOptionPane.ERROR_MESSAGE);
            }

            stmt.close();
        } catch (SQLException sqle) {
            Util.err(sqle, parent);
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.userID;
        hash = 59 * hash + Objects.hashCode(this.userName);
        hash = 59 * hash + Objects.hashCode(this.firstName);
        hash = 59 * hash + Objects.hashCode(this.lastName);
        hash = 59 * hash + Objects.hashCode(this.phoneNumber);
        hash = 59 * hash + Objects.hashCode(this.profilePic);
        hash = 59 * hash + Objects.hashCode(this.passwsd);
        hash = 59 * hash + Objects.hashCode(this.gender);
        return hash;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null
                || getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        return !(this.userID != other.userID
                || !Objects.equals(this.userName, other.userName)
                || !Objects.equals(this.firstName, other.firstName)
                || !Objects.equals(this.lastName, other.lastName)
                || !Objects.equals(this.phoneNumber, other.phoneNumber)
                || !Objects.equals(this.profilePic, other.profilePic)
                || !Objects.equals(this.passwsd, other.passwsd)
                || !Objects.equals(this.gender, other.gender));
    }

    public String getName() {
        return String.format("%s %s", firstName, lastName);
    }

    public List<Hobby> getHobbies(Component parent) {
        List<Hobby> hobbies = new ArrayList<>();

        try {
            Statement stmt = Database.getStatement();

            String q = String.format("SELECT hobbyID FROM person_hobby WHERE userID = %d", userID);
            System.out.println(q);

            List<Integer> keys = new ArrayList<>();
            ResultSet rs = stmt.executeQuery(q);
            while (rs.next()) {
                keys.add(rs.getInt("hobbyID"));
            }
            rs.close();

            for (Integer key : keys) {
                q = String.format("SELECT * FROM hobby WHERE hobbyID = %d", key);
                System.out.println(q);

                rs = stmt.executeQuery(q);
                while (rs.next()) {
                    hobbies.add(new Hobby(rs));
                }

                rs.close();
            }

            stmt.close();
        } catch (SQLException sqle) {
            Util.err(sqle, parent);
        }

        return hobbies;
    }
}
