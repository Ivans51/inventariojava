package core.vo;

import java.util.Date;

public class Devolucion {

    private int cod_detallefactura;
    private String motivo;
    private Date fecha_devolucion;
    private int cantidad;
    private int detalle_factura_cod_factura;
    private int articulo_idarticulo;

    public int getCod_detallefactura() {
        return cod_detallefactura;
    }

    public void setCod_detallefactura(int cod_detallefactura) {
        this.cod_detallefactura = cod_detallefactura;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(Date fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getDetalle_factura_cod_factura() {
        return detalle_factura_cod_factura;
    }

    public void setDetalle_factura_cod_factura(int detalle_factura_cod_factura) {
        this.detalle_factura_cod_factura = detalle_factura_cod_factura;
    }

    public int getArticulo_idarticulo() {
        return articulo_idarticulo;
    }

    public void setArticulo_idarticulo(int articulo_idarticulo) {
        this.articulo_idarticulo = articulo_idarticulo;
    }
}
