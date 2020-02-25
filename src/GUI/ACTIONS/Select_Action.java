package GUI.ACTIONS;

import GUI.ACTIONS.Actions_Audit.Action_Audit_Trail;
import GUI.ACTIONS.Actions_KYC.Action_AML_Report;
import GUI.ACTIONS.Actions_KYC.Action_Customer_Information_input;
import com.Services;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Select_Action {
    public JPanel selectAction;
    private JComboBox actionTypeCombobox;
    private JButton NEXTButton;
    private JPanel inputs;
    private JComboBox sectionComboboxKYC;
    private JLabel subactionLabel;
    private String sectionType = "";

    private JFrame show = new JFrame("Startpage");
    private Services start = new Services();
    public void openSelectAction() {
        start.openFrame(show, selectAction);
    }

    public Select_Action(String ruleName) {
        NEXTButton.addActionListener(e -> {
            String actionType = Objects.requireNonNull(actionTypeCombobox.getSelectedItem()).toString();
            sectionType = Objects.requireNonNull(sectionComboboxKYC.getSelectedItem()).toString();
            if (actionType.equals("KYC")) {
                switch (sectionType) {
                    case "CustomerInfo":
                        Action_Customer_Information_input customer_information = new Action_Customer_Information_input(actionType, sectionType, ruleName);
                        customer_information.openActionInput(actionType, sectionType, ruleName);
                        break;
                    case "AML report":
                        Action_AML_Report AML_Report = new Action_AML_Report(actionType, sectionType, ruleName);
                        AML_Report.openAmlReport(actionType, sectionType);

                        break;
                }

            } else {
                Action_Audit_Trail auditTrail = new Action_Audit_Trail();
                auditTrail.openActionTrail();


            }


        });
        actionTypeCombobox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (actionTypeCombobox.getSelectedItem().toString().equals("KYC")) {
                    sectionComboboxKYC.setVisible(true);
                    subactionLabel.setVisible(true);
                }
                else {
                    sectionComboboxKYC.setVisible(false);
                    subactionLabel.setVisible(false);
                }

            }
        });
    }

}
