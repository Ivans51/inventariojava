package core.util;

import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;

import javax.swing.*;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by WAMS-10 on 26/07/2017.
 */
public class Validar {
    
    public static String soloNumero = "[0-9]+", soloTexto = "[A-Za-z ]+$", soloRes = "[SN|sn]";

    public static boolean campoVacio(JTextField... txt) throws Myexception {
        boolean esValido = true;
        for (JTextField aTxt : txt) {
            if (aTxt.getText() == null || aTxt.getText().trim().isEmpty()) {
                esValido = false;
            }
        }
        if (esValido)
            return esValido;
        else
            throw new Myexception("Campo Vacío");
    }

    public static void limmpiarCampos(JTextField... txt) {
        for (JTextField aTxt : txt) {
            aTxt.setText("");
        }
    }

    /**
     * Validar una sola palabra
     */
    public static void unaPalabra(String... txt) throws Myexception {
        for (String s : txt) {
            if (s.contains(" ")) {
                String[] parts = s.split(" ");
                String part2 = parts[1];
                if (part2 != null) throw new Myexception("Campo tiene mas de una palabra");
            }
        }
    }
    
    public static boolean entradaTexto(String tipoDato, String... valor) {
        for (int i = 0; i < valor.length; i++) {
            if (!valor[i].matches(tipoDato)){
                JOptionPane.showMessageDialog(null , "Error " + valor[i] + " tipo no permitido");
                return false;
            }
        }
        return true;
    }

    public static String recuperarSegundaPalabra(String regex, String frase) throws Myexception {
        String[] parts = frase.split(regex);
        String part2 = parts[1];
        if (part2 == null) throw new Myexception("Error recuperando segundo valor");
        else return part2;
    }

    public static void hideControl(Control... control) {
        for (Control ctr : control) {
            ctr.setVisible(false);
        }
    }

    public static void entradaNumerica(TextInputControl... txt) {
        for (TextInputControl txtInput : txt) {
            txtInput.promptTextProperty().addListener((observable, oldValue, newValue) -> {
                Validar.inputNumber(txtInput, newValue);
            });
        }
    }

    private static void inputNumber(TextInputControl txt, String newValue) {
        if (!newValue.matches("\\d*")) {
            txt.setText(newValue.replaceAll("[^\\d]", ""));
        }
    }

    /**
     * Comportamiento del campo
     *
     * @param type 1: deshabilitado, 2: Visible
     */
    public static void disabledControl(int type, boolean state, Control... ctr) throws Myexception {
        for (Control control : ctr) {
            switch (type) {
                case 1:
                    control.setDisable(state);
                    break;
                case 2:
                    control.setVisible(state);
                    break;
            }
        }
    }

    public static void disabledControl(int type, boolean state, MenuItem... ctr) throws Myexception {
        for (MenuItem control : ctr) {
            switch (type) {
                case 1:
                    control.setDisable(state);
                    break;
                case 2:
                    control.setVisible(state);
                    break;
            }
        }
    }

    /**
     * Comportamiento del campo
     *
     * @param type 1: deshabilitado, 2: Visible, 3: No editable
     */
    public static void disabledInput(int type, boolean state, TextInputControl... ctr) throws Myexception {
        for (TextInputControl control : ctr) {
            switch (type) {
                case 1:
                    control.setDisable(state);
                    break;
                case 2:
                    control.setVisible(state);
                    break;
                case 3:
                    control.setEditable(state);
            }
        }
    }

    public static void compararStringIguales(String[] valorUno, String... valorDos) throws Myexception {
        for (int i = 0; i < valorUno.length; i++)
            if (valorUno[i].equals(valorDos[i]))
                throw new Myexception("Los valores no son iguales");
    }

    public static void comboBoxVacio(ComboBox... comboBoxes) throws Myexception {
        for (ComboBox comboBox : comboBoxes) {
            boolean isMyComboBoxEmpty = comboBox.getSelectionModel().isEmpty();
            if (isMyComboBoxEmpty)
                throw new Myexception("Selecciona una opcion");
        }
    }

    public static void datePickerVacio(DatePicker... datePickers) throws Myexception {
        for (DatePicker datePicker : datePickers) {
            if (datePicker.getValue() == null)
                throw new Myexception("Fecha No correcta");
        }
    }

    public static void datePickerRango(Date value) throws Myexception, ParseException {
        /*int years = FechaUtil.getYearsDiff(value);
        if (years <= 18 || years >= 50)
            throw new Myexception("Debe tener una edad entre 18 y 50");*/
    }

    public static void compararStringIguales(String[] valorUno, TextField... valorDos) throws Myexception {
        for (int i = 0; i < valorUno.length; i++) {
            String text = valorDos[i].getText();
            if (!valorUno[i].equals(text))
                throw new Myexception("Los valores no son iguales");
        }
    }

    public static String quitarEspaciosVacios(TextInputControl txt) throws Myexception {
        return txt.getText().replaceAll("\\s+", "");
    }

    private static void soloNumero(TextInputControl txt) throws Myexception {
        txt.textProperty().addListener((observable, oldValue, newValue) -> {
            // if (!newValue.matches("\\d*")) {
            if (!newValue.matches("[0-9]*")) {
                txt.setText(newValue.replaceAll("[0-9]*", ""));
            }
        });
    }

    private static void isNumerico(TextInputControl txt) throws Myexception {
        txt.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) { // when focus lost
                if (!txt.getText().matches("[1-5](\\.[0-9]{1,2}){0,1}|6(\\.0{1,2}){0,1}")) {
                    // when it not matches the pattern (1.0 - 6.0)
                    // set the txt empty
                    txt.setText("");
                }
            }
        });
    }

    public static void isNumber(String... number) throws Myexception {
        for (String s : number) {
            if (!s.matches("\\d+(\\.\\d{1,4})?")) {
                throw new Myexception("El campo no puede contener texto");
            }
        }
    }

    public static void isLetter(String... name) throws Myexception {
        for (String s : name) {
            if (!s.matches("^[\\p{L} .'-]+$"))
                throw new Myexception("El campo no puede contener numeros");
        }
    }

    public static void isLetterSpeed(String... name) throws Myexception {
        for (String s : name) {
            char[] chars = s.toCharArray();
            for (char c : chars) {
                if (Character.isLetter(c))
                    throw new Myexception("El campo no puede contener numeros");
            }
        }
    }

    /* Numeric Validation Limit the  characters to maxLengh AND to ONLY DigitS *************************************/
    public EventHandler<KeyEvent> numeric_Validation(final Integer max_Lengh) throws Myexception {
        return e -> {
            TextField txt_TextField = (TextField) e.getSource();
            if (txt_TextField.getText().length() >= max_Lengh) {
                e.consume();
            }
            if (e.getCharacter().matches("[0-9.]")) {
                if (txt_TextField.getText().contains(".") && e.getCharacter().matches("[.]")) {
                    e.consume();
                } else if (txt_TextField.getText().length() == 0 && e.getCharacter().matches("[.]")) {
                    e.consume();
                }
            } else {
                e.consume();
            }
        };
    }

    /*****************************************************************************************/

 /* Letters Validation Limit the  characters to maxLengh AND to ONLY Letters *************************************/
    public EventHandler<KeyEvent> letter_Validation(final Integer max_Lengh) throws Myexception {
        return e -> {
            TextField txt_TextField = (TextField) e.getSource();
            if (txt_TextField.getText().length() >= max_Lengh) {
                e.consume();
            }
            if (e.getCharacter().matches("[A-Za-z]")) {
            } else {
                e.consume();
            }
        };
    }
}
