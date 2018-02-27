package core.util;

import core.vo.Articulo;
import core.vo.Cliente;

import java.util.ArrayList;
import java.util.List;

public class Atendido {

    private static List<Articulo> articulos = new ArrayList<>();
    private static Cliente cliente;
    private static ListaLabels listaLabels;
    private static boolean clienteFac;

    public static List<Articulo> getArticulos() {
        return articulos;
    }

    public static void setArticulos(List<Articulo> articulos) {
        Atendido.articulos = articulos;
    }

    public static boolean isClienteFac() {
        return clienteFac;
    }

    public static void setClienteFac(boolean clienteFac) {
        Atendido.clienteFac = clienteFac;
    }

    public static Cliente getCliente() {
        return cliente;
    }

    public static void setCliente(Cliente cliente) {
        Atendido.cliente = cliente;
    }

    public static ListaLabels getListaLabels() {
        return listaLabels;
    }

    public static void setListaLabels(ListaLabels listaLabels) {
        Atendido.listaLabels = listaLabels;
    }
}
