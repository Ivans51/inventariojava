package core.util;

import core.vo.Articulo;
import java.util.ArrayList;
import java.util.List;

public class Atendido {

    private static List<Articulo> articulos = new ArrayList<>();
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
}
