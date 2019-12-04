package main.java.ua.nure.itkn179.skrynnik.usermanagement.gui;

import main.java.ua.nure.itkn179.skrynnik.usermanagement.User;
import main.java.ua.nure.itkn179.skrynnik.usermanagement.util.Messages;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserTableModel  extends AbstractTableModel {
    private List<User> users;
    @Override
    public int getRowCount() {
        return users.size();
    }
    private final String[] COLUMN_NAMES = new String[]{Messages.getString("id"), Messages.getString("name"),
            Messages.getString("lastName")};
    private final Class[] COLUMN_CLASSES = {Long.class, String.class, String.class};
    public UserTableModel(Collection<User> users) {
        this.users = new ArrayList<>(users);
    }
    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }
    public Object getValueAt(int rowIndex, int columnIndex) {
        User user = users.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return user.getId();
            case 1:
                return user.getFirstName();
            case 2:
                return user.getLastName();
            default:
                return null;
        }
    }
    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return COLUMN_CLASSES[columnIndex];
    }
}
