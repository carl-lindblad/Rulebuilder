package com;

import javax.swing.*;

public class Services {
    public void openFrame(JFrame frame, JPanel panel) {
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public boolean verifyIsInt(Character input) {
        try {
            Integer.parseInt(input.toString());
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

}


