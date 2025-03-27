import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Ale Sierra #24405
 * clase que controla la carga de productos desde un archivo CSV
 * y los inserta en un árbol binario de búsqueda.
 */
public class CargarArchivo {

    /**
     * método que lee el archivo e identifica las partes de cada línea al separarlas por coma
     * y crea un producto con los atributos de la línea, el cual se inserta en el árbol.
     * @param archivo 
     * @param bst     
     */
    public void cargarProductos(String archivo, BinarySearchTree<String, Producto> bst) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length < 4) {
                    System.out.println("Línea inválida en el archivo: " + linea);
                    continue;
                }

                String sku = partes[0];
                String nombre = partes[1];
                String descripcion = partes[2];
                String cantidadesPorTalla = partes[3];

                Producto producto = new Producto(sku, nombre, descripcion, cantidadesPorTalla);
                bst.insert(sku, producto);
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}

