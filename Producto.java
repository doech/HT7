
public class Producto {
    private String sku;
    private String nombre;
    private String descripcion;
    private String cantidadesPorTalla;

    // Constructor que coincide con los parámetros usados en Main.java
    public Producto(String sku, String nombre, String descripcion, String cantidadesPorTalla) {
        this.sku = sku;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidadesPorTalla = cantidadesPorTalla;
    }

    // Getters y setters (opcional, si los necesitas)
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
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

    public String getCantidadesPorTalla() {
        return cantidadesPorTalla;
    }

    public void setCantidadesPorTalla(String cantidadesPorTalla) {
        this.cantidadesPorTalla = cantidadesPorTalla;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "sku='" + sku + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", cantidadesPorTalla='" + cantidadesPorTalla + '\'' +
                '}';
    }
}

