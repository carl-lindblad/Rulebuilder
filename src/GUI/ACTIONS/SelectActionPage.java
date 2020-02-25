package GUI.ACTIONS;

import com.frameBuilder;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class SelectActionPage {
    private JLabel actionTypeLabel = new JLabel("Choose Action type");
    private JComboBox<String> actionTypeCombobox = new JComboBox<>();

    private JLabel subActionTypeLabel = new JLabel("Select section");
    private JComboBox<String> subActionTypeCombobox = new JComboBox<>();
    private frameBuilder create = new frameBuilder();
    private ArrayList<JPanel> components = new ArrayList<>();

    public void buildSelectActionPage(){

        actionTypeCombobox.addItem("action");
        subActionTypeCombobox.addItem("Condition");
        components.add(create.createPanel("Select subAction", new JComponent[]{subActionTypeLabel, subActionTypeCombobox}));
        components.add(create.createPanel("SelectAction", new JComponent[]{actionTypeLabel, actionTypeCombobox}));
        create.createFrame("Select action page", components);
    }
}
