import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CargarArchivo {

    public void cargarProductos(String archivo, BinarySearchTree bstSKU, BinarySearchTree bstNombre) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(","); // Separador basado en espacios

                // Validar que la línea tenga al menos 4 columnas
                if (partes.length < 4) {
                    System.out.println("Línea inválida en el archivo: " + linea);
                    continue; // Saltar a la siguiente línea
                }

                String sku = partes[0];
                String nombre = partes[1];
                String descripcion = partes[2];
                String cantidadesPorTalla = partes[3]; // Se espera que el archivo contenga las cantidades en formato "XS|S|M|L|XL"

                Producto producto = new Producto(sku, nombre, descripcion, cantidadesPorTalla);

                // Insertar el producto en ambos árboles
                bstSKU.insert(sku, producto);
                bstNombre.insert(nombre, producto);
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}

