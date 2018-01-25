package core.tablemodel;

import core.vo.Cliente;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ClienteTableModel extends AbstractTableModel{
    private List<Cliente> clientes;
    private String[] col;

    public ClienteTableModel(List<Cliente> clientes) {
        super();
        this.clientes = clientes;
        col = new String[]{"cedula", "apellidos", "direccion", "nombre_ciudad", "nombres"};
    }

    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return col.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente club = clientes.get(rowIndex);
        switch(columnIndex) {
            case 0: return club.getCedula();
            case 1: return club.getApellidos();
            case 2: return club.getDireccion();
            case 3: return club.getNombre_ciudad();
            case 4: return club.getNombres();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return col[column];
    }
}
