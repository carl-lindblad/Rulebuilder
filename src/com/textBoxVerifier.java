package com;

import javax.swing.*;

public class textBoxVerifier extends InputVerifier {
    Services use = new Services();
    @Override
    public boolean verify(JComponent input) {
        System.out.println("asdad");
        String numValue = ((JTextField) input).getText();
        try {
            System.out.println("aaaaaa");
            return use.verifyIsInt(numValue.charAt(0));
        }
        catch (NumberFormatException e){
            System.out.println("fa" );
            return false;
        }
    }
}
