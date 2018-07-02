package com.github.dateapp;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import sun.misc.BASE64Encoder;

/**
 * Utilities. For all those aweful hacks. Created on 26 Apr 2018 8:30:51 PM by
 * Matthew.
 *
 * @author Matthew Van der Bijl (xq9x3wv31)
 */
public class Util {

    public static BufferedImage resize(BufferedImage img, int width, int height) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage rtn = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = rtn.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return rtn;
    }

    public static String encodeToString(BufferedImage image, String type)
            throws RuntimeException {
        String imgStr = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            ImageIO.write(image, type, bos);
            byte[] imageBytes = bos.toByteArray();

            BASE64Encoder encoder = new BASE64Encoder();
            imgStr = encoder.encode(imageBytes);

            bos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace(System.err);
            throw new RuntimeException(ioe);
        }
        return imgStr;
    }

    public static void err(Throwable t, Component parent) {
        Toolkit.getDefaultToolkit().beep();
        t.printStackTrace(System.err);
        JOptionPane.showMessageDialog(parent, "Please enter valid data",
                "Invalid input", JOptionPane.ERROR_MESSAGE);
    }

    public static String str(String str) throws Exception {
        if (str == null) {
            throw new RuntimeException("Null String");
        }
        String tmp = str.trim();
        if (tmp.isEmpty()) {
            throw new RuntimeException("empty string");
        }
        return str;
    }

    public static String str(JTextField txt) throws Exception {
        return Util.str(txt.getText());
    }

    // siD TODO: remove?
    @Deprecated
    public static boolean isNumber(String num) {
        try {
            Integer.parseInt(num);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public static String phoneNumber(String str) throws Exception {
        str = Util.str(str);
        if (str.length() != 10) {
            throw new IllegalArgumentException("Wrong length");
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("Phone number should only be numbers");
            }
        }
        return str;
    }

    @Deprecated
    private Util() {
    }
}
