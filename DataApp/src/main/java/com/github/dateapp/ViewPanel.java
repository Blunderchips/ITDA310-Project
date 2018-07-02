package com.github.dateapp;

import java.awt.Color;
import java.awt.LayoutManager;
import javax.swing.JPanel;

/**
 * View Panel. Created on 07 May 2018 9:02:17 PM by Matthew.
 *
 * @author Matthew Van der Bijl (xq9x3wv31)
 */
public abstract class ViewPanel extends JPanel {

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public ViewPanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
        this.init();
    }

    public ViewPanel(LayoutManager layout) {
        super(layout);
        this.init();
    }

    public ViewPanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
        this.init();
    }

    public ViewPanel() {
        super();
        this.init();
    }
    //</editor-fold>

    private void init() {
        super.setBackground(new Color(250, 250, 250));
    }

    public void dispose() {
    }
}
