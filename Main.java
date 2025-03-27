import java.util.Scanner;

public class Main {
    private static BinarySearchTree bstSKU = new BinarySearchTree(); // Árbol para SKU
    private static BinarySearchTree bstNombre = new BinarySearchTree(); // Árbol para nombres de producto

    public static void main(String[] args) {
        // Cargar productos desde el archivo CSV al iniciar el programa
        String archivo = "productos.csv"; // Asegúrate de que el archivo esté en el directorio correcto
        CargarArchivo cargador = new CargarArchivo();
        cargador.cargarProductos(archivo, bstSKU, bstNombre);

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("MENÚ");
            System.out.println("1. Añadir Producto");
            System.out.println("2. Mostrar Productos (por SKU o Nombre)");
            System.out.println("3. Buscar Producto (por SKU o Nombre)");
            System.out.println("4. Salir");
            System.out.print("Elija una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // consumir el salto de línea

            switch (opcion) {
                case 1:
                    añadirProducto(scanner);
                    break;
                case 2:
                    mostrarProductos(scanner);
                    break;
                case 3:
                    buscarProducto(scanner);
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }

        scanner.close();
    }

    private static void añadirProducto(Scanner scanner) {
        System.out.print("Ingrese SKU: ");
        String sku = scanner.nextLine();
        System.out.print("Ingrese Nombre del Producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese Descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingrese Cantidades por talla (XS|S|M|L|XL): ");
        String cantidadesPorTalla = scanner.nextLine();

        Producto producto = new Producto(sku, nombre, descripcion, cantidadesPorTalla);
        bstSKU.insert(sku, producto); 
        bstNombre.insert(nombre, producto); 

        System.out.println("Producto añadido");
    }

    private static void mostrarProductos(Scanner scanner) {
        System.out.print("Mostrar por (1: SKU, 2: Nombre): ");
        int eleccion = scanner.nextInt();
        scanner.nextLine(); 

        if (eleccion == 1) {
            System.out.println("\nProductos ordenados por SKU:");
            bstSKU.recorrer(); 
        } else if (eleccion == 2) {
            System.out.println("\nProductos ordenados por Nombre:");
            bstNombre.recorrer(); 
        } else {
            System.out.println("Elección inválida.");
        }
    }

    private static void buscarProducto(Scanner scanner) {
        System.out.print("Buscar por (1: SKU, 2: Nombre): ");
        if (scanner.hasNextInt()) { // Validar que la entrada sea un número
            int eleccion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            if (eleccion == 1) {
                System.out.print("Ingrese el SKU: ");
                String sku = scanner.nextLine();
                Producto producto = bstSKU.search(sku);
                if (producto != null) {
                    System.out.println("Producto encontrado: " + producto);
                } else {
                    System.out.println("Producto no encontrado.");
                }
            } else if (eleccion == 2) {
                System.out.print("Ingrese el Nombre: ");
                String nombre = scanner.nextLine();
                Producto producto = bstNombre.search(nombre);
                if (producto != null) {
                    System.out.println("Producto encontrado: " + producto);
                } else {
                    System.out.println("Producto no encontrado.");
                }
            } else {
                System.out.println("Elección inválida.");
            }
        } else {
            System.out.println("Entrada inválida. Por favor, ingrese 1 para SKU o 2 para Nombre.");
            scanner.nextLine(); // Consumir la entrada inválida
        }
    }

}

