import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CargarArchivo {

    /**
     * Carga los productos desde un archivo CSV y los inserta en un árbol binario de búsqueda.
     *
     * @param archivo Ruta del archivo CSV.
     * @param bst Árbol binario de búsqueda donde se insertarán los productos.
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

