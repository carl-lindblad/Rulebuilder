package GUI.CONDITIONS;

import com.Services;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Select_Condition {
    private JButton addAnotherConditionButton;
    private JComboBox conditionObjectCombobox;
    private JComboBox<String> variablesCombobox;
    private JComboBox<String> conditionBox;
    private JTextField numText;
    private JComboBox booleanComboBox;
    private JTextField StringText;
    private JButton createXMLButton;
    private JPanel SelectConditionPanel;
    private JPanel inputParameters5;
    private JPanel inputParameters1;
    private JButton addConditionButton;
    private JPanel conditionsPanel;
    private JTextArea conditions;
    private JPanel inputParameters2;
    private JPanel inputParameters3;
    private JPanel inputParameters4;
    private Services start = new Services();
    private JFrame show = new JFrame("Select condition");
    Services use = new Services();
    CustomVariables fetch = new CustomVariables();


    public void openSelectCondition() {
        start.openFrame(show, SelectConditionPanel);

    }

    public Select_Condition(String ruleName) {
        conditionObjectCombobox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println(e.getStateChange());
                if (e.getStateChange() == 1) {
                    String item = Objects.requireNonNull(conditionObjectCombobox.getSelectedItem()).toString();
                    switch (item) {
                        case "customer":
                            setVariableCombobox("customer");
                            populateVariableComboboX();
                            break;
                        case "engagement":
                            setVariableCombobox("engagement");
                            populateVariableComboboX();
                            break;
                        case "session":
                            setVariableCombobox("session");
                            break;
                        case "transaction":
                            break;
                        case "utility":
                            break;
                        case "context":
                            break;
                    }
                }
            }
        });
        numText.getDocument().addDocumentListener(new DocumentListener() {
            String output = "";

            @Override
            public void insertUpdate(DocumentEvent e) {
                System.out.println(numText.getText());
                String input = numText.getText();
                int lastCharIndex = input.length();
                char lastChar = input.charAt(lastCharIndex - 1);
                if (use.verifyIsInt(lastChar)) {
                    output += lastChar;
                    System.out.println("rätt");
                } else {
                    numText.setText("" + input.substring(0, lastCharIndex - 1));
                    System.out.println("false");
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                Map<String, String> customerVariables = new HashMap<>();

                System.out.println(numText.getText());

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                System.out.println("c");
            }
        });
        addConditionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("clicked");

            }
        });
    }



    private void setVariableCombobox(String variableType) {
        if (variablesCombobox.getItemCount() > 0) {
            variablesCombobox.removeAllItems();
        }
        Map<String, String> variables = fetch.getVariables(variableType);
        for (Map.Entry<String, String> variable : variables.entrySet()
        ) {
            variablesCombobox.addItem(variable.getKey());
        }
    }

    public void populateVariableComboboX() {
        variablesCombobox.addItemListener(e -> {
            if (variablesCombobox.getSelectedItem() != null) {
                String variable = Objects.requireNonNull(variablesCombobox.getSelectedItem()).toString();
                setConditionCombobox(variable);
            }

        });
    }

    private void setConditionCombobox(String selectedVariable) {
        for (Map.Entry<String, String> variable : fetch.getVariables(selectedVariable).entrySet()) {
            if (selectedVariable.equals(variable.getKey())) {
                String datatype = variable.getValue();
                switch (datatype.toLowerCase()) {
                    case "string":
                        StringText.setVisible(true);
                        booleanComboBox.setVisible(false);
                        numText.setVisible(false);
                        setConditionAsString();
                        break;
                    case "boolean":
                        booleanComboBox.setVisible(true);
                        numText.setVisible(false);
                        StringText.setVisible(false);
                        setConditionAsBoolean();
                        break;
                    case "int":
                        numText.setVisible(true);
                        booleanComboBox.setVisible(false);
                        StringText.setVisible(false);
                        setConditionAsInt();

                        break;
                }
            }

        }
    }

    private void setConditionAsString() {
        conditionBox.removeAllItems();
        conditionBox.addItem("Equals");
        conditionBox.addItem("Not equals");
    }

    private void setConditionAsBoolean() {
        conditionBox.removeAllItems();
        conditionBox.addItem("is");
    }

    private void setConditionAsInt() {
        conditionBox.removeAllItems();
        conditionBox.addItem(">");
        conditionBox.addItem(">");
        conditionBox.addItem("Equals");
        conditionBox.addItem("Not equals");

    }
}
