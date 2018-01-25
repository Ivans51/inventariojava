package core.vo;

import java.util.Date;

public class Articulo {

    private int idarticulo;
    private String nombre;
    private String descripcion;
    private Double precio_venta;
    private String precio_costo;
    private String stock;
    private Date fecha_ingreso;
    private int proveedor_idproveedor;

    public int getIdarticulo() {
        return idarticulo;
    }

    public void setIdarticulo(int idarticulo) {
        this.idarticulo = idarticulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(Double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public String getPrecio_costo() {
        return precio_costo;
    }

    public void setPrecio_costo(String precio_costo) {
        this.precio_costo = precio_costo;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public int getProveedor_idproveedor() {
        return proveedor_idproveedor;
    }

    public void setProveedor_idproveedor(int proveedor_idproveedor) {
        this.proveedor_idproveedor = proveedor_idproveedor;
    }
}
