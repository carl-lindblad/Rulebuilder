package GUI.ACTIONS.Actions_Audit;

import com.Action_XML_Builder;
import com.Services;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Action_Audit_Trail {
    private JFrame show = new JFrame("Aml report input");
    Action_XML_Builder build = new Action_XML_Builder();
    Map<String, String> parameters = new HashMap<>();
    String sub_action = "";

    private JPanel auditTrailPanel;
    private JRadioButton auditTrailRadioButton;
    private JRadioButton messageRadioButton;
    private JComboBox levelCombobox;
    private JComboBox categoryCombobox;
    private JTextArea messageText;
    private JButton createXMLButton;
    private Services start = new Services();


    public Action_Audit_Trail() {
        createXMLButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(auditTrailRadioButton.isSelected()){
                    sub_action = auditTrailRadioButton.getName();
                    parameters.put("category", Objects.requireNonNull(categoryCombobox.getSelectedItem()).toString());
                    parameters.put("level", Objects.requireNonNull(levelCombobox.getSelectedItem()).toString());
                    parameters.put("message", messageText.getText());
                }
                else {
                    sub_action = messageRadioButton.getName();
                    parameters.put("level", Objects.requireNonNull(levelCombobox.getSelectedItem()).toString());
                    parameters.put("text", messageText.getText());

                }


                build.Action_builders(parameters, "Log", sub_action, "", "");
                JOptionPane.showMessageDialog(auditTrailPanel, "XML successfully created");
            }
        });

        auditTrailRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (auditTrailRadioButton.isSelected()){
                    messageRadioButton.setSelected(false);
                    categoryCombobox.setVisible(true);
                }

            }
        });
        messageRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (messageRadioButton.isSelected()){
                    auditTrailRadioButton.setSelected(false);
                    categoryCombobox.setVisible(false);
                }

            }
        });
    }

    public void openActionTrail(){
        start.openFrame(show, auditTrailPanel);
    }


}
