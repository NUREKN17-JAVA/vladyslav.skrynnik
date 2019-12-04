package main.java.ua.nure.itkn179.skrynnik.usermanagement.gui;

import main.java.ua.nure.itkn179.skrynnik.usermanagement.User;
import main.java.ua.nure.itkn179.skrynnik.usermanagement.db.DatabaseException;
import main.java.ua.nure.itkn179.skrynnik.usermanagement.util.Messages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class AddPanel extends AbstractModifiedPanel {

    private static final String ADD_PANEL = "addPanel";
    private MainFrame parent;

    public AddPanel(MainFrame parent) {
        super(parent);
        this.parent = parent;
        this.setName(ADD_PANEL);
    }

    @Override
    protected void performAction() {
        User user = new User();
        user.setFirstName(getFirstNameField().getText());
        user.setLastName(getLastNameField().getText());
        try {
            user.setDateOfBirth(format.parse(getDateOfBirthField().getText()));
        } catch (ParseException e1) {
            getDateOfBirthField().setBackground(Color.RED);
            return;
        }
        try {
            parent.getUserDao().create(user);
        } catch (DatabaseException e1) {
            JOptionPane.showMessageDialog(this, e1.getMessage(), ERROR_TITLE,
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    protected String getConfirmButtonText() {
        return Messages.getString("addButton");
    }

}