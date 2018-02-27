package core.util;

import javax.swing.*;

public class ListaLabels {
    private JLabel lblNombreCliente;
    private JLabel lblTelefono;
    private JLabel lblApellido;

    public JLabel getLblNombreCliente() {
        return lblNombreCliente;
    }

    public void setLblNombreCliente(JLabel lblNombreCliente) {
        this.lblNombreCliente = lblNombreCliente;
    }

    public JLabel getLblTelefono() {
        return lblTelefono;
    }

    public void setLblTelefono(JLabel lblTelefono) {
        this.lblTelefono = lblTelefono;
    }

    public JLabel getLblApellido() {
        return lblApellido;
    }

    public void setLblApellido(JLabel lblApellido) {
        this.lblApellido = lblApellido;
    }
}
