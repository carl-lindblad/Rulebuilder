package GUI.ACTIONS.Actions_KYC;

import com.Action_XML_Builder;
import com.Services;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Action_Customer_Information_input {
    Services use = new Services();
    public JPanel action_inputs;
    private JButton save;
    private JCheckBox countryOfBirth;
    private JCheckBox citizenshipCheckBox;
    private JCheckBox addressForNewBankCustomerCheckBox;
    private JCheckBox birthPlaceCheckBox;
    private JCheckBox emailCheckBox;
    private JCheckBox firstnameCheckBox;
    public JPanel parameters_input;
    private JComboBox countryOfbirthComboBox;
    private JCheckBox lastNameCheckBox;
    private JCheckBox mobilePhoneCheckBox;
    private JCheckBox sectoreCodeCheckBox;
    private JCheckBox sexCheckBox;
    private JCheckBox taxCodeCheckBox;
    private JCheckBox dateOfBrithCheckBox;
    private JCheckBox remoteCustomerCheckBox;
    private JCheckBox deceasedCheckBox;
    private JCheckBox companyCheckBox;
    private JPanel lastNamePanel;
    private JComboBox lastnameComboBox;
    private JComboBox mobilePhoneComboBox;
    private JComboBox sectorCodeComboBox;
    private JPanel mobilePhonePanel;
    private JComboBox birthCountry;
    private JPanel countryOfBirthPanel;
    private JComboBox AddressForNewBankCustomer;
    private JPanel AddressForNewBankCustomerPanel;
    private JComboBox birthPlaceCombobox;
    private JPanel birthPlacePanel;
    private JComboBox emailCombobox;
    private JPanel emailPanel;
    private JComboBox firstnameCombobox;
    private JPanel firstnamePanel;
    private JPanel sectorCodePanel;
    private JComboBox taxCodeCombobox;
    private JPanel taxCodePanel;
    private JComboBox DateOfBirthCombobox;
    private JPanel DateOfBirthPanel;
    private JComboBox remoteCustomerCombobox;
    private JPanel remoteCustomerPanel;
    private JComboBox DeceasedCombobox;
    private JPanel DeceasedPanel;
    private JComboBox companyCombobox;
    private JPanel companyPanel;
    private JComboBox citizenshipCombobox;
    private JPanel citizenshipPanel;
    private JCheckBox selectAllCheckBox;
    private JPanel sexPanel;
    private JComboBox sexCombobox;
    private JCheckBox addMessageCheckBox;
    private JComboBox levelCombobox;
    private JTextArea messageText;
    private JPanel messagePanel;
    private String actionType;
    JFrame show = new JFrame("Action input");
    private JTextArea JTextArea;



    public void openActionInput(String actionType, String sectionType, String ruleName) {
        show.setContentPane(new Action_Customer_Information_input(actionType, sectionType, ruleName).action_inputs);
        show.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        show.pack();
        show.setVisible(true);
    }

    public Action_Customer_Information_input( String actionType, String sectionType, String ruleName) {
        Action_XML_Builder build = new Action_XML_Builder();
        Map<String, String> parameters = new HashMap<>();
        final String[] levelMessage = {""};
        final String[] textMessage = {""};
        ActionListener listener = e -> {
            boolean isChecked = false;

            boolean hasChanged = false;
            if (actionType.equals("KYC")) {
                for (Object panel : getAllPanels()
                ) {
                    if (panel instanceof JPanel) {
                        Object checkBoxActivate = ((JPanel) panel).getComponent(0);
                        Object combobox = ((JPanel) panel).getComponent(1);

                        if (checkBoxActivate instanceof JCheckBox) {
                            isChecked = ((JCheckBox) checkBoxActivate).isSelected();
                            if (isChecked) {
                                hasChanged = true;
                            }

                        } else {
                            System.out.println("Unchecked activated");
                        }

                        if (combobox instanceof JComboBox && isChecked) {
                            String key = ((JComboBox) combobox).getName();
                            String value = ((JComboBox) combobox).getSelectedItem().toString();
                            parameters.put(key, value);
                            if (addMessageCheckBox.isSelected()){
                                 levelMessage[0] = Objects.requireNonNull(levelCombobox.getSelectedItem()).toString();
                                 textMessage[0] = messageText.getText();
                        }
                        } else {
                            System.out.println("error");
                        }
                    }
                }
                if (hasChanged) {
                    build.Action_builders(parameters, actionType, sectionType, levelMessage[0], textMessage[0]);
                    JOptionPane.showMessageDialog(action_inputs, "XML successfully created");


                } else {
                    JOptionPane.showMessageDialog(action_inputs, "You need to select at least one");
                }
            } else {
                JOptionPane.showMessageDialog(action_inputs, "Something went wrong please restart program");

            }
        };
        save.addActionListener(listener);
        selectAllCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                for (Object panel : getAllPanels()
                ) {
                    Object checkBox = ((JPanel) panel).getComponent(0);
                    if (checkBox instanceof JCheckBox) {
                        if (e.getStateChange() == 1) {
                            ((JCheckBox) checkBox).setSelected(true);
                        } else {

                            ((JCheckBox) checkBox).setSelected(false);
                        }
                    }
                }
            }
        });

        addMessageCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (addMessageCheckBox.isSelected()){
                    levelCombobox.setEnabled(true);
                    messageText.setEnabled(true);
                }
                else {
                    messageText.setEnabled(false);
                    levelCombobox.setEnabled(false);
                }
            }
        });
    }


    private ArrayList<Object> getAllPanels() {
        ArrayList<Object> panels = new ArrayList<>();
        panels.add(birthPlacePanel);
        panels.add(countryOfBirthPanel);
        panels.add(emailPanel);
        panels.add(companyPanel);
        panels.add(firstnamePanel);
        panels.add(lastNamePanel);
        panels.add(mobilePhonePanel);
        panels.add(remoteCustomerPanel);
        panels.add(sectorCodePanel);
        panels.add(taxCodePanel);
        panels.add(DateOfBirthPanel);
        panels.add(DeceasedPanel);
        panels.add(citizenshipPanel);
        panels.add(AddressForNewBankCustomerPanel);
        panels.add(sexPanel);
        return panels;

    }
}

