package com.github.dateapp;

import java.util.Objects;

/**
 * Message. Created on 20 Apr 2018 8:37:51 PM by Matthew.
 *
 * @author Matthew Van der Bijl (xq9x3wv31)
 */
public class Message {

    private final int msgID;
    private final String message;
    private final int from, to;

    public Message(int msgID, String message, int from, int to) {
        this.msgID = msgID;
        this.message = message;
        this.from = from;
        this.to = to;
    }

    public int getMsgID() {
        return msgID;
    }

    public String getMessage() {
        return message;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "Message{" + "msgID=" + msgID + ", message=" + message
                + ", from=" + from + ", to=" + to + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.msgID;
        hash = 67 * hash + Objects.hashCode(this.message);
        hash = 67 * hash + this.from;
        hash = 67 * hash + this.to;
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
        final Message other = (Message) obj;
        if (this.msgID != other.msgID) {
            return false;
        }
        if (this.from != other.from) {
            return false;
        }
        if (this.to != other.to) {
            return false;
        }
        if (!Objects.equals(this.message, other.message)) {
            return false;
        }
        return true;
    }
}
