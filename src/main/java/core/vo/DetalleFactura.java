package core.vo;

public class DetalleFactura {

    private int cod_factura;
    private int cantidad;
    private Double total;
    private int factura_idfactura;

    public int getCod_factura() {
        return cod_factura;
    }

    public void setCod_factura(int cod_factura) {
        this.cod_factura = cod_factura;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public int getFactura_idfactura() {
        return factura_idfactura;
    }

    public void setFactura_idfactura(int factura_idfactura) {
        this.factura_idfactura = factura_idfactura;
    }
}
