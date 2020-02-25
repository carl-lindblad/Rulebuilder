package GUI;
import GUI.ACTIONS.SelectActionPage;
import com.frameBuilder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class StartPage {
    frameBuilder build = new frameBuilder();
    private JLabel title = new JLabel("Write Condition/Action name");
    private JTextField ruleName = new JTextField();
    private JLabel selectTypeLabel = new JLabel("Select type");
    private JRadioButton actionRadioBtn = new JRadioButton("Action");
    private JRadioButton conditionRadioBtn = new JRadioButton("Condition");
    private JButton nextBtn = new JButton("Next");
    JComponent[] components = new JComponent[]{title, ruleName, selectTypeLabel, actionRadioBtn, conditionRadioBtn, nextBtn};
   private ArrayList<JPanel> panels = new ArrayList<>();
   private SelectActionPage buildActionPage = new SelectActionPage();
    JPanel panel = build.createPanel("start page",components);
    public void buildStartPage(){
        panels.add(panel);
        build.createFrame("Startpage",panels);
        nextBtn.setText("Testname");

        actionRadioBtn.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (actionRadioBtn.isSelected()){
                    conditionRadioBtn.setSelected(false);
                }
            }
        });
        conditionRadioBtn.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (conditionRadioBtn.isSelected()){
                    actionRadioBtn.setSelected(false);
                }
            }
        });

        nextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ruleName.getText().equals("")){
                    JOptionPane.showMessageDialog(panels.get(0),"You need to add a name");
                }
                else {
                    if (conditionRadioBtn.isSelected()){
                    }
                    if (actionRadioBtn.isSelected()){
                        buildActionPage.buildSelectActionPage();
                    }
                }

            }
        });
    }

}
