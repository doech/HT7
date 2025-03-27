/**
 * Ale Sierra #24405
 * Clase que representa un producto y sus atributos.
 */
public class Producto {
    private String sku;
    private String nombre;
    private String descripcion;
    private String cantidadesPorTalla;

    /**
     * constructor que permite establecer los artributos al crear un producto
     *
     * @param sku             
     * @param nombre           
     * @param descripcion        
     * @param cantidadesPorTalla 
     */
    public Producto(String sku, String nombre, String descripcion, String cantidadesPorTalla) {
        this.sku = sku;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidadesPorTalla = cantidadesPorTalla;
    }

    /**
     * Gettters y Setters de los atributos de la clase Producto 
     * que permitan acceder y modificar los atributos de un producto desde 
     * otra clase.
     *
     * @return el valor del atributo
     */
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


    /**
     * override que permite imprimir los detalles del producto como string
     *
     * @return un string
     */
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

