package com.github.dateapp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 * Hobby. Created on 26 Apr 2018 5:19:02 PM by Matthew.
 *
 * @author Matthew Van der Bijl (xq9x3wv31)
 */
public class Hobby {

    private int ID;
    private String name, description;

    public Hobby(ResultSet rs) throws SQLException {
        this.ID = rs.getInt("hobbyID");
        this.name = rs.getString("hobbyName");
        this.description = rs.getString("hobbyDescription");
    }

    public Hobby(int ID, String name, String description) {
        this.ID = ID;
        this.name = name;
        this.description = description;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Hobby{" + "ID=" + ID + ", name=" + name
                + ", description=" + description + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.ID;
        hash = 47 * hash + Objects.hashCode(this.name);
        hash = 47 * hash + Objects.hashCode(this.description);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Hobby other = (Hobby) obj;
        if (this.ID != other.ID) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }
}
