package GUI.ACTIONS.Actions_KYC;

import com.Action_XML_Builder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Action_AML_Report {
    private JComboBox reportType;
    private JCheckBox addMessageCheckBox;
    private JComboBox levelCombobox;
    private JTextArea messageText;
    private JPanel messagePanel;
    private JButton createActionXMLButton;
    public JPanel amlReportPanel;
    private JFrame show = new JFrame("Aml report input");
    public void openAmlReport(String actionType, String sectionType){
        show.setContentPane(new Action_AML_Report(actionType, actionType, sectionType).amlReportPanel);
        show.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        show.pack();
        show.setVisible(true);
    }
    public Action_AML_Report(String ruleName, String actionType, String sectionType) {
        Action_XML_Builder build = new Action_XML_Builder();
        Map<String, String> parameters = new HashMap<>();


        addMessageCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (addMessageCheckBox.isSelected()){
                    messageText.setEnabled(true);
                    levelCombobox.setEnabled(true);
                }
                else{
                    messageText.setEnabled(false);
                    levelCombobox.setEnabled(false);
                }
            }
        });
        createActionXMLButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parameters.put("type", Objects.requireNonNull(reportType.getSelectedItem()).toString());
                String message = messageText.getText();
                String level = Objects.requireNonNull(levelCombobox.getSelectedItem()).toString();
                build.Action_builders(parameters, actionType, sectionType, message, level);
                show.dispose();

            }
        });
    }
}
