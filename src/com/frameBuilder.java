package com;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class frameBuilder extends JFrame {
    // java Program to create a JPanel with a Box layout and add components to it .

    // JFrame
    private JFrame frame;

    private JPanel panel;

    JTextField textField;

    JRadioButton radioButton;

    JPanel[] panels;

    // JButton
    JButton b, b1, b2, b3;

    // label to display text
    JLabel l;

    // main class
    public void createFrame(String title, ArrayList<JPanel> panels) {
        // create a new frame to store text field and button
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        for (JPanel latestPanel : panels
        ) {
            frame.add(latestPanel);
            frame.revalidate();
        }
        frame.pack();
        frame.setVisible(true);
    }

    public JPanel createPanel(String title, JComponent[] components) {
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.white);
        for (JComponent component : components) {
            panel.add(component);
        }
        return panel;
    }
}
