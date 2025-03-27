import java.util.Scanner;

public class Main {
    private static BinarySearchTree bstSKU = new BinarySearchTree(); // Árbol para SKU
    private static BinarySearchTree bstNombre = new BinarySearchTree(); // Árbol para nombres de producto

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n---- MENÚ ----");
            System.out.println("1. Añadir Producto");
            System.out.println("2. Mostrar Productos (por SKU o Nombre)");
            System.out.println("3. Buscar Producto (por SKU o Nombre)");
            System.out.println("4. Cargar Productos desde CSV");
            System.out.println("5. Salir");
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
                    cargarProductosDesdeCSV();
                    break;
                case 5:
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
        bstSKU.insert(sku, producto); // Insertar por SKU
        bstNombre.insert(nombre, producto); // Insertar por nombre

        System.out.println("¡Producto añadido exitosamente!");
    }

    private static void mostrarProductos(Scanner scanner) {
        System.out.print("Mostrar por (1: SKU, 2: Nombre): ");
        int eleccion = scanner.nextInt();
        scanner.nextLine(); // consumir el salto de línea

        if (eleccion == 1) {
            System.out.println("\nProductos ordenados por SKU:");
            bstSKU.recorrer(); // Mostrar por SKU
        } else if (eleccion == 2) {
            System.out.println("\nProductos ordenados por Nombre:");
            bstNombre.recorrer(); // Mostrar por Nombre
        } else {
            System.out.println("Elección inválida.");
        }
    }

    private static void buscarProducto(Scanner scanner) {
        System.out.print("Buscar por (1: SKU, 2: Nombre): ");
        int eleccion = scanner.nextInt();
        scanner.nextLine(); // consumir el salto de línea

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
    }

    private static void cargarProductosDesdeCSV() {
        // Aquí iría el código para leer y cargar productos desde un archivo CSV.
        System.out.println("Cargando productos desde archivo CSV (por implementar)...");
    }
}

